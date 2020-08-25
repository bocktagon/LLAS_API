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
            put("gay", 229);
            put("hac", 173);
            put("coptori", 12);
            put("meme yoshiko", 145);
            put("meme yohane", 145);
            put("fesuna", 146);
            put("broken", 146);
            put("screeching nico", 233);
            put("cabbage rina", 215);
            put("step on me", 129);
            put("thicc step on me", 193);
            put("gay step on me", 248);
            put("my face e no ippo", 238);
            put("wheelchair maki", 220);
            put("exodia the forbidden one", 189);
            put("exodia", 189);
            put("right arm of the forbidden one", 117);
            put("left arm of the forbidden one", 220);
            put("right leg of the forbidden one", 225);
            put("left leg of the forbidden one", 272);
            put("sideways maki", 272);
            put("mom ass", 298);
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

    public Iterable<Card> textSearch(String paramsRaw) {
        String params = paramsRaw.toLowerCase();
        List<String> tokens = new ArrayList<>(Arrays.asList(params.split(" ")));

        // Look for special cases first

        // 1. Memes
        if(memes.get(params) != null) {
            return new ArrayList<Card>() {
                {
                    add(cardRepository.findById(memes.get(params)).get());
                }
            };
        }

        // 2. <name> <rarity(opt)> #
        if(params.matches("[a-z]+\\s(r\\s|sr\\s|ur\\s)?[0-9]+")) {

            String rarity = "UR";
            if(tokens.size() == 3) {
                rarity = tokens.get(1);
            }

            List<Card> cards = cardRepository.findByIdolIdAndRarity(refService.getIdolNamesAndNicknamesIds().get(tokens.get(0)), rarity.toUpperCase());

            int requestedNum;
            if(tokens.size() == 3) {
                requestedNum = Integer.valueOf(tokens.get(2));
            } else {
                requestedNum = Integer.valueOf(tokens.get(1));
            }


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

        // 4. Keywords
        // "new" returns the most recent card that matches a search
        if(tokens.contains("new")) {
            tokens.remove("new");
            List<Card> searchResults = runGeneralTextSearch(tokens);

            // If the search comes back empty or with only 1 result
            if(searchResults.size() < 2) {
                return searchResults;
            }

            // Otherwise just return the most recent card
            return searchResults.subList(searchResults.size() - 1, searchResults.size());
        }

        // Otherwise run a general text search
        return runGeneralTextSearch(tokens);

    }

    private List<Card> runGeneralTextSearch(List<String> tokens) {
        Integer idolId = null;
        Integer rarityId = null;
        Integer typeId = null;
        Integer attributeId = null;
        Integer sourceId = null;
        String titleText = "%";
        List<String> titleTokens = new ArrayList<>();

        int indexToReturn = -1;
        if(tokens.get(tokens.size() - 1).matches("\\d+")) {
            indexToReturn = Integer.valueOf(tokens.get(tokens.size() - 1)) - 1;
            tokens.remove(tokens.size() - 1);
        }

        for(String token: tokens){
            if(refService.getIdolNamesAndNicknamesIds().get(token) != null) {
                idolId = refService.getIdolNamesAndNicknamesIds().get(token);
            }
            else if (refService.getRarityAbbreviationsIds().get(token) != null) {
                rarityId = refService.getRarityAbbreviationsIds().get(token);
            }
            else if (refService.getTypeAbbreviationsIds().get(token) != null) {
                typeId = refService.getTypeAbbreviationsIds().get(token);
            }
            else if (refService.getTypeNamesIds().get(token) != null) {
                typeId = refService.getTypeNamesIds().get(token);
            }
            else if (refService.getAttributeNamesIds().get(token) != null) {
                attributeId = refService.getAttributeNamesIds().get(token);
            }
            else if (refService.getCardSourcesIds().get(token) != null) {
                sourceId = refService.getCardSourcesIds().get(token);
            }
            else {
                titleTokens.add(token);
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

        List<Card> results = cardRepository.findByTextSearch(idolId, rarityId, typeId, attributeId, sourceId, titleText);

        if (indexToReturn >= 0) {
            return results.subList(indexToReturn, indexToReturn + 1);
        }

        else return results;
    }
}
