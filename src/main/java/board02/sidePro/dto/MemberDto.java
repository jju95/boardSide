package board02.sidePro.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDto {

    String id;
    String password;
    String nickname;


    public MemberDto(String id, String nickname, String password){
        this.id = id;
        this.nickname = nickname;
        this.password = password;
    }
}
