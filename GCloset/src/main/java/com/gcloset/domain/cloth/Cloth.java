package com.gcloset.domain.cloth;

// id, type, createdAt, updatedAt, userId

import com.gcloset.domain.BaseTimeEntity;
import com.gcloset.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Cloth extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Cloth(String type, User user){
        this.type = type;
        this.user = user;
    }
}
