package com.gcloset.web.domain.cloth

import com.gcloset.web.domain.user.User
import com.gcloset.web.enums.ClothType
import com.gcloset.web.enums.SocialType
import com.gcloset.web.resolver.UserArgumentResolver
import org.springframework.boot.test.mock.mockito.MockBean
import spock.lang.Specification

class ClothServiceTest extends Specification {

    // 인증 무시용
    @MockBean
    UserArgumentResolver userArgumentResolver

    def clothRepository = Mock(ClothRepository.class)
    def sut = new ClothService(clothRepository)

    def "FindClothList"() {
        given:
        def user = User.builder()
                .email("tmp")
                .name("Son")
                .principal("principal")
                .socialType(SocialType.GOOGLE)
                .build()
        def cloth = Cloth.builder()
                .clothType(ClothType.JEAN.name())
                .user(user)
                .build()
        clothRepository.findByUser(user) >> [cloth.clothType]


        when:
        def res = sut.findClothList(user)

        then:
        res == [ClothType.JEAN.name()]
    }

}
