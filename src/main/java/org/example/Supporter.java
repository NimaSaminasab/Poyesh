package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "supporter")
    @JsonIgnore
    private List<ElevSupporter> elevSupporters = new ArrayList<>();


    public Supporter(String fornavn, String etternavn, int betaltTilNa) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.betaltTilNa = betaltTilNa;
    }
    public Supporter(){}
}
