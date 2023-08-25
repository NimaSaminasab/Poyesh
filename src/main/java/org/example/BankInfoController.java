package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BankInfoController {
    @Autowired
    BankInfoService bankInfoService;
    @Autowired
    ElevService elevService;

    @PostMapping("/createBankInfo")
    @ResponseBody
    public String createBankInfo(@RequestBody BankInfo bankInfo) throws Exception {
        Elev elev = elevService.findElevById(bankInfo.getElev().getId());
        if (!elev.isAktiv())
            return "Elev is inactive";
        if (bankInfo != null) {
            bankInfoService.createBankInfo(bankInfo);
            return "ok";
        } else
            return "error";
    }

    @DeleteMapping("/deleteBankInfo/{id}")
    @ResponseBody
    public String deleteBankInfoById(@PathVariable long id) throws Exception {
        if (id > 0) {
            BankInfo bankInfo = bankInfoService.findBankInfoById(id);
            if (bankInfo != null) {
                return bankInfoService.deleteBankInfo(bankInfo);
            } else
                return "Couldn´t find Costumer with id " + id;
        } else
            return "No valid id";
    }

    @GetMapping("/findABankInfoById/{id}")
    @ResponseBody
    public BankInfo findABankInfoById(@PathVariable long id) {
        if (id > 0) {
            return bankInfoService.findBankInfoById(id);
        }
        return null;
    }

    @GetMapping("/findABankInfo/{searchWord}")
    @ResponseBody
    public BankInfo findABankInfo(@PathVariable String searchWord) {
        BankInfo bankInfo = null;

        if (searchWord != null) {
            bankInfo = bankInfoService.findBankInfoByKontonummer(searchWord);
            if (bankInfo == null) {
                bankInfo = bankInfoService.findBankInfoByShebaNummer(searchWord);
                if (bankInfo == null) {
                    bankInfo = bankInfoService.findBankInfoByKortNummer(searchWord);
                    if(bankInfo==null){
                        bankInfo = bankInfoService.findBankInfoByKortHoldersNavn(searchWord);
                    }
                }
            }
        }
        return bankInfo;
    }


    @GetMapping("/findAllBankInfo")
    @ResponseBody
    public List<BankInfo> findAllBankInfo() {
        return bankInfoService.findAllBankInfo();
    }


}
