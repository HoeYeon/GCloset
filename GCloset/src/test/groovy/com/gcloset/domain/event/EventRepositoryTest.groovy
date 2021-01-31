package com.gcloset.domain.event

import com.gcloset.domain.cloth.Cloth
import com.gcloset.domain.friend.Friend
import com.gcloset.domain.ootd.Ootd
import com.gcloset.domain.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

@DataJpaTest
class EventRepositoryTest extends Specification {

    @Autowired
    EventRepository eventRepository

    def "FindByUser"() {
        given:
        def user = new User("user1", "a", "test@gmail.com", "123")
        def user2 = new User("user2", "a", "test@gmail.com", "123")
        def friend = new Friend("Hong", user)
        def friend2 = new Friend("Son", user2)

        def cloth1 = new Cloth("jean", user)
        def cloth2 = new Cloth("shirts", user)
        def cloth3 = new Cloth("Cap", user2)

        def cloths = new ArrayList<Cloth>();
        cloths.add(cloth1);
        cloths.add(cloth2);
        cloths.add(cloth3);

        def ootd1 = new Ootd(user, cloths)
        def ootd2 = new Ootd(user,  cloths)
        def ootd3 = new Ootd(user2, cloths)

        def event = new Event("ootd1", friend.name, ootd1, user)
        def event2 = new Event("test2", friend2.name, ootd2, user2)
        def event3 = new Event("ootd1", friend.name, ootd1, user)

        eventRepository.save(event)
        eventRepository.save(event2)
        eventRepository.save(event3)

        when:
        def re1 = eventRepository.findByUser(user)
        def re2 = eventRepository.findByUser(user2)
        def re3 = eventRepository.findByUserAndFriend(user, friend.name)
        def re4 = eventRepository.findByUserAndOotd(user, ootd1)

        then:
        re1.size() == 2
        re2.size() == 1
        re3.size() == 2
        re4.size() == 2
        re4.every { it.memo == "ootd1" }

    }
}
