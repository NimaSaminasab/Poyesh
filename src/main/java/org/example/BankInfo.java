package org.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

public class BankInfo {
    @Id
    @GeneratedValue
    private long id ;
    private String bankNavn ;
    private String kontoHoldersNavn ;
    private String kontoNummer ;
    private String shebaNummber ;
    private String kortNummber ;

    @ManyToOne
    private Elev elev ;

    public BankInfo(String bankNavn, String kontoHoldersNavn,
                    String kontoNummer, String shebaNummber,
                    String kortNummber, Elev elev) {
        this.bankNavn = bankNavn;
        this.kontoHoldersNavn = kontoHoldersNavn;
        this.kontoNummer = kontoNummer;
        this.shebaNummber = shebaNummber;
        this.kortNummber = kortNummber;
        this.elev = elev;
    }
    public BankInfo(){}
}
