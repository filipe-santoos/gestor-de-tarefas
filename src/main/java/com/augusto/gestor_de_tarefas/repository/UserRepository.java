package com.augusto.gestor_de_tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.augusto.gestor_de_tarefas.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}