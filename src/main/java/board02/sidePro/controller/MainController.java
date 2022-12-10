package board02.sidePro.controller;

import board02.sidePro.common.PropertiesManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {

    private final PropertiesManager propertiesManager;

    private String prefix;

    private String suffix;

    @GetMapping(value={"home", "/"})
    public String goHome(){
        return prefix+"index"+suffix;
    }

    @GetMapping("/join")
    public String goJoin(){
        return prefix+"/member/join"+suffix;
    }

    @GetMapping("/board")
    public String goBoard(){
        return prefix+"/board/list"+suffix;
    }

    @PostConstruct
    void init(){
        prefix = propertiesManager.getMvc().get("view").getPrefix();
        suffix = propertiesManager.getMvc().get("view").getSuffix();
    }
}
