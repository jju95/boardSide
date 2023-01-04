package board02.sidePro.common.config;

import board02.sidePro.common.utils.PropertiesManager;
import board02.sidePro.dto.utils.FilePathDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
public class FrontCoinfig {

    private final PropertiesManager propertiesManager;

    FilePathDto filePathDto;

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver irv = new InternalResourceViewResolver();
        irv.setPrefix(filePathDto.getPrefix());
        irv.setSuffix(filePathDto.getSuffix());

        return irv;
    }

    @PostConstruct
    void init(){
        ObjectMapper objectMapper = new ObjectMapper();
        filePathDto = objectMapper.convertValue(propertiesManager.getMvc().get("view"), FilePathDto.class);
    }
}
