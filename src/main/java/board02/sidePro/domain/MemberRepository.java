package board02.sidePro.domain;

import board02.sidePro.dto.MemberDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {
    private static final Map<Long, MemberDto> member = new HashMap<>();
    private static long sequence = 0L;

    public MemberDto join(MemberDto memberDto){
        member.put(sequence, memberDto);
        return memberDto;
    }

}
