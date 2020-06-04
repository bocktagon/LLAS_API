package com.mattbock.llas.cardApi.service;

import com.mattbock.llas.cardApi.model.card.Card;
import com.mattbock.llas.cardApi.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private RefService refService;

    private Map<String, Integer> memes = new HashMap<String, Integer>() {
        {
            put("gay riko", 229);
            put("gay", 229);
            put("hac", 173);
            put("coptori", 12);
        }
    };


    public Iterable<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<Card> getById(int id) {
        return cardRepository.findById(id);
    }

    public Iterable<Card> getByName(String name) {
        return cardRepository.findByIdolFirstNameIgnoreCase(name);
    }

    public Iterable<Card> getByRarity(String rarity) {
        return cardRepository.findByRarity(rarity);
    }

    public Iterable<Card> getByAttribute(String attribute) {
        return cardRepository.findByAttributeNameIgnoreCase(attribute);
    }

    public Iterable<Card> getByType(String type) {
        return cardRepository.findByCardType(type);
    }

    public Iterable<Card> textSearch(String params) {
        List<String> tokens = Arrays.asList(params.split(" "));
        List<String> titleTokens = new ArrayList<>();

        // Look for special cases first

        // 1. Memes
        if(memes.get(params) != null) {
            return new ArrayList<Card>() {
                {
                    add(cardRepository.findById(memes.get(params)).get());
                }
            };
        }

        // 2. <name> #
        if(params.matches("[a-zA-Z]+[ ][0-9]+")) {
            List<Card> cards = cardRepository.findByIdolIdAndRarity(refService.getIdolNamesIds().get(tokens.get(0).toLowerCase()), "UR");

            int requestedNum = Integer.valueOf(tokens.get(1));
            ArrayList<Card> response = new ArrayList<>();
            if(cards.size() > 0 && requestedNum <= cards.size()) {
                response.add(cards.get(requestedNum - 1));
            }

            return response;
        }

        // 3. specific ID
        if(params.matches("[0-9]+")) {
            ArrayList<Card> response = new ArrayList<>();

            Optional card = cardRepository.findById(Integer.valueOf(params));

            if (card.isPresent()) {
                response.add((Card) card.get());
            }

            return response;
        }

        // Otherwise run a general text search

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
