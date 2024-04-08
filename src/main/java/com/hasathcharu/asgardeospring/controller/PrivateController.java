package com.hasathcharu.asgardeospring.controller;

import com.hasathcharu.asgardeospring.dto.MessageResponse;
import com.hasathcharu.asgardeospring.dto.UserResponse;
import org.springframework.http.HttpStatus;
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
    public UserResponse getUserMessage(){
        return new UserResponse("hasathcharu", "haritha@hasathcharu.com", new String[]{"ROLE_USER"});
    }

}
