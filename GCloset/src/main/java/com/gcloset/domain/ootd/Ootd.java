package com.gcloset.domain.ootd;

import com.gcloset.domain.BaseTimeEntity;
import com.gcloset.domain.cloth.Cloth;
import com.gcloset.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Ootd extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "outer_id")
    private Cloth outer;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "top_id")
    private Cloth top;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "bottom_id")
    private Cloth bottom;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "shoes_id")
    private Cloth shoes;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private User user;

    //Todo have to change more elegant
    @Builder
    public Ootd(User user, Cloth outer, Cloth top, Cloth bottom, Cloth shoes) {
        this.user = user;
        this.outer = outer;
        this.top = top;
        this.bottom = bottom;
        this.shoes = shoes;
    }
}
