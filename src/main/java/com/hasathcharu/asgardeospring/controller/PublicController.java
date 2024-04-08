package com.hasathcharu.asgardeospring.controller;

import com.hasathcharu.asgardeospring.dto.MessageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping
    public MessageResponse getPublicMessage(){
        return new MessageResponse("This is a public route, anyone can access this.");
    }

}
