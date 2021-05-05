package com.tiger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiger.common.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;


/**
 * 指定当前生效的配置文件( active profile)，如果是 appplication-dev.yml 则 dev
 **/
@ActiveProfiles("dev")
@SpringBootTest(classes = AdminApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test() throws IOException {
        String json = "{\"id_user\":123,\"mobile\":\"123456789\",\"username\":\"json在线解析\"}";
        UserInfo userInfo = new ObjectMapper().readValue(json.getBytes(), UserInfo.class);
        System.out.println(userInfo);
    }
}
