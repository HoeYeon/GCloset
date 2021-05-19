package com.gcloset;

import com.gcloset.web.resolver.UserArgumentResolver;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class GaonClosetApplicationTests {
    @MockBean
    private UserArgumentResolver userArgumentResolver;

    @Test
    void contextLoads() {
    }

}
