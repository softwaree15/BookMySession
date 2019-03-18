package com.bookmysession.controller;

import com.bookmysession.model.ServicesTimeSlot;
import com.bookmysession.service.ServicesTimeSlotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/servicetimeslot")
public class ServiceTimeSlotController {
    private static final Logger log = LoggerFactory.getLogger(ServiceTimeSlotController.class);

    @Autowired
    ServicesTimeSlotService servicesTimeSlotService;

    @PostMapping("/add/{id}")
    public ResponseEntity<ServicesTimeSlot> addServiceTimeSlot(@PathVariable() long serviceId,@RequestBody ServicesTimeSlot servicesTimeSlot)
    {
        servicesTimeSlot=servicesTimeSlotService.add(servicesTimeSlot,serviceId);
        log.info("ServicesTimeSlot {} ",servicesTimeSlot);
        return new ResponseEntity<>(servicesTimeSlot, HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<ServicesTimeSlot> getServiceTimeSlotById(@PathVariable() UUID id)
    {
        ServicesTimeSlot servicesTimeSlot=servicesTimeSlotService.getById(id);
        log.info("servicesTimeSlot {} ",servicesTimeSlot);
        return new ResponseEntity<>(servicesTimeSlot, HttpStatus.OK);
    }
}
