package com.augusto.gestor_de_tarefas.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.validation.constraints.*;

@Entity
@Getter @Setter
@Table(name = "users")
@NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank // Impede campo vazio
    private String name;
    @NotBlank
    @Email // Só aceita formato de email valido
    private String email;
    @NotBlank
    @Size(min = 6) // 6 caracteres é o minimo para a criação da senha
    private String password;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;
}