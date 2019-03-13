package com.bookmysession.repositories;

import com.bookmysession.model.HourOrMinForServices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HourOrMinRepository extends JpaRepository<HourOrMinForServices,Long> {
}
