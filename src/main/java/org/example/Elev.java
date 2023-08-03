package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    private int behovSumPrManed ;
    private int motattSumTilNa ;
    private boolean harSupporter ;
    private String bilde ;
    private String film ;

    @OneToMany(mappedBy = "elev", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ElevSupporter> elevSupporters = new ArrayList<>() ;

    @ManyToOne
    private Family family;

    @OneToMany(mappedBy = "elev", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BankInfo> bankInfoList = new ArrayList<>() ;



    public Elev(String fornavn, String etternavn, String personnummer, String fDato,
                String skolenavn, int behovSumPrManed, int motattSumTilNa,
                String bilde, String film) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.personnummer = personnummer;
        this.fDato = fDato;
        this.skolenavn = skolenavn;
        this.behovSumPrManed = behovSumPrManed;
        this.motattSumTilNa = motattSumTilNa;
        this.bilde = bilde;
        this.film = film;

    }
    public Elev(){}




}
