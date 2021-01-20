package com.gcloset.domain.ootd;

import com.gcloset.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OotdRepository extends JpaRepository<Ootd, Long> {
    List<Ootd> findByUser(User user);
}
