package com.solncev.services.impl;

import com.solncev.daos.Dao;
import com.solncev.daos.impl.UserDaoImpl;
import com.solncev.db.DataSource;
import com.solncev.dtos.UserDto;
import com.solncev.helpers.PasswordHelper;
import com.solncev.models.User;
import com.solncev.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final Dao<User> dao = new UserDaoImpl(DataSource.getConnection());

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
