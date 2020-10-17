package com.solncev.services;

import com.solncev.daos.impl.UserDaoImpl;
import com.solncev.dtos.UserDto;
import com.solncev.models.User;
import com.solncev.services.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

public class UserServiceTest {

    private UserServiceImpl service;
    private UserDaoImpl dao;

    @Before
    public void setup() throws NoSuchFieldException, IllegalAccessException {
        dao = Mockito.mock(UserDaoImpl.class);
        service = new UserServiceImpl();
        Field daoFiled = UserServiceImpl.class.getDeclaredField("dao");
        daoFiled.setAccessible(true);
        daoFiled.set(service, dao);
    }

    @Test
    public void testGetAll() {
        User user = new User(1, "login", "password", "name", "lastname");
        Mockito.when(dao.getAll()).thenReturn(Collections.singletonList(user));
        List<UserDto> result = service.getAll();

        Assert.assertEquals(1, result.size());
        Assert.assertEquals(user.getLogin(), result.get(0).getLogin());
    }
}
