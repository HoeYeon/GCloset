package com.gcloset.web.domain.ootd

import com.gcloset.web.domain.cloth.Cloth
import com.gcloset.web.domain.cloth.ClothRepository
import com.gcloset.web.domain.user.User
import com.gcloset.web.resolver.UserArgumentResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.mock.mockito.MockBean
import spock.lang.Specification

import java.time.LocalDateTime

@DataJpaTest
class OotdRepositoryTest extends Specification {
    @MockBean
    private UserArgumentResolver userArgumentResolver;
    @Autowired
    OotdRepository ootdRepository;

    @Autowired
    ClothRepository clothRepository;

    def "FindByUser"() {
        given:
        def user = User.builder()
                .name("a")
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
