package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User>{

}
