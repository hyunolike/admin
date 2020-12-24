package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){

        Item item = new Item();
        item.setStatus("UNREGISTERED");
        item.setName("델 노트북");
        item.setTitle("델 노트북 인스피론");
        item.setContent("2020년형 노트북 입니다.");
        item.setPrice(14000000);
        item.setBrandName("dell");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
//        item.setPartnerId(1L); // Long -> Partner


        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);
    }

    @Test
    public void read(){

        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

        Assertions.assertTrue(item.isPresent());

//        item.ifPresent(i -> {
//            System.out.println(i);
//        });
    }

}
