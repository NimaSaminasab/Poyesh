package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BetalingController {

    @Autowired
    BetalingService betalingService;
    @Autowired
    ElevService elevService;
    @Autowired
    SupporterService supporterService;
    @Autowired
    FamilyService familyService;
    @Autowired
    CurrencyExchangeService currencyExchangeService;


    @PostMapping("/createBetaling")
    @ResponseBody
    public String createBetaling(@RequestBody Betaling betaling) throws Exception {
        if (betaling != null) {
            Elev elev = elevService.findElevById(betaling.getElev().getId());
            if (elev.isAktiv()) {
                double betaltTilNa = 0;
                double sumMotatt = 0;
                Supporter supporter = supporterService.findSupporterById(betaling.getSupporter().getId());
                if (supporter.isAktiv()) {
                    if (elev != null && supporter != null) {
                        betaling.setElev(elev);
                        elev.setMotattSumTilNa(elev.getMotattSumTilNa() + betaling.getBelop());
                        betaling.setSupporter(supporter);
                        betalingService.createBetaling(betaling);
                        elev.getBetalingList().add(betaling);
                        supporter.getBetalingList().add(betaling);
                        betaltTilNa = supporter.getBetaltTilNa();
                        betaltTilNa += betaling.getBelop();
                        supporter.setBetaltTilNa(betaltTilNa);
                        supporterService.supporterRepository.save(supporter);
                        elevService.elevRepository.save(elev);
                        Family family = elev.getFamily();
                        if(family!=null) {
                            sumMotatt = family.getSumMotatt() + betaling.getBelop();
                            family.setSumMotatt(sumMotatt);
                            familyService.familyRepository.save(family);
                        }
                        return "ok";
                    } else
                        return "error";
                } else
                    return "Supporter is inactive";
            } else
                return "elev is inactiv";
        }
        return "error";
    }
    @DeleteMapping("/deleteBetaling/{id}")
    @ResponseBody
    public String deleteBetalingById(@PathVariable long id) throws Exception {
        if (id > 0) {
            Betaling betaling = betalingService.findABetalingById(id);
            if (betaling != null) {
                return betalingService.deleteBetaling(betaling);
            } else
                return "Couldn´t find Costumer with id " + id;
        } else
            return "No valid id";
    }

    @GetMapping("/findABetalingById/{id}")
    @ResponseBody
    public Betaling findABetalingById(@PathVariable long id) {
        if (id > 0) {
            return betalingService.findABetalingById(id);
        }
        return null;
    }

    @GetMapping("/findABetaling/")
    @ResponseBody
    public List<Betaling> findABetaling(@RequestBody Betaling betaling) {
        Betaling betaling1 = null ;
        if (betaling.getId() > 0) {
            return betalingService.findABetalingById2(betaling.getId() );
        }
        else if(betaling.getFakturaNummer()!=null){
            return betalingService.findABetalingByFakturanummer(betaling.getFakturaNummer()) ;
        }
        else if(betaling.getDato()!=null){
            betalingService.findABetalingByDate(betaling.getDato() ) ;
        }

        return null;
    }


    @GetMapping("/findAllBetaling")
    @ResponseBody
    public List<Betaling> findAllBetaling() {
        return betalingService.findAllBetaling();
    }


}
