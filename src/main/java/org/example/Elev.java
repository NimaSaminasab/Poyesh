package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

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
