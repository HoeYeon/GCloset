package com.gcloset.web.domain.cloth;

import com.gcloset.security.UserPrincipal;
import com.gcloset.web.domain.user.User;
import com.gcloset.web.domain.user.UserRepository;
import com.gcloset.web.enums.ClothType;
import com.gcloset.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothService {

    private final ClothRepository clothRepository;

    private final UserRepository userRepository;

    public ClothService(ClothRepository clothRepository,UserRepository userRepository){
        this.clothRepository = clothRepository;
        this.userRepository = userRepository;
    }

    public List<Cloth> findClothList(UserPrincipal userPrincipal){
        User user = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
        return clothRepository.findByUser(user);
    }

    public void addClothList(UserPrincipal userPrincipal, List<ClothType> clothTypeList){
        User user = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
        System.out.println(user.getId());
        System.out.println(user.getEmail());
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
