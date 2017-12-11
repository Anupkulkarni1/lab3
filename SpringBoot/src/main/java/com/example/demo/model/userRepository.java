package com.example.demo.model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.user;

import java.util.List;


public interface userRepository  extends JpaRepository<user, Integer>{

    user findUserByEmail(String email);


    user save(user user);

}



