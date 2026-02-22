package com.augusto.gestor_de_tarefas.Service;

import com.augusto.gestor_de_tarefas.entity.Task;
import com.augusto.gestor_de_tarefas.entity.User;
import com.augusto.gestor_de_tarefas.repository.TaskRepository;
import com.augusto.gestor_de_tarefas.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public Task create(Task task, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        task.setUser(user);
        return repository.save(task);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task update(Long id, Task task) {
        Task existing = findById(id);
        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setStatus(task.getStatus());
        existing.setDueDate(task.getDueDate());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}