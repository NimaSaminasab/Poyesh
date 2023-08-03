package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Family {
    @Id
    @GeneratedValue
    long id ;
    private String farFornavn ;
    private String farEtternavn ;
    private String morFornavn ;
    private String morEtternavn ;

    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Elev> elevList = new ArrayList<>();
    private int sumMotatt ;

    public Family(String farFornavn, String farEtternavn, String morFornavn, String morEtternavn, int sumMotatt) {
        this.farFornavn = farFornavn;
        this.farEtternavn = farEtternavn;
        this.morFornavn = morFornavn;
        this.morEtternavn = morEtternavn;
        this.sumMotatt = sumMotatt;
    }
    public Family(){}
}
