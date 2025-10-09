package com.codegym.bt_spring_security_phan_quyen.repository;

import com.codegym.bt_spring_security_phan_quyen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
