package com.solncev.services;

import com.solncev.dtos.UserDto;
import com.solncev.models.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();
    void save (User user);
}
