package com.hospitalmanagement.Hospital.Management.Service;

import com.hospitalmanagement.Hospital.Management.Dto.UserDto;

public interface UserService {
    UserDto saveUser(UserDto userDto);
    UserDto loginUser(String email,String password);
}
