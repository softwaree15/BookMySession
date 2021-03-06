package com.bookmysession.service;

import com.bookmysession.model.HourOrMinForServices;
import com.bookmysession.model.ServicesTimeSlot;
import com.bookmysession.repositories.HourOrMinRepository;
import com.bookmysession.repositories.ServicesRepository;
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
public class HourOrMinService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    HourOrMinRepository hourOrMinRepository;

    @Autowired
    ServicesRepository servicesRepository;

    public HourOrMinForServices add(HourOrMinForServices hms, long serviceId)
    {
        if (serviceId<1)
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, StringUtils.SHOULD_NOT_NULL);
        }
        else if (servicesRepository.getById(serviceId)==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, StringUtils.DATA_NOT_EXIST+" with this serviceId:"+serviceId);
        }
        Optional<List<HourOrMinForServices>> hourOrMinForServices=hourOrMinRepository.getByServiceId(serviceId);
        for (HourOrMinForServices hmsingle:hourOrMinForServices.get())
        {
            if (hmsingle.getTime().equals(hms.getTime()) && hmsingle.getAmmount()==hms.getAmmount() && hmsingle.getService().getId()==serviceId)
            {
                throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, StringUtils.DATA_ALREADY_EXIST+" with this service id ="+serviceId+" and time "+hms.getTime()+" ammount "+hms.getAmmount());
            }
        }
        hms.setService(hourOrMinForServices.get().get(0).getService());
        return hourOrMinRepository.save(hms);
    }

    public HourOrMinForServices getById(UUID id)
    {
        Optional<HourOrMinForServices> dataFound=hourOrMinRepository.getById(id);
        if (!dataFound.isPresent())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,StringUtils.DATA_NOT_EXIST);
        }
        return dataFound.get();
    }
}
