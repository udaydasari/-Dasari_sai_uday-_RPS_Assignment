package com.RPS_Assignment.service;

import org.springframework.http.ResponseEntity;

public interface RpsService {
    ResponseEntity<String> getGameResult(String playerMove);
}
