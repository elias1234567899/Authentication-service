/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elias.Authenticationservice.web;

import com.elias.Authenticationservice.dao.TaskRepository;
import com.elias.Authenticationservice.model.Task;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abbasturki.elias
 */
@RestController
public class TaskRestController {
    
     @Autowired
     private TaskRepository taskRepository;
    
     @GetMapping("/tasks")
     public List<Task> listTasks(){
         return taskRepository.findAll();
     }
     
     @PostMapping("/tasks")
     public Task save(Task t){
         return taskRepository.save(t);
     }
     
}
