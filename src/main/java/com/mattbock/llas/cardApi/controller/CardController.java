package com.mattbock.llas.cardApi.controller;

import com.mattbock.llas.cardApi.model.card.Card;
import com.mattbock.llas.cardApi.service.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/cards")
@Api(value="Card management", description = "Endpoints for retrieving card data.")
@CrossOrigin
public class CardController {

    @Autowired
    private CardService cardService;

    @ApiOperation(value="View all cards.", response = Card.class)
    @GetMapping("/all")
    public @ResponseBody Iterable<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @ApiOperation(value="Get a specific card by its ID.", response = Card.class)
    @GetMapping("/id/{id}")
    public @ResponseBody Optional<Card> getById(@PathVariable("id") int id) {
        return cardService.getById(id);
    }

    @ApiOperation(value="Get a list of all of a specified Idol's cards. First name only.", response = Card.class)
    @GetMapping("/idol/{name}")
    public @ResponseBody Iterable<Card> getByName(@PathVariable("name") String name) {
        return cardService.getByName(name);
    }

    @ApiOperation(value = "Get a list of all cards of a specific rarity.", response = Card.class)
    @GetMapping("/rarity/{rarity}")
    public @ResponseBody Iterable<Card> getByRarity(@PathVariable("rarity") String rarity){
        return cardService.getByRarity(rarity);
    }

    @ApiOperation(value = "Get a list of all cards of a specific attribute.", response = Card.class)
    @GetMapping("/attribute/{attribute}")
    public @ResponseBody Iterable<Card> getByattribute(@PathVariable("attribute") String attribute){
        return cardService.getByAttribute(attribute);
    }

    @ApiOperation(value = "Get a list of all cards of a specific type.", response = Card.class)
    @GetMapping("/type/{type}")
    public @ResponseBody Iterable<Card> getBytype(@PathVariable("type") String type){
        return cardService.getByType(type);
    }

    @ApiOperation(value = "Free text search for cards. See https://github.com/bocktagon/LLAS_API/blob/master/README.md#text-search-support for full details.", response = Card.class)
    @GetMapping("/search")
    public @ResponseBody Iterable<Card> search(@RequestParam String query) {
        return cardService.textSearch(query);
    }

    @GetMapping("/search/advanced")
    public @ResponseBody Iterable<Card> advancedSearch(@RequestParam String query) {
        return cardService.advancedSearch(query);
    }

}
