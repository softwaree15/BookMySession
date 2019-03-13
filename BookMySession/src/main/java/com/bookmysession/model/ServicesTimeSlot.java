package com.bookmysession.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ServicesTimeSlot extends CommonProperties{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime serviceDateTime;
    private String day;
    private int availability;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "services_id", nullable = false)
    private Services services;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getServiceDateTime() {
        return serviceDateTime;
    }

    public void setServiceDateTime(LocalDateTime serviceDateTime) {
        this.serviceDateTime = serviceDateTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
}
