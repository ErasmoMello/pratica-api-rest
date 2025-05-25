package com.example.demopraticarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demopraticarest.model.Tarefas;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
}