package com.example.springbootexample.repository;

import com.example.springbootexample.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByLastName(String lastName);
}
