package org.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class ElevSupporter {
    @Id
    @GeneratedValue
    long id ;
    @ManyToOne
    private Elev elev;

    @ManyToOne
    private Supporter supporter;
    int belopBetalt ;

    public ElevSupporter(Elev elev, Supporter supporter, int belopBetalt) {
        this.elev = elev;
        this.supporter = supporter;
        this.belopBetalt = belopBetalt;
    }
    public ElevSupporter(){}
}
