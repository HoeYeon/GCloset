package com.gcloset.domain.cloth;

import com.gcloset.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClothRepository extends JpaRepository<Cloth,Long> {
    List<Cloth> findByUser(User user);
}
