package com.hibernate.dvdlibrary;

import com.hibernate.dvdlibrary.entity.Dvd;
import com.hibernate.dvdlibrary.repository.DvdRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private DvdRepository dvdRepository;
    @Override
    public void run(String...args) throws Exception {

//        dvdRepository.save(new Dvd("Ramesh", "Fadatare", "ramesh@gmail.com"));
//        dvdRepository.save(new Employee("Tom", "Cruise", "tom@gmail.com"));
//        dvdRepository.save(new Employee("John", "Cena", "john@gmail.com"));
//        dvdRepository.save(new Employee("tony", "stark", "stark@gmail.com"));


        dvdRepository.findById(1).ifPresent(System.out::println);

        // get list of Dvds
        List<Dvd> dvds = dvdRepository.findAll();
        dvds.forEach(dvd -> System.out.println(dvd.toString()));

    }
}
