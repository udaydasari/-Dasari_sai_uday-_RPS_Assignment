package com.praticemicroservice.CloudGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
    @GetMapping("/gameRPSServiceFallBack")
    public String orderServiceFallBack(){
        return "Game RPS service is down!!!!!! ";
    }
}
