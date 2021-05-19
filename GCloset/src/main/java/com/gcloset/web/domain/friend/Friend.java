package com.gcloset.web.domain.friend;

import com.gcloset.web.domain.BaseTimeEntity;
import com.gcloset.web.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Friend extends BaseTimeEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String name;

    @Builder
    public Friend(String name, User user) {
        this.name = name;
        this.user = user;
    }
}
