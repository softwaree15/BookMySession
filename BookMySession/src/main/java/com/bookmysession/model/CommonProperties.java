package com.bookmysession.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author Amit Ranjan
 * 
 * create a common base class for all common properties
 *         which are inherited by this class and uses all common features
 */
@MappedSuperclass
public class CommonProperties {

    private boolean isActive = true;
    private boolean isDelete = false;
    private String updatedBy;
    private String createdBy;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdOn;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedOn;
}
