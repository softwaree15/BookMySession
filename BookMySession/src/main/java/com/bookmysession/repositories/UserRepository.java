package com.bookmysession.repositories;

import com.bookmysession.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {
    @Query("SELECT u FROM Users u where u.isActive = TRUE and u.isDelete=FALSE")
    Optional<List<Users>> getAllByActive();

    @Query("SELECT u FROM Users u where u.token=?1 and u.isActive = TRUE and u.isDelete=FALSE")
    Optional<Users> getUserByToken(String token);

    @Query(value = "SELECT u FROM Users u where u.email=?1 and u.password=?2 and u.isActive = TRUE and u.isDelete=FALSE")
    Users getUserByemailAndPassword(String email,String password);

    @Query("SELECT u FROM Users u where u.email=?1 and u.isActive = TRUE and u.isDelete=FALSE")
    Optional<Users> getUserByEmail(String email);

    @Query("SELECT u FROM Users u where u.mobNo=?1 and u.password=?2 and u.isActive = TRUE and u.isDelete=FALSE")
    Optional<Users> getUserByMobNoAndPassword(String Mob,String password);

    @Query("SELECT u FROM Users u where u.id=?1 and u.isActive = TRUE and u.isDelete=FALSE")
    Optional<Users> getByIdAndActive(long id);
}
