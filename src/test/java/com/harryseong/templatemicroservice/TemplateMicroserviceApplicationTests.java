package com.harryseong.templatemicroservice;

import com.harryseong.templatemicroservice.controller.ApiControllerV1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TemplateMicroserviceApplicationTests {

    @Autowired
    private ApiControllerV1 apiControllerV1;

	@Test
	void contextLoads() throws Exception {
        assertThat(apiControllerV1).isNotNull();
	}

}
