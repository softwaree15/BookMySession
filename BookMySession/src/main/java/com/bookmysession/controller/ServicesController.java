package com.bookmysession.controller;

import com.bookmysession.model.Services;
import com.bookmysession.model.Users;
import com.bookmysession.service.ServicesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service")
public class ServicesController {

    private static final Logger log = LoggerFactory.getLogger(ServicesController.class);

    @Autowired
    ServicesService servicesService;

    @PostMapping("/add")
    public ResponseEntity<Services> addService(@RequestBody Services service)
    {
        service=servicesService.add(service);
        log.info("services {} ",service);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Services> getServiceById(@PathVariable() long id)
    {
        Services services=servicesService.getById(id);
        log.info("Services {} ",services);
        return new ResponseEntity<>(services, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Services>> getAllService()
    {
        List<Services> servicesList=servicesService.getAllServices();
        log.info("servicesList {} ",servicesList.size());
        return new ResponseEntity<>(servicesList, HttpStatus.OK);
    }
}
