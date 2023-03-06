package com.hibernate.dvdlibrary.controller;

import com.hibernate.dvdlibrary.entity.Dvd;
import com.hibernate.dvdlibrary.service.DvdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DvdController {

    @Autowired
    private DvdService service;

    @PostMapping("/dvd/create")
    public Dvd createDvd(@RequestBody Dvd dvd) {
        return service.createDvd(dvd);
    }

    @GetMapping("/dvd/{id}")
    public Dvd getDvdById(@PathVariable int id) {
        System.out.println("I totally worked!!!");
        return service.getDvdById(id);
    }

    @GetMapping("/dvds")
    public List<Dvd> getAllDvds() {
        String greeting = "I totally worked!!!";
        System.out.println(greeting);
        return service.getAllDvds();
    }

    @PutMapping("/dvd/update")
    public Dvd updateDvd(@RequestBody Dvd dvd) {
        return service.updateDvd(dvd);
    }

    @DeleteMapping("/dvd/delete/{id}")
    public String deleteDvd(@PathVariable int id) {
        return service.deleteDvdById(id);
    }

}
