package com.mahtzak.pizzeriamanagementapp.web.controllers;


import com.mahtzak.pizzeriamanagementapp.domain.model.User;
import com.mahtzak.pizzeriamanagementapp.domain.model.UserDetails;
import com.mahtzak.pizzeriamanagementapp.domain.repositories.UserDetailsRepository;
import com.mahtzak.pizzeriamanagementapp.domain.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/details")
public class UserDetailsController {

    UserDetailsRepository userDetailsRepository;
    UserRepository userRepository;

    public UserDetailsController(UserDetailsRepository userDetailsRepository, UserRepository userRepository) {
        this.userDetailsRepository = userDetailsRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String goToDetailsForm(/*HttpSession session,*/ Model model,
                                  @SessionAttribute(name = "user") User user){

//        boolean nullPointer=false;
//        try {
//            UserDetails userDetails = user.getUserDetails();
//        }catch(NullPointerException e){
//            nullPointer=true;
//        }
//        if(!nullPointer){
//            model.addAttribute("userDetails", user.getUserDetails());
//        }else{
//            model.addAttribute("userDetails", new UserDetails());
//        }
        UserDetails userDetails = userDetailsRepository.findFirstByUserEmail(user.getEmail());
        if (userDetails == null) {
            userDetails = new UserDetails();
        }
        model.addAttribute("userDetails", userDetails);
        return "user-details";
    }

    @PostMapping
    public String updateUserDetails(@ModelAttribute("userDetails")UserDetails userDetails,
                                    BindingResult result, @SessionAttribute(name="user") User user ) {
        /*if (result.hasErrors()){
            return "user-details";
        }
        User userToSave=userRepository.findFirstByEmail(user.getEmail());
        UserDetails userDetails1 = userDetailsRepository.findFirstByUserEmail(user.getEmail());
        if(userDetails == null) {
            userDetails.setUser(userToSave);
            userDetailsRepository.save(userDetails);
        }else {
            userDetailsRepository.updateUserDetails(userDetails.getFirstName(),
                    userDetails.getLastName(),userDetails.getAddress(),
                    userDetails.getPhoneNumber(),userToSave.getId());
        }*/

        /*boolean isNull=false;
        try{
            User user = (User)session.getAttribute("user");
            user.getUserDetails();
        }catch(NullPointerException e){
            isNull=true;
        }
        if(isNull){
          //  userRepository.updateUserDetails(userDetails);
            userDetailsRepository.save(userDetails);
            userDetails = userDetailsRepository.getAllFromLastSavedUserDetails(userDetails.getFirstName(),
                    userDetails.getLastName(),userDetails.getPhoneNumber());
            *//*userRepository.updateUserDetails(insert);*//*
            Long id =  userDetails.getId();
            User user = (User)session.getAttribute("user");
            userRepository.updateUserDetailsId(id,user.getId());
        }else{
           userDetailsRepository.updateUserDetails(userDetails.getFirstName(),
                   userDetails.getLastName(),userDetails.getAddress(),
                   userDetails.getPhoneNumber());
        }*/
        return "landing-site";
    }
}
