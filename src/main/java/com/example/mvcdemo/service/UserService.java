package com.example.mvcdemo.service;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvcdemo.models.User;
import com.example.mvcdemo.repositories.TaskRepository;
import com.example.mvcdemo.repositories.UserRepository;

import jakarta.transaction.Transactional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    public User findById(Long id){

        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException(
                "Usuário não encontrado! Id: " + id + ", Tipo: " + User.class.getName(), user));
        
    }
    
    //cria user
    @Transactional
    public User create (User obj){

        obj.setId(null);

        obj = this.userRepository.save(obj);

        this.taskRepository.saveAll(obj.getTasks());

        return obj;

    }

    public User update(User obj){

        User newObj = findById(obj.getId());

        newObj.setPassword(obj.getPassword());

        return this.userRepository.save(newObj);

    } 

    public void delete(Long id){

        findById(id);

        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            
            throw new RuntimeException("Não e possivel excluir pois a entidade e relacionada");
        }

    }
}
