package com.bookmysession.service;

import com.bookmysession.model.HourOrMinForServices;
import com.bookmysession.model.Services;
import com.bookmysession.model.ServicesTimeSlot;
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

@Service
@Transactional
public class ServicesService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ServicesRepository servicesRepository;

    public Services add(Services service){
        if (service.getName()==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, StringUtils.SHOULD_NOT_NULL);
        }
        else if (servicesRepository.getByName(service.getName()).isPresent()){
            throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED,StringUtils.DATA_ALREADY_EXIST);
        }
        for (HourOrMinForServices hom:service.getHourOrMinForServices())
        {
            hom.setService(service);
        }
        for (ServicesTimeSlot hom:service.getServicesTimeSlots())
        {
            hom.setServices(service);
        }
        return servicesRepository.save(service);
    }

    public Services getById(long id)
    {
        Optional<Services> dataFound=servicesRepository.getById(id);
        if (id<1 || !dataFound.isPresent())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,StringUtils.DATA_NOT_EXIST);
        }
        return dataFound.get();
    }
    public List<Services> getAllServices()
    {
        Optional<List<Services>> dataFound=servicesRepository.getAllByActive();
        if (!dataFound.isPresent())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,StringUtils.DATA_NOT_EXIST);
        }
        return dataFound.get();
    }
}
