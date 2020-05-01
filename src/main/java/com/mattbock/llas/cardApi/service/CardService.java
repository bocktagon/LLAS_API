package com.mattbock.llas.cardApi.service;

import com.mattbock.llas.cardApi.model.card.Card;
import com.mattbock.llas.cardApi.repository.CardRepository;
import com.mattbock.llas.cardApi.util.RefData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Iterable<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<Card> getById(int id) {
        return cardRepository.findById(id);
    }

    public Iterable<Card> getByName(String name) {
        return cardRepository.findByIdolFirstNameIgnoreCase(name);
    }

    public Iterable<Card> search(String params) {
        String[] tokens = params.split( " ");

        Integer id = null;
        for(String token: tokens){
            id = RefData.idolNames.get(token);
        }

        if(id == null) {
            return new  ArrayList<>(0);
        }

        return cardRepository.findByIdolId(id);
    }
}
