package com.bookmysession.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Services extends CommonProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy="service",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<HourOrMinForServices> hourOrMinForServices;

    @OneToMany(mappedBy="services",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ServicesTimeSlot> servicesTimeSlots;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HourOrMinForServices> getHourOrMinForServices() {
        return hourOrMinForServices;
    }

    public void setHourOrMinForServices(List<HourOrMinForServices> hourOrMinForServices) {
        this.hourOrMinForServices = hourOrMinForServices;
    }

    public List<ServicesTimeSlot> getServicesTimeSlots() {
        return servicesTimeSlots;
    }

    public void setServicesTimeSlots(List<ServicesTimeSlot> servicesTimeSlots) {
        this.servicesTimeSlots = servicesTimeSlots;
    }
}
