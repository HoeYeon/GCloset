package com.gcloset.web.domain.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JUserRepositoryTest {
    private final String email = "test@gmail.com";

    @Autowired
    UserRepository userRepository;

    @Before
    public void init(){
        User user = userRepository.save(User.builder()
                .name("HoeYeon")
                .email(email)
                .password("test")
                .build()
        );
    }
    @Test
    public void findByEmail() {
        User user = userRepository.findByEmail(email);
        assertThat(user.getEmail(),is(email));
    }
}