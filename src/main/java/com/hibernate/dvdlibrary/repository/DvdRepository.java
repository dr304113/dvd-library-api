package com.hibernate.dvdlibrary.repository;

import com.hibernate.dvdlibrary.entity.Dvd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DvdRepository extends JpaRepository<Dvd, Integer> {

//    void createDvd(Dvd dvd);
//
//    List<Dvd> getAllDvds();
//
//    Dvd getDvdById(int id);
//
//    void deleteDvdById(int id);
//
//    void updateDvd(Dvd dvd);

}
