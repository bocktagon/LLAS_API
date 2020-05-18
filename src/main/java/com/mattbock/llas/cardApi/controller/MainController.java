package com.mattbock.llas.cardApi.controller;

import com.mattbock.llas.cardApi.model.card.Card;
import com.mattbock.llas.cardApi.repository.CardRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path="/dev")
@Api(value="Dev controller.", description = "Just for testing things. Nothing important happens here.")
@CrossOrigin
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
