package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElevSupporterService {
    @Autowired
    ElevSupporterRepository elevSupporterRepository ;

    public ElevSupporter createElevSupporter(ElevSupporter elevSupporter){
        return elevSupporterRepository.save(elevSupporter) ;
    }
    public String deleteElevSupporter(ElevSupporter elevSupporter){
        if(elevSupporter!=null){
            long id = elevSupporter.id ;
            elevSupporterRepository.delete(elevSupporter);
            return id + " is deleted" ;
        }
        return "not found " ;
    }
    public ElevSupporter findElevSupporterById(long id){
        return elevSupporterRepository.findById(id).orElse(null);
    }
    public List<ElevSupporter> findAllElevSupporter(){
        return (List<ElevSupporter>) elevSupporterRepository.findAll();
    }
}
