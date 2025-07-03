package com.example.loggerapi.Project_Logger_API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.loggerapi.Project_Logger_API.Model.User;

public interface UserRepository extends JpaRepository<User, Long> 
{
    
}

