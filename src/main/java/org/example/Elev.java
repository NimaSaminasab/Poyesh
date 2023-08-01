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
public class Elev {
    @Id
    @GeneratedValue

    private long id ;
    private String fornavn ;
    private String etternavn ;
    private String personnummer ;
    private String fDato ;
    private String skolenavn ;
    private String farFornavn ;
    private String farEtternavn ;
    private String morFornavn ;
    private String morEtternavn ;
    private int behovSumPrManed ;
    private int motattSumTilNa ;
    private boolean harSupporter ;
    private String bilde ;
    private String film ;

    @OneToMany(mappedBy = "elev")
    @JsonIgnore
    private List<ElevSupporter> elevSupporters = new ArrayList<>() ;

    public Elev(String fornavn, String etternavn, String personnummer, String fDato,
                String skolenavn, String farFornavn, String farEtternavn, String morFornavn,
                String morEtternavn, int behovSumPrManed, int motattSumTilNa,
                String bilde, String film) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.personnummer = personnummer;
        this.fDato = fDato;
        this.skolenavn = skolenavn;
        this.farFornavn = farFornavn;
        this.farEtternavn = farEtternavn;
        this.morFornavn = morFornavn;
        this.morEtternavn = morEtternavn;
        this.behovSumPrManed = behovSumPrManed;
        this.motattSumTilNa = motattSumTilNa;
        this.bilde = bilde;
        this.film = film;
    }
    public Elev(){}


}
