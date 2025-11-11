package com.bophaleakklun.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bophaleakklun.api.dto.UserDetailDTO;
import com.bophaleakklun.api.dto.response.SuccessResponse;
import com.bophaleakklun.api.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/users")
@Validated // ensure validation
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<SuccessResponse<List<UserDetailDTO>>> getUsers() {
        List<UserDetailDTO> users = userService.getUsers();
        SuccessResponse<List<UserDetailDTO>> successResponse = new SuccessResponse<>();
        // successResponse.setData(users);
        // successResponse.setStatus(HttpStatus.OK);
        // successResponse.setStatusCode(200);

        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }
    
    @GetMapping("/{userId}")
    public ResponseEntity<SuccessResponse<UserDetailDTO>> getUserById(
        @PathVariable int UserId) {
        UserDetailDTO user = userService.getUser(UserId);
        SuccessResponse<UserDetailDTO> successResponse = new SuccessResponse<>();
        // successResponse.setData(user);
        // successResponse.setStatus(HttpStatus.OK);
        // successResponse.setStatusCode(200);
        
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<SuccessResponse<Void>> createUser(
        @Valid @RequestBody UserDetailDTO userDTO
    ) {
        userService.createUser(userDTO);

        SuccessResponse<Void> successResponse = new SuccessResponse<>();
        // successResponse.setData(user);
        // successResponse.setMessage("User created successfully!");
        // successResponse.setStatus(HttpStatus.CREATED);
        // successResponse.setStatusCode(201);
        
        return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<SuccessResponse<Void>> updateUser(
        @PathVariable int userId,
        @RequestBody UserDetailDTO userDTO
    ) {
        userService.updateUser(userId, userDTO);

        SuccessResponse<Void> successResponse = new SuccessResponse<>();
        // successResponse.setMessage("User updated successfully!");
        // successResponse.setStatus(HttpStatus.OK);
        // successResponse.setStatusCode(200);

        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<SuccessResponse<Void>> deleteUser(
        @PathVariable int userId
    ) {
        userService.deleteUser(userId);

        SuccessResponse<Void> successResponse = new SuccessResponse<>();
        // successResponse.setMessage("User deleted successfully!");
        // successResponse.setStatus(HttpStatus.NO_CONTENT);
        // successResponse.setStatusCode(204);

        return new ResponseEntity<>(successResponse, HttpStatus.NO_CONTENT);
    }
}
