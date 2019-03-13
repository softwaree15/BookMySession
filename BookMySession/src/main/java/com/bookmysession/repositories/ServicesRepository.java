package com.bookmysession.repositories;

import com.bookmysession.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ServicesRepository extends JpaRepository<Services,Long> {

    @Query("SELECT s FROM Services s where s.isActive = TRUE and s.isDelete=FALSE")
    Optional<List<Services>> getAllByActive();

    @Query("SELECT s FROM Services s where s.id=?1 and s.isActive = TRUE and s.isDelete=FALSE")
    Optional<Services> getById(long id);
}
