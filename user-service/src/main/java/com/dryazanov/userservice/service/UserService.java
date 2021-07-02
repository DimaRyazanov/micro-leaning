package com.dryazanov.userservice.service;

import com.dryazanov.userservice.entity.User;
import com.dryazanov.userservice.repository.UserRepository;
import com.dryazanov.userservice.vo.Department;
import com.dryazanov.userservice.vo.UserWithDepartment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {
    UserRepository userRepository;
    RestTemplate restTemplate;

    public User save(User user) {
        log.info("Inside save method of UserService");
        return userRepository.save(user);
    }

    public UserWithDepartment getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserService");
        UserWithDepartment userWithDepartment = new UserWithDepartment();

        User user = userRepository.findById(userId).orElse(null);
        userWithDepartment.setUser(user);

        if (user != null) {
            Department department = restTemplate.getForObject(
                    "http://localhost:9001/departments/" + user.getDepartmentId(), Department.class);
            userWithDepartment.setDepartment(department);
        }

        return userWithDepartment;
    }
}
