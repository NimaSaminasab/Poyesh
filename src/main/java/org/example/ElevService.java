package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElevService {
    @Autowired
    ElevRepository elevRepository;

    public Elev createElev(Elev elev) throws Exception {
        if (elev == null) {
            throw new Exception("Elev is null");
        }
        return elevRepository.save(elev);
    }

    public String deleteElev(Elev elev) throws Exception {
        if (elev == null) {
            throw new Exception("Elev is null");
        }
        String elevFullNavn = elev.getFornavn() +" " +  elev.getEtternavn();
        elevRepository.delete(elev);
        return elevFullNavn + " is deleted";
    }

    public Elev findElevById(long id) {
        return elevRepository.findById(id).orElse(null);
    }

    public List<Elev> findAllElev() {
        return (List<Elev>) elevRepository.findAll();
    }

    public Elev updateElev(Elev elev, long elevId) {
        Elev elevOld = elevRepository.findById(elevId).orElse(null);
        if (elevOld != null) {
            if (elev.getFornavn() != null) {
                elevOld.setFornavn(elev.getFornavn());
            }
            if (elev.getEtternavn() != null) {
                elevOld.setEtternavn(elev.getEtternavn());
            }
            if (elev.getPersonnummer() != null) {
                elevOld.setPersonnummer(elev.getPersonnummer());
            }
            if (elev.getFDato() != null) {
                elevOld.setFDato(elev.getFDato());
            }
            if (elev.getSkolenavn() != null) {
                elevOld.setSkolenavn(elev.getSkolenavn());
            }
            if (elev.getFarFornavn() != null) {
                elevOld.setFarFornavn(elev.getFarFornavn());
            }
            if (elev.getFarEtternavn() != null) {
                elevOld.setFarEtternavn(elev.getFarEtternavn());
            }
            if (elev.getMorFornavn() != null) {
                elevOld.setMorFornavn(elev.getMorFornavn());
            }
            if (elev.getMorEtternavn() != null) {
                elevOld.setMorEtternavn(elev.getMorEtternavn());
            }
            if (elev.getBehovSumPrManed() != 0) {
                elevOld.setBehovSumPrManed(elev.getBehovSumPrManed());
            }
            if (elev.getMotattSumTilNa() != 0) {
                elevOld.setMotattSumTilNa(elev.getMotattSumTilNa());
            }
            if (elev.getBilde() != null) {
                elevOld.setBilde(elev.getBilde());
            }
            if (elev.getFilm() != null) {
                elevOld.setFilm(elev.getFilm());
            }
            elevRepository.save(elevOld);
            return elevOld;
        }
        else {
             return null ;
        }
    }
}
