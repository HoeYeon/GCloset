package com.gcloset.web.domain.cloth;

import com.gcloset.web.domain.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothService {

    private final ClothRepository clothRepository;

    public ClothService(ClothRepository clothRepository){
        this.clothRepository = clothRepository;
    }

    public List<Cloth> findClothList(User user){
        return clothRepository.findByUser(user);
    }

}
