package com.mattbock.llas.cardApi.controller;

import com.mattbock.llas.cardApi.model.card.Card;
import com.mattbock.llas.cardApi.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path="/dev")
public class MainController {

    @Autowired
    private CardRepository cardRepository;

    @GetMapping(path="/allCards")
    public @ResponseBody Iterable<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @GetMapping(path="/beep")
    public @ResponseBody String beep() {
        return "boop";
    }
}
