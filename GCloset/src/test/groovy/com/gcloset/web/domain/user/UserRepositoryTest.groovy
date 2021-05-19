package com.gcloset.web.domain.user

import com.gcloset.web.resolver.UserArgumentResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.mock.mockito.MockBean
import spock.lang.Specification

@DataJpaTest
class UserRepositoryTest extends Specification {
    def email = "test@gmail.com"

    @MockBean
    private UserArgumentResolver userArgumentResolver;

    @Autowired
    UserRepository userRepository

    def "FindByEmail"() {
        given:

        when:
        userRepository.save(User.builder()
                .name("HoeYeon")
                .email(email)
                .build()
        )
        def user = userRepository.findByEmail(email)

        then:
        user.getName() == "HoeYeon"
        user.getEmail() == "test@gmail.com"


    }
}
