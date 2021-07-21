package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String getUserGuess(){
        return "guess";
    }

    @GetMapping("/roll-dice/{guess}")
    public String compareGuess(@PathVariable int guess, Model model){
        int randomNumRolled = (int)(Math.random()* ((6 - 1) + 1) + 1);
        model.addAttribute("guess", "This is your guess: " + guess);
        model.addAttribute("randomRoll", randomNumRolled);
        model.addAttribute("isCorrect", guess == randomNumRolled);

        if ( guess == randomNumRolled){
            model.addAttribute("correctRoll", "You rolled correctly");
            model.addAttribute("correctRoll", "You win! \n your guess was " + guess + " and the roll was " + randomNumRolled);
        } else {
            model.addAttribute("incorrectRoll", "You rolled incorrectly");
            model.addAttribute("incorrectRoll", "Wrong! You guessed " + guess + " and the rolled a " + randomNumRolled);
        }
        return "guess";
    }

}
