package com.example.mvcdemo.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//@Entity avisa pro spring que iso sera tartado como uma tabela
@Entity
@Table(name="user")
public class User {

    public interface CreateUser {}
    public interface UpdateUser {}
    //criando atribbitos

    //DICA : use Integer ao invez de intm Integer não é primitivo entao nao tem chance de dar erro
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true)
    private Long id;

    @Column(name = "username", length = 100, nullable = false, unique=true)
    @NotNull(groups=CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    @Size(min=2,max = 100 )
    private String username;

    @Column(name="password", length = 60, nullable = false)
    @NotNull(groups= {CreateUser.class, UpdateUser.class})
    @NotEmpty(groups = {CreateUser.class, UpdateUser.class} )
    @Size(min=8, max=60)
    private String password;

    // Relacionamento um-para-muitos com a entidade Task
    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<Task>(); 

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    //construtor vazio
    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Long id, String username, String password){
        
        this.username = username;
        this.id=id;
        this.password=password;
    }


}
