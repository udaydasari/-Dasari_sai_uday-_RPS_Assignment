package com.RPS_Assignment.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static org.apache.logging.log4j.util.StringBuilders.equalsIgnoreCase;

@Service
@Log4j2
public class RpsServiceImpl implements RpsService{
    private static final List<String> MOVES = Arrays.asList("Rock", "Paper", "Scissors");


    @Override
    public ResponseEntity<String> getGameResult(String playerMove) {
        if(!MOVES.contains(playerMove)){
            return new ResponseEntity<>("Give an value present in Rock , Paper ,Scissors",HttpStatus.BAD_REQUEST);

        }
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
        int computerMoveIndex = random.nextInt(MOVES.size());
        return MOVES.get(computerMoveIndex);
    }

}
