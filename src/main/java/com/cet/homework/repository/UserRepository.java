package com.cet.homework.repository;

import com.cet.homework.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CustomizedRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.number=:number")
    User find(@Param("number") String number);
}