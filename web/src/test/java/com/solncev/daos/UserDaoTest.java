package com.solncev.daos;

import com.solncev.daos.impl.UserDaoImpl;
import com.solncev.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserDaoTest {

    private UserDaoImpl dao;
    private Connection connection;

    @Before
    public void setUp() {
        connection = mock(Connection.class);
        dao = new UserDaoImpl(connection);
    }

    @Test
    public void getAll() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("login")).thenReturn("login");
        when(resultSet.getString("password")).thenReturn("password");
        when(resultSet.getString("name")).thenReturn("Ivan");
        when(resultSet.getString("lastname")).thenReturn("Ivanov");

        Statement statement = mock(Statement.class);
        when(statement.executeQuery("SELECT * FROM \"user\"")).thenReturn(resultSet);

        when(connection.createStatement()).thenReturn(statement);

        Mockito.verify(connection, atMostOnce()).createStatement();

        List<User> result = dao.getAll();
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("Ivanov", result.get(0).getLastname());
    }
}
