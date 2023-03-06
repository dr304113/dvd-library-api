package com.hibernate.dvdlibrary.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "AppointmentRepository")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "meetingDateTime")
    private LocalDateTime meetingDateTime;

    @Column(name = "isNewCustomer")
    private boolean isNewCustomer;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "location")
    private String location;

    @Column(name = "dvdToRentId")
    private int dvdToRentId;

    public Appointment() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getMeetingDateTime() {
        return meetingDateTime;
    }

    public void setMeetingDateTime(LocalDateTime meetingDateTime) {
        this.meetingDateTime = meetingDateTime;
    }

    public boolean isNewCustomer() {
        return isNewCustomer;
    }

    public void setNewCustomer(boolean newCustomer) {
        isNewCustomer = newCustomer;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "AppointmentRepository{" +
                "id=" + id +
                ", meetingDateTime=" + meetingDateTime +
                ", isNewCustomer=" + isNewCustomer +
                ", purpose='" + purpose + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment that)) return false;
        return id == that.id && isNewCustomer == that.isNewCustomer && Objects.equals(meetingDateTime, that.meetingDateTime) && Objects.equals(purpose, that.purpose) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, meetingDateTime, isNewCustomer, purpose, location);
    }
}
