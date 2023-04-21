package com.RPS_Assignment.controller;

import com.RPS_Assignment.service.RpsService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class RpsController {
    @Autowired
    private RpsService rpsService;

    @PostMapping("/play")
    public ResponseEntity<String> play(@RequestParam String playerMove) {
        log.info("Given player move as: " + playerMove);
        log.info("Calling service layer");
        return rpsService.getGameResult(playerMove);
    }


}
