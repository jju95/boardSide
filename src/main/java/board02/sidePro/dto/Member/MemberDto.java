package board02.sidePro.dto.Member;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    String id;
    String password;
    String passwordOk;
    String nickname;
    String grade_code;

}
