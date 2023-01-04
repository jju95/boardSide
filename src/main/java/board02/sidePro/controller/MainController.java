package board02.sidePro.controller;

import board02.sidePro.common.utils.PropertiesManager;
import board02.sidePro.dto.utils.FilePathDto;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        ObjectMapper objectMapper = new ObjectMapper();
        FilePathDto path = objectMapper.convertValue(propertiesManager.getMvc().get("view"), FilePathDto.class);

        prefix = path.getPrefix();
        suffix = path.getSuffix();
    }

}
