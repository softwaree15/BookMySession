package com.bookmysession.controller;

import com.bookmysession.model.HourOrMinForServices;
import com.bookmysession.model.ServicesTimeSlot;
import com.bookmysession.service.HourOrMinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hourormin")
public class HourOrMinController {
    private static final Logger log = LoggerFactory.getLogger(HourOrMinController.class);

    @Autowired
    HourOrMinService hourOrMinService;

    @PostMapping("/add/{id}")
    public ResponseEntity<HourOrMinForServices> addServiceTimeSlot(@PathVariable() long serviceId, @RequestBody HourOrMinForServices hourOrMinForServices)
    {
        hourOrMinForServices=hourOrMinService.add(hourOrMinForServices,serviceId);
        log.info("ServicesTimeSlot {} ",hourOrMinForServices);
        return new ResponseEntity<>(hourOrMinForServices, HttpStatus.OK);
    }
}
