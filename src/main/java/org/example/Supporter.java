package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Supporter {
    @Id
    @GeneratedValue
    private long id ;
    private String fornavn ;
    private String etternavn ;
    private int betaltTilNa ;

    public Supporter(String fornavn, String etternavn, int betaltTilNa) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.betaltTilNa = betaltTilNa;
    }
    public Supporter(){}
}
