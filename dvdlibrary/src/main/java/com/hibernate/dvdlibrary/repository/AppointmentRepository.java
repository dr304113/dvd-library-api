package com.hibernate.dvdlibrary.repository;


import com.hibernate.dvdlibrary.entity.Appointment;

import java.util.List;

public interface AppointmentRepository {

    void createAppointment(Appointment appointment);

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(int id);

    void deleteAppointmentById(int id);

    void updateAppointment(Appointment appointment);
}
