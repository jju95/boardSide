package board02.sidePro.service.Member.Join;

import board02.sidePro.common.exception.ErrorCode;
import board02.sidePro.common.exception.Join.customException.AlreadyUserException;
import board02.sidePro.common.exception.Join.customException.AlreadyUserNickNameException;
import board02.sidePro.common.exception.Join.customException.NotSuchElementException;
import board02.sidePro.dto.Member.MemberDto;
import board02.sidePro.dto.Member.MemberGradeDto;
import board02.sidePro.mapper.MemberMapper;
import board02.sidePro.service.Member.Join.serviceInterface.MemberJoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service("memberService")
@Transactional
@RequiredArgsConstructor
public class MemberJoinServiceImpl implements MemberJoinService {

    private final MemberMapper memberMapper;

    @Override
    public MemberGradeDto getGrade() {
        List<MemberGradeDto> list = memberMapper.getGrade();
        MemberGradeDto dto = list.stream()
                .filter(key -> key.getGrade_name().equals("basic"))
                .findFirst()
                .orElseThrow(()->{
                    throw new NotSuchElementException("memberGradeDto not such element" ,
                            ErrorCode.NOT_SUCH_ELEMENT_ERROR);
                });

        return dto;
    }

    @Override
    public int join(MemberDto memberDto) {
        MemberGradeDto gradeDto = getGrade();
        memberDto.setGrade_code(getGrade().getGrade_code());
        findById(memberDto.getId());
        findByNickName(memberDto.getNickname());
        memberMapper.join(memberDto);
        return 0;
    }

    @Override
    public void findById(String id) {
        if(memberMapper.findById(id)>0){
            throw new AlreadyUserException("AlreadyUserInfo",
                    ErrorCode.INVALID_JOIN_ID);
        }
    }

    @Override
    public void findByNickName(String nickname) {
        if(memberMapper.findByNickName(nickname)>0){
            throw new AlreadyUserNickNameException("AlreadyUserInfo",
                    ErrorCode.INVALID_JOIN_NICKNAME);

        }
    }

}
