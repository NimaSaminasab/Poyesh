package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FamilyController {
    @Autowired
    FamilyService familyService;

    @Autowired
    ElevService elevService;

    @PostMapping("/createFamily")
    @ResponseBody
    public Family createFamily(@RequestBody Family family) throws Exception {
        if (family != null) {
            return familyService.createFamily(family);
        }
        return null;
    }

    @DeleteMapping("/deleteFamily/{id}")
    @ResponseBody
    public String deleteFamilyById(@PathVariable long id) throws Exception {
        if (id > 0) {
            Family family = familyService.findFamilyById(id);
            if (family != null) {
                return familyService.deleteFamily(family);
            } else
                return "Couldn´t find Costumer with id " + id;
        } else
            return "No valid id";
    }

    @GetMapping("/findAFamilyById/{id}")
    @ResponseBody
    public Family findAFamilyById(@PathVariable long id) {
        if (id > 0) {
            return familyService.findFamilyById(id);
        }
        return null;
    }

    @GetMapping("/findAllFamily")
    @ResponseBody
    public List<Family> findAllFamily() {
        return familyService.findAllFamily();
    }


}
