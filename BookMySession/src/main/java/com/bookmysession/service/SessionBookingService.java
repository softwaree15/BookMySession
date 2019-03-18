package com.bookmysession.service;

import com.bookmysession.model.HourOrMinForServices;
import com.bookmysession.model.Services;
import com.bookmysession.model.ServicesTimeSlot;
import com.bookmysession.model.SessionBooking;
import com.bookmysession.repositories.HourOrMinRepository;
import com.bookmysession.repositories.ServicesRepository;
import com.bookmysession.repositories.ServicesTimeSlotRepository;
import com.bookmysession.repositories.SessionBookingRepository;
import com.bookmysession.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SessionBookingService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SessionBookingRepository bookingRepository;

    @Autowired
    ServicesTimeSlotRepository servicesTimeSlotRepository;

    @Autowired
    HourOrMinRepository hourOrMinRepository;

    @Autowired
    ServicesRepository servicesRepository;

    public SessionBooking add(SessionBooking sb,long serviceId, UUID timeSlotId, UUID hourMinId)
    {
        Services services=servicesRepository.getById(serviceId).get();
        ServicesTimeSlot servicesTimeSlot=servicesTimeSlotRepository.getById(timeSlotId).get();
        HourOrMinForServices hourOrMinForServices=hourOrMinRepository.getById(hourMinId).get();
        if (serviceId<1)
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, StringUtils.SHOULD_NOT_NULL);
        }
        else if (servicesRepository.getById(serviceId)==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, StringUtils.DATA_NOT_EXIST+" with this serviceId:"+serviceId);
        }
        sb.setServices(services);
        sb.setServicesTimeSlot(servicesTimeSlot);
        sb.setHourOrMinForServices(hourOrMinForServices);
        return bookingRepository.save(sb);
    }
}
