package com.bookmysession.service;

import com.bookmysession.model.ServicesTimeSlot;
import com.bookmysession.repositories.ServicesRepository;
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
import java.util.UUID;

@Service
@Transactional
public class ServicesTimeSlotService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ServicesTimeSlotRepository servicesTimeSlotRepository;

    @Autowired
    ServicesRepository servicesRepository;

    public ServicesTimeSlot add(ServicesTimeSlot sts,long serviceId)
    {
        if (sts.getServices().getId()<1)
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, StringUtils.SHOULD_NOT_NULL);
        }
        else if (servicesRepository.getById(serviceId)==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, StringUtils.DATA_NOT_EXIST+" with this serviceId:"+serviceId);
        }
        Optional<List<ServicesTimeSlot>> servicesTimeSlots=servicesTimeSlotRepository.getByServiceId(serviceId);
        for (ServicesTimeSlot stsingle:servicesTimeSlots.get())
        {
            if (stsingle.getServiceDateTime().equals(sts.getServiceDateTime()) && sts.getServices().getId()==serviceId)
            {
                throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, StringUtils.DATA_ALREADY_EXIST+" with this service id ="+serviceId+" and date "+sts.getServiceDateTime());
            }
        }
        sts.setDay(sts.getServiceDateTime().getDayOfWeek().toString().substring(0,3).toLowerCase());
        sts.setServices(servicesTimeSlots.get().get(0).getServices());
        return servicesTimeSlotRepository.save(sts);
    }

    public ServicesTimeSlot getById(UUID id)
    {
        Optional<ServicesTimeSlot> dataFound=servicesTimeSlotRepository.getById(id);
        if (!dataFound.isPresent())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,StringUtils.DATA_NOT_EXIST);
        }
        return dataFound.get();
    }
}
