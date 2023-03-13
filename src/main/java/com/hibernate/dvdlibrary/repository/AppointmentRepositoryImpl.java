package com.hibernate.dvdlibrary.repository;

import com.hibernate.dvdlibrary.entity.Appointment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public AppointmentRepositoryImpl() {

    }


    @Override
    public void createAppointment(Appointment appointment) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(appointment);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error caused by: " + e.getMessage());
        }
        session.close();

    }

    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            appointments = session.createQuery("FROM Appointment", Appointment.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error caused by: " + e.getMessage());
        }
        session.close();
        return appointments;
    }

    @Override
    public Appointment getAppointmentById(int id) {
        Session session = null;
        Appointment appointment = new Appointment();

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            appointment = (Appointment) session.createQuery("FROM Appointment WHERE id = :id", Appointment.class)
                    .setParameter("id", id)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error caused by: " + e.getMessage());
        }
        session.close();
        return appointment;
    }

    @Override
    public void deleteAppointmentById(int id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Appointment appointment = getAppointmentById(id);
            session.delete(appointment);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error caused by: " + e.getMessage());
        }
        session.close();
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(appointment);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error caused by: " + e.getMessage());
        }
        session.close();
    }
}
