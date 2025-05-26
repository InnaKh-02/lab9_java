package org.example.repository;

import org.example.DVD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DVDRepository extends JpaRepository<DVD, Integer> {
    List<DVD> findByAvailableTrue();
}