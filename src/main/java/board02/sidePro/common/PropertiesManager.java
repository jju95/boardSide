package board02.sidePro.common;

import board02.sidePro.dto.FilePathDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@Slf4j
@ConfigurationProperties(prefix = "spring")
public class PropertiesManager {

    private Map<String, String> datasource;

    public Map<String , String> getDatasource(){
        return datasource;
    }

    public void setDatasource(Map<String, String> datasource) {
        this.datasource = datasource;
    }

    private Map<String, FilePathDto> mvc;

    public Map<String, FilePathDto> getMvc(){
        return mvc;
    }

    public void setMvc(Map<String, FilePathDto> mvc){
        this.mvc = mvc;
    }
}
