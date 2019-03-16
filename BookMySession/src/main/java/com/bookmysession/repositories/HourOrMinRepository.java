package com.bookmysession.repositories;

import com.bookmysession.model.HourOrMinForServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HourOrMinRepository extends JpaRepository<HourOrMinForServices,Long> {

    @Query("SELECT h FROM HourOrMinForServices h where h.isActive = TRUE and h.isDelete=FALSE")
    Optional<List<HourOrMinForServices>> getAllByActive();

    @Query("SELECT h FROM HourOrMinForServices h where h.id=?1 and h.isActive = TRUE and h.isDelete=FALSE")
    Optional<HourOrMinForServices> getById(long id);

    @Query("SELECT h FROM HourOrMinForServices h where h.service.id and h.isActive = TRUE and h.isDelete=FALSE")
    Optional<List<HourOrMinForServices>> getByServiceId(long id);

}
