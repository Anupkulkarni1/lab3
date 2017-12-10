package com.example.demo.model;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface userRepository  extends CrudRepository<user, Integer>{

    user findUserByEmail(String email);

}



