package board02.sidePro.service.Member.Join.serviceInterface;

import board02.sidePro.dto.Member.MemberDto;
import board02.sidePro.dto.Member.MemberGradeDto;

public interface MemberJoinService {

    MemberGradeDto getGrade();

    int join(MemberDto memberDto);

    void findById(String id);

    void findByNickName(String nickname);


}

