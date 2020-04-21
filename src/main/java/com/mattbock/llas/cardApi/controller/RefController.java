package com.mattbock.llas.cardApi.controller;

import com.mattbock.llas.cardApi.model.card.Rarity;
import com.mattbock.llas.cardApi.model.idol.Idol;
import com.mattbock.llas.cardApi.model.idol.IdolGroup;
import com.mattbock.llas.cardApi.model.idol.School;
import com.mattbock.llas.cardApi.model.idol.Subunit;
import com.mattbock.llas.cardApi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="api/ref")
public class RefController {

    @Autowired
    private IdolRepository idolRepository;

    @Autowired
    private IdolGroupRespository idolGroupRespository;

    @Autowired
    private RarityRepository rarityRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private SubunitRepository subunitRepository;

    @GetMapping(path="/idols")
    public @ResponseBody Iterable<Idol> getAllIdols() {
        return idolRepository.findAll();
    }

    @GetMapping(path="/idolGroups")
    public @ResponseBody Iterable<IdolGroup> getAllIdolGroups() {
        return idolGroupRespository.findAll();
    }

    @GetMapping(path="/rarities")
    public @ResponseBody Iterable<Rarity> getAllRarities() {
        return rarityRepository.findAll();
    }

    @GetMapping(path="/schools")
    public @ResponseBody Iterable<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @GetMapping(path="/subunits")
    public @ResponseBody Iterable<Subunit> getAllSubunits() {
        return subunitRepository.findAll();
    }
}
