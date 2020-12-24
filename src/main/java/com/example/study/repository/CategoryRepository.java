package com.example.study.repository;

import com.example.study.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

//    quary method 작성하는거야
    Optional<Category> findByType(String type);

}
