package com.mahtzak.pizzeriamanagementapp.core;


import com.mahtzak.pizzeriamanagementapp.web.dtos.RegistrationFormDTO;
import com.mahtzak.pizzeriamanagementapp.domain.model.User;
import com.mahtzak.pizzeriamanagementapp.domain.model.UserRole;
import com.mahtzak.pizzeriamanagementapp.domain.repositories.UserRepository;
import com.mahtzak.pizzeriamanagementapp.domain.repositories.UserRoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrationService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private UserRoleRepository userRoleRepository;

    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    public boolean register(RegistrationFormDTO form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setUsername(form.getUsername());
        String encodedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encodedPassword);
        user = userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setRole("ROLE_USER");
        userRole.setUser(user);
        userRole = userRoleRepository.save(userRole);

        return true;

    }
}
