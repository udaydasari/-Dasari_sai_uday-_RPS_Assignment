package com.RPS_Assignment.controller;

import com.RPS_Assignment.service.RpsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class RpsControllerTest {

    private static final List<String> MOVES = Arrays.asList("Rock", "Paper", "Scissors");

    @Mock
    private RpsService rpsService;

    @InjectMocks
    private RpsController rpsController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Test RPS with valid player move")
    @ParameterizedTest
    @ValueSource(strings = {"Rock", "Paper", "Scissors"})
    public void testRpsWithValidPlayerMove(String playerMove) {
        ResponseEntity<String> expectedResponseEntity = new ResponseEntity<>("Player wins", HttpStatus.OK);

        when(rpsService.getGameResult(playerMove)).thenReturn(expectedResponseEntity);

        ResponseEntity<String> actualResponseEntity = rpsController.play(playerMove);

        verify(rpsService, times(1)).getGameResult(playerMove);

        Assertions.assertEquals(expectedResponseEntity, actualResponseEntity);
    }

    @DisplayName("Test RPS with invalid player move")
    @Test
    public void testRpsWithInvalidPlayerMove() {
        String invalidPlayerMove = "Invalid";

        ResponseEntity<String> expectedResponseEntity = new ResponseEntity<>("Give an value present in Rock , Paper ,Scissors", HttpStatus.BAD_REQUEST);

        ResponseEntity<String> actualResponseEntity = rpsController.play(invalidPlayerMove);

        verify(rpsService, times(0)).getGameResult(invalidPlayerMove);

        Assertions.assertEquals(expectedResponseEntity, actualResponseEntity);
    }

    @DisplayName("Test RPS with empty player move")
    @Test
    public void testRpsWithEmptyPlayerMove() {
        String emptyPlayerMove = "";

        ResponseEntity<String> expectedResponseEntity = new ResponseEntity<>("Give ur move ", HttpStatus.BAD_REQUEST);

        ResponseEntity<String> actualResponseEntity = rpsController.play(emptyPlayerMove);

        verify(rpsService, times(0)).getGameResult(emptyPlayerMove);

        Assertions.assertEquals(expectedResponseEntity, actualResponseEntity);
    }
}
