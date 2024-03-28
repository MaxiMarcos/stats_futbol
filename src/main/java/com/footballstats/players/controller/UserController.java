/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.footballstats.players.controller;

import com.footballstats.players.model.User;
import com.footballstats.players.service.IUserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userServ;

    
    @GetMapping
    public List<User> getUsers() {
        return userServ.getUsers();
    }
    
    @PostMapping
    public ResponseEntity<User> createUser(@Validated @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            
            return validation(bindingResult);
        }
        userServ.createUser(user);

        
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

       private ResponseEntity<User> validation(BindingResult bindingResult) {
    Map<String, String> errors = new HashMap<>();
    for (FieldError error : bindingResult.getFieldErrors()) {
        errors.put(error.getField(), error.getDefaultMessage());
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Devuelve un ResponseEntity<User> vacío o con un objeto User adecuado.
}
}
