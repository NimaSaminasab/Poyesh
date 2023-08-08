package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CurrencyExchangeController {
    @Autowired
    CurrencyExchangeService currencyExchangeService ;

    @PostMapping("/createCurrencyExchange")
    @ResponseBody
    public CurrencyExchange createCurrencyExchange(CurrencyExchange currencyExchange){
        return currencyExchangeService.createCurrencyExchange(currencyExchange) ;
    }

    @DeleteMapping("/deleteCurrencyExchange")
    @ResponseBody
    public String deleteCurrencyExchange(CurrencyExchange currencyExchange){
        if(currencyExchange==null)
            return "error" ;
        currencyExchangeService.deleteCurrencyExchange(currencyExchange);
        return "ok" ;
    }
    @GetMapping("/findCurrencyExchangeById/{id}")
    @ResponseBody
    public CurrencyExchange findCurrencyById(@PathVariable long id){
        return currencyExchangeService.findCurrencyExchangeById(id) ;
    }
    @GetMapping("findAllCurrencyExchange")
    @ResponseBody
    public List<CurrencyExchange> findAllCurrencyExchange(){
       return currencyExchangeService.findAllCurrencyExchange() ;
    }

}
