package com.bookmysession.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class SessionBooking extends CommonProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String mobNo;
    private String paymentMode;
    private int quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "hour_min_id", nullable = false)
    private HourOrMinForServices hourOrMinForServices;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "services_id", nullable = false)
    private Services services;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public HourOrMinForServices getHourOrMinForServices() {
        return hourOrMinForServices;
    }

    public void setHourOrMinForServices(HourOrMinForServices hourOrMinForServices) {
        this.hourOrMinForServices = hourOrMinForServices;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
}
