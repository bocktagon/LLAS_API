package com.mattbock.llas.cardApi.controller;

import com.mattbock.llas.cardApi.model.card.Card;
import com.mattbock.llas.cardApi.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/{id}")
    public @ResponseBody Optional<Card> getById(@PathVariable("id") int id) {
        return cardService.getById(id);
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/byName/{name}")
    public @ResponseBody Iterable<Card> getByName(@PathVariable("name") String name) {
        return cardService.getByName(name);
    }

    @GetMapping("/search")
    public @ResponseBody Iterable<Card> search(@RequestParam String params) {
        return cardService.search(params);
    }

}
