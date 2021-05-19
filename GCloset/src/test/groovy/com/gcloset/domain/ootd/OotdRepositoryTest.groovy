package com.gcloset.domain.ootd

import com.gcloset.domain.cloth.Cloth
import com.gcloset.domain.cloth.ClothRepository
import com.gcloset.domain.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

import java.time.LocalDateTime

@DataJpaTest
class OotdRepositoryTest extends Specification {

    @Autowired
    OotdRepository ootdRepository;

    @Autowired
    ClothRepository clothRepository;

    def "FindByUser"() {
        given:
        def user = User.builder()
                .first_name("user1")
                .last_name("a")
                .email("test@gmail.com")
                .password("123")
                .build()

        ["jeans", "shirts", "Cap"].each { type ->
            clothRepository.save(Cloth.builder()
                    .clothType(type)
                    .user(user)
                    .build())
        }

        def cloths = clothRepository.findByUser(user)
        ootdRepository.save(Ootd.builder()
                .user(user)
                .cloths(cloths)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build())
        when:
        def re = ootdRepository.findByUser(user)

        then:
        re.get(0).cloths.size() == 3
        re.get(0).cloths.get(0).clothType == "jeans"
        re.get(0).cloths.get(1).clothType == "shirts"
        re.get(0).cloths.get(2).clothType == "Cap"
    }
}
