package com.gcloset.domain.cloth

import com.gcloset.domain.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

@DataJpaTest
class ClothRepositoryTest extends Specification {

    @Autowired
    ClothRepository clothRepository

    def "check Many to One"(){
        given:
        def user = new User("s","a","test@gmail.com","123")

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
