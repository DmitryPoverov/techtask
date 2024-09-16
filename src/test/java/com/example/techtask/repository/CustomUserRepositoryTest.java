package com.example.techtask.repository;

import com.example.techtask.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@Transactional
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = "com.example.techtask.repository")
public class CustomUserRepositoryTest {

    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final int ID_SEVEN = 7;

    @Autowired
    private CustomUserRepository customUserRepository;

    @Test
    public void testFindMaxDeliveredSumIn2003User() {
        User user = customUserRepository.findMaxDeliveredSumIn2003User();
        assertNotNull(user);
        assertEquals(ID_SEVEN, user.getId());
        assertEquals(FIVE, user.getOrders().size());
    }

    @Test
    public void testFindPaidOrdersIn2010Users() {
        List<User> users = customUserRepository.findPaidOrdersIn2010Users();
        assertNotNull(users);
        assertEquals(TWO, users.size());
        assertEquals(THREE, users.get(0).getOrders().size());
    }
}