package com.bookmysession.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicesTimeSlotService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
}
