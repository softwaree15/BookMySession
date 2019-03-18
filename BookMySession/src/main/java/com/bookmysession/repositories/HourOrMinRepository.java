package com.bookmysession.repositories;

import com.bookmysession.model.HourOrMinForServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HourOrMinRepository extends JpaRepository<HourOrMinForServices, UUID> {

    @Query("SELECT h FROM HourOrMinForServices h where h.isActive = TRUE and h.isDelete=FALSE")
    Optional<List<HourOrMinForServices>> getAllByActive();

    @Query("SELECT h FROM HourOrMinForServices h where h.id=?1 and h.isActive = TRUE and h.isDelete=FALSE")
    Optional<HourOrMinForServices> getById(UUID id);

    @Query("SELECT h FROM HourOrMinForServices h where h.service.id=?1 and h.isActive = TRUE and h.isDelete=FALSE")
    Optional<List<HourOrMinForServices>> getByServiceId(long id);

}
