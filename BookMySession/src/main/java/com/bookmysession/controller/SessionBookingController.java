package com.bookmysession.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sessionbooking")
public class SessionBookingController {
    private static final Logger log = LoggerFactory.getLogger(SessionBookingController.class);
}
