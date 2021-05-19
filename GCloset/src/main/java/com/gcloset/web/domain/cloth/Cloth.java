package com.gcloset.web.domain.cloth;

// id, type, createdAt, updatedAt, userId

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
public class Cloth extends BaseTimeEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String clothType;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Cloth(String clothType, User user){
        this.clothType = clothType;
        this.user = user;
    }
}
