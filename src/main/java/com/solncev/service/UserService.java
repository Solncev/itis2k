package com.solncev.service;

import com.solncev.dto.UserDto;
import com.solncev.models.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();
    void save (User user);
}
