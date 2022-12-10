package board02.sidePro.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;


@DisplayName("DB 연결 테스트")
public class CommonDaoImpl {

    Logger log = LoggerFactory.getLogger(getClass());

    @Value("{spring.datasource.url}")
    String url;

    @Value("{spring.datasource.username}")
    String username;

    @Value("{spring.datasource.password}")
    String password;

    @Test
    void connTest(){
        /*
        String query = "select count(*) from Member";

        Assertions.assertThat(url).isEqualTo("jdbc:mysql://localhost:3306/study?serverTimezone=Asia/Seoul&characterEncoding=utf8");


        try(Connection conn = DriverManager.getConnection(url, username, password)){
            Assertions.assertThat(conn.prepareStatement(query).executeQuery()).isEqualTo(0);

        }catch (Exception e){
            e.printStackTrace();
        }*/
    }
}
