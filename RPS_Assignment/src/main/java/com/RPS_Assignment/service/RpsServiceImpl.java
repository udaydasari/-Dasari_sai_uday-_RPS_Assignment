package com.RPS_Assignment.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;
@Log4j2
@Service
public class RpsServiceImpl implements RpsService{
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    @Override
    public ResponseEntity<String> getGameResult(String playerMove) {
        log.info("Calculating Random computer move");
        String computerMove = generateComputerMove();
        log.info("Random computer Move calculated as: "+computerMove);
        log.info("Calculating the winner based on playerMove and ComputerMove");
        String result= "";//new StringBuilder("");
        if (playerMove.equals("Rock") && computerMove.equals("Scissors")) {
            result="Player wins";
        } else if (playerMove.equals("Scissors") && computerMove.equals("Paper")) {
            result="Player wins";
        } else if (playerMove.equals("Paper") && computerMove.equals("Rock")) {
            result="Player wins";
        } else if (computerMove.equals("Rock") && playerMove.equals("Scissors")) {
            result="Computer wins";
        } else if (computerMove.equals("Scissors") && playerMove.equals("Paper")) {
            result="Computer wins";
        } else if (computerMove.equals("Paper") && playerMove.equals("Rock")) {
            result="Computer wins";
        } else {
            result= "Its an tie";
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    private String generateComputerMove() {
        Random random = new Random();
        int computerMoveIndex = random.nextInt(MOVES.length);
        return MOVES[computerMoveIndex];
    }

}
