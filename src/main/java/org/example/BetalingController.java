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

    @PostMapping("/createBetaling")
    @ResponseBody
    public String createBetaling(@RequestBody Betaling betaling) throws Exception {
        if (betaling != null) {
            Elev elev = elevService.findElevById(betaling.getElev().getId());
            int betaltTilNa = 0;
            Supporter supporter = supporterService.findSupporterById(betaling.getSupporter().getId());
            if (elev != null && supporter != null) {
                betaling.setElev(elev);
                elev.setMotattSumTilNa(elev.getMotattSumTilNa()+betaling.getBelop());
                betaling.setSupporter(supporter);
                betalingService.createBetaling(betaling);
                elev.getBetalingList().add(betaling);
                supporter.getBetalingList().add(betaling);
                betaltTilNa = supporter.getBetaltTilNa();
                betaltTilNa += betaling.getBelop();
                supporter.setBetaltTilNa(betaltTilNa);
                supporterService.supporterRepository.save(supporter) ;
                elevService.elevRepository.save(elev);
                return "ok";
            }
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

    @GetMapping("/findAllBetaling")
    @ResponseBody
    public List<Betaling> findAllBetaling() {
        return betalingService.findAllBetaling();
    }


}
