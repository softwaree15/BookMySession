package com.bookmysession.controller;

import com.bookmysession.model.Services;
import com.bookmysession.model.SessionBooking;
import com.bookmysession.service.SessionBookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/sessionbooking")
public class SessionBookingController {
    private static final Logger log = LoggerFactory.getLogger(SessionBookingController.class);

    @Autowired
    SessionBookingService sessionBookingService;

    @PostMapping("/add/{serviceId}/{timeSlotId}/{hourMinId}")
    public ResponseEntity<SessionBooking> addService(@RequestBody SessionBooking sessionBooking, @PathVariable("serviceId") long serviceId,  @PathVariable("timeSlotId") UUID timeSlotId, @PathVariable("hourMinId") UUID hourMinId)
    {
        sessionBooking=sessionBookingService.add(sessionBooking,serviceId,timeSlotId,hourMinId);
        log.info("SessionBooking {} ",sessionBookingService);
        return new ResponseEntity<>(sessionBooking, HttpStatus.OK);
    }
}
