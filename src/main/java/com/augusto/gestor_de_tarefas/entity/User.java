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

    @NotBlank(message = "Nome é Obrigatório")// Impede campo vazio essa mensagem é opcional, apenas quis mudar
    private String name;
    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "Informe um e-mail válido") // Só aceita formato de email valido
    private String email;
    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres") // 6 caracteres é o minimo para a criação da senha
    private String password;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;
}