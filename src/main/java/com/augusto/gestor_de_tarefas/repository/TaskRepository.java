package com.augusto.gestor_de_tarefas.repository;

import com.augusto.gestor_de_tarefas.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}