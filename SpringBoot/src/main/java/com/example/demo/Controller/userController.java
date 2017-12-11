package com.example.demo.Controller;
import com.example.demo.model.user;
import com.example.demo.model.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.req.LoginRequest;
import com.example.demo.req.SignupRequest;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "http://localhost:3000")
public class userController {


    @Autowired
    private userRepository userRepository;

    @PostMapping(value = "/login")
    public ResponseEntity<user> login(@RequestBody LoginRequest loginRequest)
    {
        System.out.println(loginRequest.getEmail());

        user user = userRepository.findUserByEmail(loginRequest.getEmail());
        return new ResponseEntity<user>(user, HttpStatus.OK);
    }


    @PostMapping(value = "/signup")
    public ResponseEntity<String> signup(@RequestBody user user)
    {

        System.out.println(user.getFirstName());

        userRepository.save(user);

        return new ResponseEntity<String>("Sign Up successful", HttpStatus.OK);
    }


    @GetMapping(value = "/logout")
    public ResponseEntity<String> userLogout() {
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}