package com.bookmyshow.poc.controller;

import com.bookmyshow.poc.dto.UserDetailsDTO;
import com.bookmyshow.poc.entity.UserDetails;
import com.bookmyshow.poc.service.BMSUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class BMSUserController {

    @Autowired
    private BMSUserService bmsUserService;

    @GetMapping("/findAllUser")
    public ResponseEntity<List<UserDetailsDTO>> getAllUser(){
        return ResponseEntity.ok(bmsUserService.getAllUser());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDetailsDTO> findUser (@PathVariable("userId") long userId) {
        return ResponseEntity.ok(bmsUserService.getUserById(userId));
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDetailsDTO> createUser(@Valid @RequestBody UserDetailsDTO userDetailsDTO) {
        UserDetailsDTO userDetails = bmsUserService.createUser(userDetailsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDetails);
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserDetailsDTO> updateUser(@Valid @RequestBody UserDetailsDTO userDetailsDTO,
                                                     @PathVariable("userId") long userId) {
        return ResponseEntity.ok(bmsUserService.updateUser(userDetailsDTO, userId));
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") long userId) {
        bmsUserService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
