package com.example.demo.Controller;


        import com.example.demo.model.user;
        import com.example.demo.model.userRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import com.example.demo.req.LoginRequest;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "http://localhost:3000")
public class userController {


    @Autowired
    private userRepository userRepository;


//    @PostMapping(value = "/login")
//    public ResponseEntity<user> userLogin(
//            @RequestBody LoginRequest loginRequest) {
//
//        User user = userRepository.findUserByEmail(loginRequest.getEmail());
//
//        logger.info("email: " + loginRequest.getEmail());
//        logger.info("password: " + loginRequest.getPassword());
//        logger.info("current user: " + user);
//
//        if (!user.isPasswordCorrect(loginRequest.getPassword())) {
//            throw new UnauthorizedException();
//        }
//
//        return new ResponseEntity<User>(user, HttpStatus.OK);
//    }
//    @RequestMapping(method = RequestMethod.POST , value="/login", headers="Accept=application/json")
    @PostMapping(value = "/login")
    public ResponseEntity<user> login(@RequestBody LoginRequest loginRequest)
    {
        System.out.println(loginRequest.getEmail());

        user user = userRepository.findUserByEmail(loginRequest.getEmail());
        return new ResponseEntity<user>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<String> userLogout() {
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}