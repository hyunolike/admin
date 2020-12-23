package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    user은 있을수도 있고 없을수도 있다 -> optional
//    select * from user where account = ? << test03, test04
    Optional<User> findByAccount(String account);

    Optional<User> findByEmail(String email);

//    여러개 검색 시  >> select * from user where account =? and email = ?
    Optional<User> findByAccountAndEmail(String account, String email);
}
