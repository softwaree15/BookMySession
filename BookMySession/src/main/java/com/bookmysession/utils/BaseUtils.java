package com.bookmysession.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class BaseUtils {
    public static final Logger log = LoggerFactory.getLogger(BaseUtils.class);
    public static DateTimeFormatter formatter;

    public static String dateTimeFormatter(LocalDateTime localDateTime) {
        if(localDateTime == null) {
            log.info("Arguments not acceptable Given :{} and Expected : LocalDateTime",localDateTime);
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, StringUtils.SHOULD_NOT_NULL);
        }

        log.info("Requested local date time {}.", localDateTime);
        formatter = DateTimeFormatter.ofPattern(StringUtils.DATE_TIME_FORMAT);
        log.info("Date time format {}", StringUtils.DATE_TIME_FORMAT);
        String dateTime = null;
        try {
            dateTime = localDateTime.format(formatter);
        } catch (DateTimeException ex) {
            log.error(ex.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
        }

        log.info("Requested local date time {} formatted successfully.", dateTime);
        return dateTime;
    }
}
