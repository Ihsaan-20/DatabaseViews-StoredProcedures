package com.example.UseOfViewAndStoredProcedure.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.UseOfViewAndStoredProcedure.dto.UserDepartmentDTO;
import com.example.UseOfViewAndStoredProcedure.dto.UserViewDTO;
import com.example.UseOfViewAndStoredProcedure.entity.User;
import com.example.UseOfViewAndStoredProcedure.repository.UserRepository;

import java.util.*;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }
    
    public List<UserViewDTO> getUserView() {
        return repo.getUserView();
    }

    public List<User> getUsersBySalary(Double salary) {
        return repo.getUsersBySalary(salary);
    }
    
//    @Transactional
//    public List<User> getUsersBySalaryProcedureAnnotation(Double salary) {
//        return repo.getUsersBySalaryProcedureAnnotation(salary);
//    }
    
    // VIEW
    public List<UserDepartmentDTO> getUserDepartmentView() {
        return repo.getUserDepartmentView();
    }

    // Stored Procedure with mapping
    public List<Map<String, Object>> getUsersByDepartment(String dept) {

        List<Object[]> rows = repo.getUsersByDepartment(dept);

        List<Map<String, Object>> result = new ArrayList<>();

        for (Object[] row : rows) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", row[0]);
            map.put("name", row[1]);
            map.put("email", row[2]);
            map.put("dept_name", row[3]);
            result.add(map);
        }

        return result;
    }
}