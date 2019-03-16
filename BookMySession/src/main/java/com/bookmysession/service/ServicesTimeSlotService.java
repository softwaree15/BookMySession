package com.bookmysession.service;

import com.bookmysession.model.ServicesTimeSlot;
import com.bookmysession.repositories.ServicesTimeSlotRepository;
import com.bookmysession.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServicesTimeSlotService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ServicesTimeSlotRepository servicesTimeSlotRepository;

    public ServicesTimeSlot add(ServicesTimeSlot sts)
    {
        if (sts.getServices().getId()<1)
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, StringUtils.SHOULD_NOT_NULL);
        }
        Optional<List<ServicesTimeSlot>> servicesTimeSlots=servicesTimeSlotRepository.getByServiceId(sts.getServices().getId());
        for (ServicesTimeSlot stsingle:servicesTimeSlots.get())
        {
            if (stsingle.getServiceDateTime().equals(sts.getServiceDateTime()))
            {
                throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, StringUtils.DATA_ALREADY_EXIST+" with this service id ="+sts.getServices().getId()+" and date "+sts.getServiceDateTime());
            }
        }
        sts.setDay(sts.getServiceDateTime().getDayOfWeek().toString().substring(0,3));
        return servicesTimeSlotRepository.save(sts);
    }
}
