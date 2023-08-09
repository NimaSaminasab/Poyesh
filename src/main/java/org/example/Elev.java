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

    private long id;
    private String fornavn;
    private String etternavn;
    private String personnummer;
    private String telefon1;
    private String telefon2;
    private String telefon3;
    private String by;
    private String fDato;
    private String skolenavn;
    private int behovSumPrManed;
    private double motattSumTilNa;
    private boolean harSupporter;
    private boolean aktiv;
    private String bilde;
    private String film;

    @OneToMany(mappedBy = "elev", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ElevSupporter> elevSupporters = new ArrayList<>();

    @OneToMany(mappedBy = "elev", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Betaling> betalingList = new ArrayList<>();

    @ManyToOne
    private Family family;

    @OneToMany(mappedBy = "elev", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BankInfo> bankInfoList = new ArrayList<>();


    public Elev(String fornavn, String etternavn, String personnummer, String telefon1, String telefon2,
                String telefon3, String by, String fDato,
                String skolenavn, int behovSumPrManed, double motattSumTilNa,
                String bilde, String film) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.personnummer = personnummer;
        this.by = by;
        this.fDato = fDato;
        this.skolenavn = skolenavn;
        this.behovSumPrManed = behovSumPrManed;
        this.motattSumTilNa = motattSumTilNa;
        this.telefon1 = telefon1;
        this.telefon2 = telefon2;
        this.telefon3 = telefon3;
        this.bilde = bilde;
        this.film = film;
        aktiv = true;

    }

    public Elev() {
    }

    public boolean addFamilyToElev(Family f) {
        if (f.isAktiv()) {
            family = f;
            return true;
        } else
            return false;
    }

}
