package com.example.techtask.service.impl;

import com.example.techtask.model.User;
import com.example.techtask.repository.CustomUserRepository;
import com.example.techtask.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceImplTest {

    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final int ID_SEVEN = 7;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void testFindUser() {
        User user = userServiceImpl.findUser();
        assertNotNull(user);
        assertEquals(ID_SEVEN, user.getId());
        assertEquals(FIVE, user.getOrders().size());
    }

    @Test
    public void testFindUsers() {
        List<User> users = userServiceImpl.findUsers();
        assertNotNull(users);
        assertEquals(TWO, users.size());
        assertEquals(THREE, users.get(0).getOrders().size());
    }
}