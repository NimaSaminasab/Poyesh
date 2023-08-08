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
@Setter
@Getter
public class CurrencyExchange {
    @Id
    @GeneratedValue

    private long id ;
    String date ;
    double nok ;
    double toman ;
    double kurs ;
    double gebyr ;

    @OneToMany(mappedBy = "currencyExchange")
    @JsonIgnore
    private List<Betaling> betalingList = new ArrayList<>();


    public CurrencyExchange(String date, double nok, double toman, double kurs, double gebyr) {
        this.date = date;
        this.nok = nok;
        this.toman = toman;
        this.kurs = kurs;
        this.gebyr = gebyr;
    }
    public CurrencyExchange(){}
}