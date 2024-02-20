package com.example.mvcdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvcdemo.models.Task;
import com.example.mvcdemo.models.User;
import com.example.mvcdemo.repositories.TaskRepository;

import jakarta.transaction.Transactional;

@Service
public class TaskService {
 
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public Task findById(Long id){

        Optional<Task> task = this.taskRepository.findById(id);

        return task.orElseThrow(()-> new RuntimeException(
            "tarefa nao encontrada" + id + "tipo" + Task.class.getName()));

    }

    public List<Task> findAllByUserId(Long userId) {
       // List<Task> tasks = this.taskRepository(userId);
       List<Task> tasks = this.taskRepository.findByUser_Id(userId);
        return tasks;
    }

    @Transactional
    public Task create(Task obj){
        User user = this.userService.findById(obj.getUser().getId());
        obj.setId(null);
        obj.setUser(user);
        obj = this.taskRepository.save(null);
        return obj;
    }

    @Transactional
    public Task update(Task obj){
        Task newObjt = findById(obj.getId());
        newObjt.setDescription(obj.getDescription());
        return this.taskRepository.save(newObjt);

    }

    public void delete(Long id){

        findById(id);
        try {
            this.taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("acao nao concluida");
        }

    }

  
    
}
