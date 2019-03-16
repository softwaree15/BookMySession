package com.bookmysession.repositories;

import com.bookmysession.model.ServicesTimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ServicesTimeSlotRepository extends JpaRepository<ServicesTimeSlot,Long> {

    @Query("SELECT s FROM ServicesTimeSlot s where s.isActive = TRUE and s.isDelete=FALSE")
    Optional<List<ServicesTimeSlot>> getAllByActive();

    @Query("SELECT s FROM ServicesTimeSlot s where s.id=?1 and s.isActive = TRUE and s.isDelete=FALSE")
    Optional<ServicesTimeSlot> getById(long id);

    @Query("SELECT s FROM ServicesTimeSlot s where s.services.id=?1 and s.isActive = TRUE and s.isDelete=FALSE")
    Optional<List<ServicesTimeSlot>> getByServiceId(long id);
}
