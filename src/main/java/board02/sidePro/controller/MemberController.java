package board02.sidePro.controller;

import board02.sidePro.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    @ResponseBody
    @PostMapping("/join")
    public MemberDto doJoin(MemberDto memberDto){

        return memberDto;
    }
}
