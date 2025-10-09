package com.codegym.bt_spring_security_phan_quyen.repository;

import com.codegym.bt_spring_security_phan_quyen.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
}