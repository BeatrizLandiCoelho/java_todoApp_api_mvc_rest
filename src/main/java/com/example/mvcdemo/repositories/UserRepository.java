package com.example.mvcdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mvcdemo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    //User findByUsername(String username);

    
        // Esta interface estende JpaRepository, que é uma interface do Spring Data JPA
    // Ela fornece métodos CRUD (Create, Read, Update, Delete) para a entidade User
    
    // O primeiro parâmetro de JpaRepository é a entidade com a qual esta interface trabalha, neste caso, User
    // O segundo parâmetro é o tipo do identificador da entidade, neste caso, Long
    
    // Esta interface é anotada com @Repository, indicando que é um componente de repositório gerenciado pelo Spring
    
    // Não há métodos adicionais definidos aqui, pois JpaRepository fornece métodos CRUD padrão
    // Se você precisar de consultas personalizadas, pode definir métodos aqui e o Spring Data JPA irá gerar as consultas SQL automaticamente
    
    // Exemplo de método personalizado (comentado):
    // User findByUsername(String username);
    // Este método procurará um usuário pelo nome de usuário

 }
