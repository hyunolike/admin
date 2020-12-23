package com.example.study.repository;


import com.example.study.StudyApplication;
import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {


//    depenency injection(DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        // String sql = insert into user(, , , ,) value(, , , ,);
        User user = new User();

        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-3333-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("Hello");

        User newUser = userRepository.save(user);
        System.out.println("newUser: " + newUser);

    }

    @Test
    @Transactional
    public void read(){

        // select * from user where id = ?
        Optional<User> user = userRepository.findByAccount("TestUser03");

        user.ifPresent(selectUser -> {

            selectUser.getOrderDetailList().stream().forEach(detail -> {
                Item item = detail.getItem();

                System.out.println(item);


            });
        });

    }

    @Test
    @Transactional
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }


    @Test
    @Transactional //db에 있는 data가 실제로 제거 되지는 않는다 Rolled back transaction
    public void delete(){
        Optional<User> user = userRepository.findById(3L);

        Assertions.assertTrue(user.isPresent()); //true

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        Assertions.assertFalse(deleteUser.isPresent()); //False

    }
}
