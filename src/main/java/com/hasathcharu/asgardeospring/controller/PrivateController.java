package com.hasathcharu.asgardeospring.controller;

import com.hasathcharu.asgardeospring.dto.MessageResponse;
import com.hasathcharu.asgardeospring.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
public class PrivateController {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public MessageResponse getPrivateMessage(){
        return new MessageResponse("This is a private route, only authenticated users can access this.");
    }

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserMessage(Authentication authentication){
        Jwt userDetails = (Jwt) authentication.getPrincipal();
        System.out.println("User has authorities: " + authentication.getAuthorities());
        return new UserResponse(userDetails.getClaim("given_name") + " " + userDetails.getClaim("family_name"), userDetails.getClaim("username"), userDetails.getClaim("scope"));
    }

}
