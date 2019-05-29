package com.cet.homework.repository;

import com.cet.homework.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepository {
    /**
     * 获取指定ID的用户
     * @param id
     * @return
     */
    @Query("SELECT u FROM User u WHERE u.id=:id")
    User find(@Param("id") int id);

    @PersistenceContext
    private EntityManager em;



}