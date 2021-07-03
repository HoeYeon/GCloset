package com.gcloset.web.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gcloset.web.domain.BaseTimeEntity;
import com.gcloset.web.enums.AuthProvider;
import com.gcloset.web.enums.SocialType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
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

    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId;

    @Builder
    public User(String name,
                String email,
                String password,
                String principal,
                AuthProvider provider) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.principal = principal;
        this.provider = provider;
    }

    public User update(String name) {
        this.name = name;
        return this;
    }
}
