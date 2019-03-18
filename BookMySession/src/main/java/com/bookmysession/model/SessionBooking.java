package com.bookmysession.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class SessionBooking extends CommonProperties {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;
    private String mobNo;
    private String paymentMode;
    private int quantity;
    private double ammount;

    @ManyToOne
    @JoinColumn(name = "hour_min_id", nullable = false)
    private HourOrMinForServices hourOrMinForServices;

    @ManyToOne
    @JoinColumn(name = "time_slot_id", nullable = false)
    private ServicesTimeSlot servicesTimeSlot;

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

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public HourOrMinForServices getHourOrMinForServices() {
        return hourOrMinForServices;
    }

    public void setHourOrMinForServices(HourOrMinForServices hourOrMinForServices) {
        this.hourOrMinForServices = hourOrMinForServices;
    }

    public ServicesTimeSlot getServicesTimeSlot() {
        return servicesTimeSlot;
    }

    public void setServicesTimeSlot(ServicesTimeSlot servicesTimeSlot) {
        this.servicesTimeSlot = servicesTimeSlot;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
}
