package com.gcloset.domain.ootd;

import com.gcloset.domain.BaseTimeEntity;
import com.gcloset.domain.cloth.Cloth;
import com.gcloset.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Ootd extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cloths_id")
    private List<Cloth> cloths = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Ootd(User user, List<Cloth> cloths) {
        this.user = user;
        this.cloths.addAll(cloths);
    }
}
