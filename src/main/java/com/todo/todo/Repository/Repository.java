package com.todo.todo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.todo.todo.JPA_Entity.Todo;

import jakarta.transaction.Transactional;

public interface Repository extends JpaRepository<Todo, Long>{
    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE todo AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
