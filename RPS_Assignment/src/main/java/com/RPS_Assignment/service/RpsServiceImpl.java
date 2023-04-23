package com.RPS_Assignment.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.logging.log4j.util.StringBuilders.equalsIgnoreCase;

@Service
@Log4j2
public class RpsServiceImpl implements RpsService{
    private static final List<String> MOVES = Arrays.asList("Rock", "Paper", "Scissors");
    private static final Random RANDOM = new Random();


    @Override
    public ResponseEntity<String> getGameResult(String playerMove) {


        log.info("Calculating Random computer move");

        int index = RANDOM.nextInt(MOVES.size());

        String computerMove = MOVES.get(index);
        log.info("Random computer Move calculated as: "+computerMove);
        log.info("Calculating the winner based on playerMove and ComputerMove");
        String result= "";//new StringBuilder("");



        Map<String, String> winningMoves = new HashMap<>();
        winningMoves.put("Rock", "Scissors");
        winningMoves.put("Scissors", "Paper");
        winningMoves.put("Paper", "Rock");

        if (winningMoves.get(playerMove).equals(computerMove)) {
            result= "Player wins";
        } else if (winningMoves.get(computerMove).equals(playerMove)) {
            result=  "Computer wins";
        } else {
            result=  "It's a tie";
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

//    public String generateComputerMove() {
//        Random random = new Random();
//        int computerMoveIndex = random.nextInt(MOVES.size());
//        return MOVES.get(computerMoveIndex);
//    }

}
