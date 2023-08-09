package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CurrencyExchangeController {
    @Autowired
    CurrencyExchangeService currencyExchangeService;
    @Autowired
    BetalingService betalingService;



    @PostMapping("/createCurrencyExchange")
    @ResponseBody
    public CurrencyExchange createCurrencyExchange(@RequestBody CurrencyExchange currencyExchange) {
         List<Betaling> betalingList = betalingService.findAllBetaling();
        System.out.println(betalingList.size());
        for (int i = 0; i < betalingList.size(); i++) {
            System.out.println(betalingList.get(i).getToman());
            if (betalingList.get(i).getToman() == 0.0) {
                betalingList.get(i).setToman(betalingList.get(i).getBelop() * currencyExchange.realityRate());
                System.out.println(betalingList.get(i).getToman());
                betalingService.betalingRepository.save(betalingList.get(i)) ;
            }

        }


        return currencyExchangeService.createCurrencyExchange(currencyExchange);
    }

    @DeleteMapping("/deleteCurrencyExchange")
    @ResponseBody
    public String deleteCurrencyExchange(CurrencyExchange currencyExchange) {
        if (currencyExchange == null)
            return "error";
        currencyExchangeService.deleteCurrencyExchange(currencyExchange);
        return "ok";
    }

    @GetMapping("/findCurrencyExchangeById/{id}")
    @ResponseBody
    public CurrencyExchange findCurrencyById(@PathVariable long id) {
        return currencyExchangeService.findCurrencyExchangeById(id);
    }

    @GetMapping("findAllCurrencyExchange")
    @ResponseBody
    public List<CurrencyExchange> findAllCurrencyExchange() {
        return currencyExchangeService.findAllCurrencyExchange();
    }

}
