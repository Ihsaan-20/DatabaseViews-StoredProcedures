package com.example.UseOfViewAndStoredProcedure.controllers;
import org.springframework.web.bind.annotation.*;

import com.example.UseOfViewAndStoredProcedure.dto.UserDepartmentDTO;
import com.example.UseOfViewAndStoredProcedure.dto.UserViewDTO;
import com.example.UseOfViewAndStoredProcedure.entity.User;
import com.example.UseOfViewAndStoredProcedure.services.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    
    // API for VIEW
    @GetMapping("/view")
    public List<UserViewDTO> getViewDataSingle() {
        return service.getUserView();
    }

    // API for Stored Procedure
    @GetMapping("/salary")
    public List<User> getBySalary(@RequestParam Double salary) {
        return service.getUsersBySalary(salary);
    }
       
    // VIEW (JOIN)
    @GetMapping("/view-multi")
    public List<UserDepartmentDTO> getViewData() {
        return service.getUserDepartmentView();
    }

    // Stored Procedure (JOIN)
    @GetMapping("/department")
    public List<Map<String, Object>> getByDepartment(@RequestParam String dept) {
        return service.getUsersByDepartment(dept);
    }
}
