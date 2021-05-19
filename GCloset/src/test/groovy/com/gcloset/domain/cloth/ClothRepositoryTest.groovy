package com.gcloset.domain.cloth

import com.gcloset.domain.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

import java.time.LocalDateTime

@DataJpaTest
class ClothRepositoryTest extends Specification {

    @Autowired
    ClothRepository clothRepository

    def "check Many to One"(){
        given:
        def user = new User("s","a","test@gmail.com","123", LocalDateTime.now(),LocalDateTime.now())

        def cloth1 = new Cloth("jean",user, LocalDateTime.now(),LocalDateTime.now())
        def cloth2 = new Cloth("shirts",user, LocalDateTime.now(),LocalDateTime.now())
        clothRepository.save(cloth1)
        clothRepository.save(cloth2)

        when:
        def cloths = clothRepository.findByUser(user)

        then:
        cloths.every { it.user == user }
    }
}
