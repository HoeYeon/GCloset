package com.gcloset.web.domain.event;

import com.gcloset.web.domain.BaseTimeEntity;
import com.gcloset.web.domain.ootd.Ootd;
import com.gcloset.web.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Event extends BaseTimeEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String memo;

    @Column
    private String friend;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ootd_id")
    private Ootd ootd;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Event(String memo, String friend_name, Ootd ootd, User user) {
        this.memo = memo;
        this.friend = friend_name;
        this.ootd = ootd;
        this.user = user;
    }


}
