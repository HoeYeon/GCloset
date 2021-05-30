package com.gcloset.web.domain.cloth;

import com.gcloset.web.domain.user.User;
import com.gcloset.web.enums.ClothType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothService {

    private final ClothRepository clothRepository;

    public ClothService(ClothRepository clothRepository){
        this.clothRepository = clothRepository;
    }

    public List<Cloth> findClothList(User user){
        return clothRepository.findByUser(user);
    }

    public void addClothList(User user, List<ClothType> clothTypeList){
        List<Cloth> clothList = clothTypeList.stream()
                .map(clothType ->
                    Cloth.builder()
                            .clothType(clothType.name())
                            .user(user)
                            .build())
                .collect(Collectors.toList());
        clothRepository.saveAll(clothList);
    }

}
