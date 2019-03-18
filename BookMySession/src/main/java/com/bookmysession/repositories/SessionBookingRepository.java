package com.bookmysession.repositories;

import com.bookmysession.model.Services;
import com.bookmysession.model.SessionBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SessionBookingRepository extends JpaRepository<SessionBooking,UUID> {
    @Query("SELECT s FROM SessionBooking s where s.isActive = TRUE and s.isDelete=FALSE")
    Optional<List<SessionBooking>> getAllByActive();

    @Query("SELECT s FROM SessionBooking s where s.uuid=?1 and s.isActive = TRUE and s.isDelete=FALSE")
    Optional<SessionBooking> getById(UUID id);

    @Query("SELECT s FROM SessionBooking s where s.services.id=?1 and s.servicesTimeSlot.id=?2 and s.hourOrMinForServices.id=?3 and s.isActive = TRUE and s.isDelete=FALSE")
    Optional<SessionBooking> getByServicesIdAndServicesTimeSlotIdAndHourOrMinId(long serviceId,UUID timeSlotId,UUID hourMinId);
}
