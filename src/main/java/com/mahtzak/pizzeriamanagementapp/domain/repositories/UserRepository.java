package com.mahtzak.pizzeriamanagementapp.domain.repositories;


import com.mahtzak.pizzeriamanagementapp.domain.model.User;
import com.mahtzak.pizzeriamanagementapp.domain.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmailAndPassword(String email, String password);

    User findFirstByEmail(String email);

    User findFirstByUsername(String username);

    @Query(nativeQuery=true,value = "Select * from users where user_role='EMPLOYEE'")
    List<User> findAllWhereRoleIsEmployee();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("Update User u set u.userDetails=?1")
    void updateUserDetails(UserDetails userDetails);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true,
            value="Update users set details_id=?1 where id=?2")
    void updateUserDetailsId(Long id, Long userId);



}
