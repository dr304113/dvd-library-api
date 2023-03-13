package com.hibernate.dvdlibrary.service;

import com.hibernate.dvdlibrary.entity.Dvd;
import com.hibernate.dvdlibrary.repository.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DvdService {

    @Autowired
    private DvdRepository repository;

    public Dvd createDvd(Dvd dvd) {
        return repository.save(dvd);
    }

    public List<Dvd> getAllDvds() {
        return repository.findAll();
    }

    public Dvd getDvdById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteDvdById(int id) {
        repository.deleteById(id);
        return "Dvd removed || id: " + id;
    }

    public Dvd updateDvd(Dvd dvd) {
        Dvd existingDvd = repository.findById(dvd.getId()).orElse(null);
        existingDvd.setTitle(dvd.getTitle());
        existingDvd.setDirector(dvd.getDirector());
        existingDvd.setRating(dvd.getRating());
        existingDvd.setNotes(dvd.getNotes());
        existingDvd.setPicture(dvd.getPicture());
        return repository.save(existingDvd);
    }

}
