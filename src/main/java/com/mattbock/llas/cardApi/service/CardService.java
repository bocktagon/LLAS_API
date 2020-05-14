package com.mattbock.llas.cardApi.service;

import com.mattbock.llas.cardApi.model.card.Card;
import com.mattbock.llas.cardApi.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private RefService refService;


    public Iterable<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<Card> getById(int id) {
        return cardRepository.findById(id);
    }

    public Iterable<Card> getByName(String name) {
        return cardRepository.findByIdolFirstNameIgnoreCase(name);
    }

    public Iterable<Card> textSearch(String params) {
        List<String> tokens = Arrays.asList(params.split(" "));
        List<String> titleTokens = new ArrayList<>();

        Integer idolId = null;
        Integer rarityId = null;
        Integer typeId = null;
        Integer attributeId = null;
        String titleText = "%";

        for(String token: tokens){
            if(refService.getIdolNamesIds().get(token.toLowerCase()) != null) {
                idolId = refService.getIdolNamesIds().get(token.toLowerCase());
            }
            else if (refService.getRarityAbbreviationsIds().get(token.toLowerCase()) != null) {
                rarityId = refService.getRarityAbbreviationsIds().get(token.toLowerCase());
            }
            else if (refService.getTypeAbbreviationsIds().get(token.toLowerCase()) != null) {
                typeId = refService.getTypeAbbreviationsIds().get(token.toLowerCase());
            }
            else if (refService.getTypeNamesIds().get(token.toLowerCase()) != null) {
                typeId = refService.getTypeNamesIds().get(token.toLowerCase());
            }
            else if (refService.getAttributeNamesIds().get(token.toLowerCase()) != null) {
                attributeId = refService.getAttributeNamesIds().get(token.toLowerCase());
            }
            else {
                titleTokens.add(token.toLowerCase());
            }
        }

        if(titleTokens.size() > 0) {
            StringBuilder builder = new StringBuilder();
            builder.append("%");
            for(String token: titleTokens) {
                builder.append(token);
                builder.append(" ");
            }

            // remove trailing space
            if (builder.length() > 1) {
                builder.setLength(builder.length() - 1);
            }

            builder.append("%");
            titleText = builder.toString();
        }

        return cardRepository.findByTextSearch(idolId, rarityId, typeId, attributeId, titleText);
    }
}
