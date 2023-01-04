package board02.sidePro.mapper;

import board02.sidePro.dto.Member.MemberDto;
import board02.sidePro.dto.Member.MemberGradeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<MemberGradeDto> getGrade();

    int join(@Param("member") MemberDto memberDto);

    Integer findById(@Param("id") String id);

    Integer findByNickName(@Param("nickname") String nickname);

}
