package com.gcloset.web.domain.cloth;

import com.gcloset.security.CurrentUser;
import com.gcloset.security.UserPrincipal;
import com.gcloset.web.domain.cloth.dto.AddClothDto;
import com.gcloset.web.domain.user.User;
import com.gcloset.web.enums.ClothType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.gcloset.web.enums.ClothType.fromString;

@RestController
public class ClothController {

    @Autowired
    ClothService clothService;

    @GetMapping("/api/v1/clothList")
    @PreAuthorize("hasRole('USER')")
    public List<Cloth> findClothList(@CurrentUser UserPrincipal userPrincipal){
        return clothService.findClothList(userPrincipal);
    }

    @PostMapping("/api/v1/clothList")
    @PreAuthorize("hasRole('USER')")
    public Boolean addCloth(@CurrentUser UserPrincipal userPrincipal, @RequestBody AddClothDto addClothDto){
        List<ClothType> clothTypeList = addClothDto.getClothDtoList().stream()
                .map(cloth -> fromString(cloth.getClothType()))
                .collect(Collectors.toList());
        clothService.addClothList(userPrincipal,clothTypeList);
        return Boolean.TRUE;
    }
}
