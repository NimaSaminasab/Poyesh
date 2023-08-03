package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Betaling {
    @Id
    @GeneratedValue
    private long id ;
    private String fakturaNummer ;
    private double belop ;
    private String dato ;
    @ManyToOne
    Elev elev ;
    @ManyToOne
    Supporter supporter ;

    public Betaling(String fakturaNummer, double belop, String dato,
                    Elev elev, Supporter supporter) {
        this.fakturaNummer = fakturaNummer;
        this.belop = belop;
        this.dato = dato;
        this.elev = elev;
        this.supporter = supporter;
    }
    public Betaling(){}
}