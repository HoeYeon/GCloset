package com.gcloset.web.domain.user;

import com.gcloset.web.domain.BaseTimeEntity;
import com.gcloset.web.enums.SocialType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Long cloth_num = 0L;

    @Column(nullable = false)
    private String email;

    @Column
    private String principal;

    @Column
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Builder
    public User(String name,
                String email,
                String password,
                String principal,
                SocialType socialType) {
        this.name = name;
        this.email = email;
        this.principal = principal;
        this.socialType = socialType;
    }

    public User update(String name) {
        this.name = name;
        return this;
    }
}
