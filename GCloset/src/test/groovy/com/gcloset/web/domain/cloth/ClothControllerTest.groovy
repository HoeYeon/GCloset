package com.gcloset.web.domain.cloth

import com.fasterxml.jackson.databind.ObjectMapper
import com.gcloset.web.domain.cloth.dto.AddClothDto
import com.gcloset.web.domain.cloth.dto.ClothDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClothControllerTest extends Specification {

    @Autowired
    ApplicationContext context

    private MockMvc mvc

    @Autowired
    ClothRepository clothRepository

    def setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }
    @WithMockUser(authorities = "ROLE_GOOGLE")
    def "FindClothList"() {

        given:
//        def request = new AddClothDto(clothDtoList:[new ClothDto(clothType: "Jean"),new ClothDto(clothType: "Shoes")])
        def request = "{\"clothDtoList\":[{\"clothType\":\"Jean\"},{\"clothType\":\"Shoes\"}]}"

        println(new ObjectMapper().writeValueAsString(request))

        when:
        mvc.perform(post("/api/v1/clothList")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(request))

        def res = clothRepository.findAll()

        then:
        res.size() == 2
        res.each { ["Jean","Shoes"].contains(it.clothType)}
    }

    def "AddCloth"() {
    }
}
