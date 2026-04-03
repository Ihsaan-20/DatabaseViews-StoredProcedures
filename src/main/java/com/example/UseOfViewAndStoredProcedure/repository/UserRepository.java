package com.example.UseOfViewAndStoredProcedure.repository;


import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.example.UseOfViewAndStoredProcedure.dto.UserDepartmentDTO;
import com.example.UseOfViewAndStoredProcedure.dto.UserViewDTO;
import com.example.UseOfViewAndStoredProcedure.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
		
	// Fetch from VIEW
    @Query(value = "SELECT * FROM user_view", nativeQuery = true)
    List<UserViewDTO> getUserView();

    // Call Stored Procedure
    @Query(value = "CALL GetUsersBySalary(:salary)", nativeQuery = true)
    List<User> getUsersBySalary(@Param("salary") Double salary);
    
    // VIEW (JOIN)
    @Query(value = "SELECT * FROM user_department_view", nativeQuery = true)
    List<UserDepartmentDTO> getUserDepartmentView();

    // Stored Procedure (JOIN)
    @Query(value = "CALL GetUsersByDepartment(:dept)", nativeQuery = true)
    List<Object[]> getUsersByDepartment(@Param("dept") String dept);
}
