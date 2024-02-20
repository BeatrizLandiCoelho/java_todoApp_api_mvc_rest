package com.example.mvcdemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.mvcdemo.models.Task;
//import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository <Task,Long>{

    List<Task> findByUser_Id(Long id);
    //@Query(value = "SELECT t FROM t WHERE t user.user.id = :id")
    //List<Task> findByUser_Id(@Param("id") Long id);

}
