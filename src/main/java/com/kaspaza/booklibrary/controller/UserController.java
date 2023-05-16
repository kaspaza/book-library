package com.kaspaza.booklibrary.controller;

import com.kaspaza.booklibrary.domain.User;
import com.kaspaza.booklibrary.dto.UserDto;
import com.kaspaza.booklibrary.service.UserService;
import com.kaspaza.booklibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    @GetMapping("/users")
    private List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    private User getUsers(@PathVariable("userId") int userId) {
        return userService.getUserById(userId);
    }

    @DeleteMapping("/user/{userId}")
    private void deleteUser(@PathVariable("userId") int userId) {
        userService.delete(userId);
    }

    @PostMapping("/user")
    private int saveUser(@RequestBody User user) {
        bookService.saveOrUpdate(user.getBooksWritten());
        userService.saveOrUpdate(user);
        return user.getId();
    }

    @PutMapping("/user")
    private User updateUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return user;
    }

}
