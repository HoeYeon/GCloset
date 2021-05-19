package com.gcloset.web.domain.event

import com.gcloset.web.domain.cloth.Cloth
import com.gcloset.web.domain.cloth.ClothRepository
import com.gcloset.web.domain.friend.Friend
import com.gcloset.web.domain.ootd.Ootd
import com.gcloset.web.domain.user.User
import com.gcloset.web.resolver.UserArgumentResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.mock.mockito.MockBean
import spock.lang.Specification

import java.time.LocalDateTime

@DataJpaTest
class EventRepositoryTest extends Specification {

    @MockBean
    private UserArgumentResolver userArgumentResolver;

    @Autowired
    EventRepository eventRepository

    @Autowired
    ClothRepository clothRepository

    def "FindByUser"() {
        given:
        def user = User.builder()
                .name("user1")
                .email("test@gmail.com")
                .build()

        def friend = Friend.builder()
                .name("Hong")
                .user(user)

        ["jeans", "shirts", "Cap"].each { type ->
            clothRepository.save(Cloth.builder()
                    .clothType(type)
                    .user(user)
                    .build())
        }

        def cloths = clothRepository.findByUser(user)
        def ootd1 = Ootd.builder()
                .user(user)
                .cloths(cloths)
                .build()
        def event = Event.builder()
                .memo("ootd1")
                .friend_name(friend.name)
                .ootd(ootd1)
                .user(user)
                .build()

        eventRepository.save(event)

        when:
        def re1 = eventRepository.findByUser(user)
        def re3 = eventRepository.findByUserAndFriend(user, friend.name)
        def re4 = eventRepository.findByUserAndOotd(user, ootd1)

        then:
        re1.size() == 1
        re3.size() == 1
        re4.size() == 1
        re4.every { it.memo == "ootd1" }

    }
}
