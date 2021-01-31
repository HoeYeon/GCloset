package com.gcloset.domain.ootd

import com.gcloset.domain.cloth.Cloth
import com.gcloset.domain.friend.Friend
import com.gcloset.domain.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

@DataJpaTest
class OotdRepositoryTest extends Specification {

    @Autowired
    OotdRepository ootdRepository;

    def "FindByUser"() {
        given:
        def user = new User("user1", "a", "test@gmail.com", "123")
        def user2 = new User("user2", "a", "test@gmail.com", "123")

        def cloth1 = new Cloth("jean", user)
        def cloth2 = new Cloth("shirts", user)
        def cloth3 = new Cloth("Cap", user2)

        def cloths = new ArrayList<Cloth>();
        cloths.add(cloth1);
        cloths.add(cloth2);
        cloths.add(cloth3);

        def ootd1 = new Ootd(user, cloths)
        ootdRepository.save(ootd1)
        when:
        def re = ootdRepository.findByUser(user)

        then:
        re.get(0).cloths.size() == 3
        re.get(0).cloths.get(0) == cloth1
        re.get(0).cloths.get(1) == cloth2
        re.get(0).cloths.get(2) == cloth3
    }
}
