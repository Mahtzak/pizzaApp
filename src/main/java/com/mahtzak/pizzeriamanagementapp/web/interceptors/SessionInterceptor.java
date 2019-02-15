package com.mahtzak.pizzeriamanagementapp.web.interceptors;

import com.mahtzak.pizzeriamanagementapp.domain.model.User;
import com.mahtzak.pizzeriamanagementapp.domain.repositories.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;



    @Component
    public class SessionInterceptor extends HandlerInterceptorAdapter {

    private UserRepository userRepository;

        public SessionInterceptor(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            Principal userPrincipal = request.getUserPrincipal();
            if (userPrincipal != null) {
                HttpSession session = request.getSession();
                if (session.getAttribute("user") == null) {
                    User user = userRepository.findFirstByEmail(userPrincipal.getName());
                    if (user != null) {
                        session.setAttribute("user", user);
                    }
                }
            }
            return true;
        }
    }

