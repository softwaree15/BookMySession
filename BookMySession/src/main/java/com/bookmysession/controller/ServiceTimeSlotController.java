package com.bookmysession.controller;

import com.bookmysession.model.Services;
import com.bookmysession.service.ServicesTimeSlotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicetimeslot")
public class ServiceTimeSlotController {
    private static final Logger log = LoggerFactory.getLogger(ServiceTimeSlotController.class);

    @Autowired
    ServicesTimeSlotService servicesTimeSlotService;

    @PostMapping("/add")
    public ResponseEntity<Services> addServiceTimeSlot(@RequestBody Services service)
    {
        service=servicesTimeSlotService.add(service);
        log.info("All services {} ",service);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Services> getServiceTimeSlotById(@PathVariable() long id)
    {
        Services services=servicesService.getById(id);
        log.info("ServiceTimeSlot {} ",services);
        return new ResponseEntity<>(services, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Services>> getAllServiceTimeSlot()
    {
        List<Services> servicesList=servicesService.getAllServices();
        log.info("ServiceTimeSlot List {} ",servicesList.size());
        return new ResponseEntity<>(servicesList, HttpStatus.OK);
    }
}
