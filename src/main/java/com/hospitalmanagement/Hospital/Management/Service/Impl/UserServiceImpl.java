package com.hospitalmanagement.Hospital.Management.Service.Impl;

import com.hospitalmanagement.Hospital.Management.Dto.UserDto;
import com.hospitalmanagement.Hospital.Management.Entity.User;
import com.hospitalmanagement.Hospital.Management.Repository.UserRepository;
import com.hospitalmanagement.Hospital.Management.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = modelMapper.map(userDto,User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public UserDto loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user.getPassword().equals(password)){
            return modelMapper.map(user,UserDto.class);
        }
        return null;
    }
}
