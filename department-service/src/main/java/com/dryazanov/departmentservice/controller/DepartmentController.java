package com.dryazanov.departmentservice.controller;

import com.dryazanov.departmentservice.entity.Department;
import com.dryazanov.departmentservice.service.DepartmentService;
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
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    DepartmentService departmentService;

    @PostMapping("/")
    public Department save(@RequestBody Department department) {
        log.info("Inside save method in DepartmentController");
        return departmentService.save(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id) {
        log.info("Inside findById method in DepartmentController");
        return departmentService.findById(id);
    }
}
