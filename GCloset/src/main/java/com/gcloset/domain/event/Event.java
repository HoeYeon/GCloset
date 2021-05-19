package com.gcloset.domain.event;

import com.gcloset.domain.BaseTimeEntity;
import com.gcloset.domain.ootd.Ootd;
import com.gcloset.domain.user.User;
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

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Builder
    public Event(String memo, String friend_name, Ootd ootd, User user,LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.memo = memo;
        this.friend = friend_name;
        this.ootd = ootd;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


}
