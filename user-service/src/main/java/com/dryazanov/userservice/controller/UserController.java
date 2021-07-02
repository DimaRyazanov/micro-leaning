package com.dryazanov.userservice.controller;

import com.dryazanov.userservice.entity.User;
import com.dryazanov.userservice.service.UserService;
import com.dryazanov.userservice.vo.UserWithDepartment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/users")
@Slf4j
public class UserController {
    UserService userService;

    @PostMapping("/")
    public User save(@RequestBody User user) {
        log.info("Inside save method of UserController");
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public UserWithDepartment getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment method of UserController");
        return userService.getUserWithDepartment(userId);
    }
}
