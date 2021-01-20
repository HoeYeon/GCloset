package com.gcloset.domain.event;

import com.gcloset.domain.ootd.Ootd;
import com.gcloset.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByUser(User user);

    List<Event> findByUserAndOotd(User user, Ootd ootd);

    List<Event> findByUserAndFriend(User user, String friend_name);
}
