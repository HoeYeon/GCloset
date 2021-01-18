package com.gcloset.domain.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

@DataJpaTest
class UserRepositoryTest extends Specification {
    def email = "test@gmail.com"

    @Autowired
    UserRepository userRepository

    def "FindByEmail"() {
        given:

        when:
        userRepository.save(User.builder()
                .first_name("HoeYeon")
                .last_name("Son")
                .email(email)
                .password("test")
                .build()
        )
        def user = userRepository.findByEmail(email)

        then:
        user.getFirst_name() == "HoeYeon"
        user.getLast_name() == "Son"
        user.getEmail() == "test@gmail.com"


    }
}
