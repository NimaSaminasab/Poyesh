package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Betaling {
    @Id
    @GeneratedValue
    private long id ;
    private String fakturaNummer ;
    private double belop;
    private double toman ;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date dato ;
    @ManyToOne
    Elev elev ;
    @ManyToOne
    Supporter supporter ;
    @ManyToOne
    CurrencyExchange currencyExchange ;

    public Betaling(String fakturaNummer, int belop, Date dato,
                    Elev elev, Supporter supporter) {
        this.fakturaNummer = fakturaNummer;
        this.belop = belop;
        this.dato = dato;
        this.elev = elev;
        this.supporter = supporter;
    }
    public Betaling(){}
}
