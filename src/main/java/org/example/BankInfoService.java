package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankInfoService {
    @Autowired
    BankInfoRepository bankInfoRepository ;

    public BankInfo createBankInfo(BankInfo bankInfo){
        if(bankInfo!= null) {
            return bankInfoRepository.save(bankInfo);
        }
        return null ;
    }
    public String deleteBankInfo(BankInfo bankInfo){
        if(bankInfo !=null){
            bankInfoRepository.delete(bankInfo);
        }
        return null ;
    }
    public BankInfo findBankInfoById(long id){
        return bankInfoRepository.findById(id).orElse(null);
    }
    public List<BankInfo> findAllBankInfo(){
       return (List<BankInfo>) bankInfoRepository.findAll();
    }
}
