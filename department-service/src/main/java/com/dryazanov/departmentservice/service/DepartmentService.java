package com.dryazanov.departmentservice.service;

import com.dryazanov.departmentservice.entity.Department;
import com.dryazanov.departmentservice.repository.DepartmentRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class DepartmentService {
    DepartmentRepository repository;

    public Department save(Department department) {
        log.info("Inside save of DepartmentService");
        return repository.save(department);
    }

    public Department findById(Long id) {
        log.info("Inside findById of DepartmentService");
        return repository.findById(id).orElse(null);
    }
}
