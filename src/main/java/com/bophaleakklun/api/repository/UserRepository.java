package com.bophaleakklun.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bophaleakklun.api.entity.UserDetail;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, Integer> { // jpa repo = crud repo + jpa features
    UserDetail findByUsername(String username);
    UserDetail findByPhoneNumber(String phoneNumber);
}
