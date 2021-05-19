package com.gcloset.web.domain.cloth

import com.gcloset.web.domain.user.User
import com.gcloset.web.resolver.UserArgumentResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.mock.mockito.MockBean
import spock.lang.Specification

import java.time.LocalDateTime

@DataJpaTest
class ClothRepositoryTest extends Specification {
    @MockBean
    private UserArgumentResolver userArgumentResolver;
    @Autowired
    ClothRepository clothRepository

    def "check Many to One"(){
        given:
        def user = User.builder()
                .name("HoeYeon")
                .email("test@gmail.com")
                .build()

        def cloth1 = new Cloth("jean",user)
        def cloth2 = new Cloth("shirts",user)
        clothRepository.save(cloth1)
        clothRepository.save(cloth2)

        when:
        def cloths = clothRepository.findByUser(user)

        then:
        cloths.every { it.user == user }
    }
}
