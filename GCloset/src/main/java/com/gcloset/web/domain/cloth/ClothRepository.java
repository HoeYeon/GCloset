package com.gcloset.web.domain.cloth;

import com.gcloset.web.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClothRepository extends JpaRepository<Cloth,Long> {
    List<Cloth> findByUser(User user);
}
