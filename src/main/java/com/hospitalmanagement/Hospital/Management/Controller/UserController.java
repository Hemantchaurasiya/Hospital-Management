package com.hospitalmanagement.Hospital.Management.Controller;

import com.hospitalmanagement.Hospital.Management.Dto.LoginDto;
import com.hospitalmanagement.Hospital.Management.Dto.UserDto;
import com.hospitalmanagement.Hospital.Management.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto){
        System.out.println(userDto);
        UserDto savedUser = userService.saveUser(userDto);
        System.out.println(savedUser);
        return new ResponseEntity<UserDto>(savedUser,HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@Valid @RequestBody LoginDto loginDto){
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        UserDto userDto = userService.loginUser(email,password);
        if (userDto==null){

        }
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }
}
