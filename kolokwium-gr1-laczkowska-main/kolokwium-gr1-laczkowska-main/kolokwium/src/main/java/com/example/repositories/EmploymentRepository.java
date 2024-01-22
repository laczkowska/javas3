package com.example.repositories;

import com.example.model.Employment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmploymentRepository extends JpaRepository<Employment, Integer> {
    List<Employment> findByTitle(String title);
}