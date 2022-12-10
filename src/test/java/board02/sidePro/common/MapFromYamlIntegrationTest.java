package board02.sidePro.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MapFromYamlIntegrationTest {


    @Autowired
    PropertiesManager propertiesManager;

    @Test
    @DisplayName("configuration db properties 읽기")
    void 프로퍼티_맵_전환(){
        propertiesManager.getDatasource();

    }




}
