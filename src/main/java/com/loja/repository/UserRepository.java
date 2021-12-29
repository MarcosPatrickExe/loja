package com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.loja.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}