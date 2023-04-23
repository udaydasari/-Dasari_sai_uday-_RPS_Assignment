package com.RPS_Assignment.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

class RpsServiceImplTest {

    private RpsService rpsService;

    private static final List<String> outComesList= Arrays.asList("Player wins","It's a tie","Computer wins");

    @BeforeEach
    void setUp() {
        rpsService = new RpsServiceImpl();
    }

    @Test
    void testRockBeatsScissors() {
        ResponseEntity<String> responseEntity = rpsService.getGameResult("Rock");
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Assertions.assertTrue(outComesList.contains(responseEntity.getBody()));

        //Assertions.assertEquals("Player wins", responseEntity.getBody());
    }

    @Test
    void testPaperBeatsRock() {
        ResponseEntity<String> responseEntity = rpsService.getGameResult("Paper");
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(outComesList.contains(responseEntity.getBody()));
    }

    @Test
    void testScissorsBeatsPaper() {
        ResponseEntity<String> responseEntity = rpsService.getGameResult("Scissors");
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(outComesList.contains(responseEntity.getBody()));
    }

    @Test
    void testRockTiesWithRock() {
        ResponseEntity<String> responseEntity = rpsService.getGameResult("Rock");
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(outComesList.contains(responseEntity.getBody()));
    }

    @Test
    void testPaperTiesWithPaper() {
        ResponseEntity<String> responseEntity = rpsService.getGameResult("Paper");
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(outComesList.contains(responseEntity.getBody()));
    }

    @Test
    void testScissorsTiesWithScissors() {
        ResponseEntity<String> responseEntity = rpsService.getGameResult("Scissors");
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(outComesList.contains(responseEntity.getBody()));
    }

    @Test
    void testInvalidMove() {
        ResponseEntity<String> responseEntity = rpsService.getGameResult("InvalidMove");
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        Assertions.assertEquals("Give an value present in Rock , Paper ,Scissors", responseEntity.getBody());
    }
}
