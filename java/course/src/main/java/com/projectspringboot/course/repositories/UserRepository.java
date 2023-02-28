package com.projectspringboot.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectspringboot.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
