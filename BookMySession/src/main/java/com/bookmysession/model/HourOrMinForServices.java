package com.bookmysession.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class HourOrMinForServices extends CommonProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalTime time;
    private double ammount;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "services_id", nullable = false)
    private Services service;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }
}
