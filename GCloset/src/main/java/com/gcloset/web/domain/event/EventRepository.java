package com.gcloset.web.domain.event;

import com.gcloset.web.domain.ootd.Ootd;
import com.gcloset.web.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByUser(User user);

    List<Event> findByUserAndOotd(User user, Ootd ootd);

    List<Event> findByUserAndFriend(User user, String friend_name);
}
