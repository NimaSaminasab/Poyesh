package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ElevController {
    @Autowired
    ElevService elevService ;

    @PostMapping("/createElev")
    @ResponseBody
    public String createElev(@RequestBody Elev elev) throws Exception {
        if (elev != null) {
            elevService.createElev(elev);
            return "ok";
        } else
            return "error";
    }

    @DeleteMapping("/deleteElev/{id}")
    @ResponseBody
    public String deleteElevById(@PathVariable long id) throws Exception {
        System.out.println("hei");
        if (id > 0) {
            Elev elev = elevService.findElevById(id);
            if (elev != null) {
                return elevService.deleteElev(elev);
            } else
                return "Couldn´t find Costumer with id " + id;
        } else
            return "No valid id";
    }

    @GetMapping("/findAElevById/{id}")
    @ResponseBody
    public Elev findAElevById(@PathVariable long id) {
        if (id > 0) {
            return elevService.findElevById(id);
        }
        return null;
    }
    @GetMapping("/findAllElev")
    @ResponseBody
    public List<Elev> findAllElev() {
        return elevService.findAllElev();
    }

    @PutMapping("/updateElev/{elevId}")
    @ResponseBody
    public Elev updateElev(@RequestBody Elev elev,@PathVariable long elevId) throws Exception {
        return elevService.updateElev(elev,elevId) ;
    }
}
