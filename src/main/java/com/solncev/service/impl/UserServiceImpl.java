package com.solncev.service.impl;

import com.solncev.dao.Dao;
import com.solncev.dao.impl.UserDaoImpl;
import com.solncev.dto.UserDto;
import com.solncev.helpers.PasswordHelper;
import com.solncev.models.User;
import com.solncev.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final Dao<User> dao = new UserDaoImpl();

    @Override
    public List<UserDto> getAll() {
        List<User> users = dao.getAll();
        return users.stream()
                .map(x -> new UserDto(x.getLogin(), x.getName(), x.getLastname()))
                .collect(Collectors.toList());
    }

    @Override
    public void save(User user) {
        dao.save(new User(
                user.getLogin(),
                PasswordHelper.encrypt(user.getPassword()),
                user.getName(),
                user.getLastname()
        ));
    }
}
