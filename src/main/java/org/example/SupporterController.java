package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SupporterController {
    @Autowired
    SupporterService supporterService ;

    @PostMapping("/createSupporter")
    @ResponseBody
    public String createSupporter(@RequestBody Supporter supporter) throws Exception {
        if (supporter != null) {
            supporterService.createSupporter(supporter);
            return "ok";
        } else
            return "error";
    }

    @DeleteMapping("/deleteSupporter/{id}")
    @ResponseBody
    public String deleteSupporterById(@PathVariable long id) throws Exception {
        System.out.println("hei");
        if (id > 0) {
            Supporter supporter = supporterService.findSupporterById(id);
            if (supporter != null) {
                return supporterService.deleteSupporter(supporter);
            } else
                return "Couldn´t find Costumer with id " + id;
        } else
            return "No valid id";
    }

    @GetMapping("/findASupporterById/{id}")
    @ResponseBody
    public Supporter findASupporterById(@PathVariable long id) {
        if (id > 0) {
            return supporterService.findSupporterById(id);
        }
        return null;
    }
    @GetMapping("/findAllSupporter")
    @ResponseBody
    public List<Supporter> findAllSupporter() {
        return supporterService.findAllElev();
    }
    @PutMapping("/updateSupporter/{supporterId}")
    @ResponseBody
    public Supporter updateElev(@RequestBody Supporter supporter,@PathVariable long supporterId) throws Exception {
        return supporterService.updateSupporter(supporter,supporterId) ;
    }
}
