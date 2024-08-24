package com.zoulaika.User_Management_API.repository;

import com.zoulaika.User_Management_API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
