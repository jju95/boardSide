package board02.sidePro.controller;

import board02.sidePro.dto.Member.MemberDto;
import board02.sidePro.dto.utils.Response;
import board02.sidePro.service.Member.Join.MemberJoinServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberJoinController {

    private final MemberJoinServiceImpl memberService;

    @ResponseBody
    @PostMapping("/join")
    public Response<String> doJoin(MemberDto memberDto){
        log.info("member service");
        memberService.join(memberDto);
        return Response.success("ok");
    }

}
