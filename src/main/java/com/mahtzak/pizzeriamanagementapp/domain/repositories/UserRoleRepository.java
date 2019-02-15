package com.mahtzak.pizzeriamanagementapp.domain.repositories;

import com.mahtzak.pizzeriamanagementapp.domain.model.User;
import com.mahtzak.pizzeriamanagementapp.domain.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query("SELECT r.user FROM UserRole r WHERE r.role = ?1")
    List<User> findAllUsersByRole(String roleName);
}
