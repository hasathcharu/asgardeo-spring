package com.hasathcharu.asgardeospring.controller;

import com.hasathcharu.asgardeospring.dto.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public MessageResponse getAdminMessage(){
        return new MessageResponse("This is an admin route, only admin users can access this.");
    }

}
