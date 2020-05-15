package com.mattbock.llas.cardApi.controller;

import com.mattbock.llas.cardApi.model.card.Attribute;
import com.mattbock.llas.cardApi.model.card.CardType;
import com.mattbock.llas.cardApi.model.card.Rarity;
import com.mattbock.llas.cardApi.model.idol.Idol;
import com.mattbock.llas.cardApi.model.idol.IdolGroup;
import com.mattbock.llas.cardApi.model.idol.School;
import com.mattbock.llas.cardApi.model.idol.Subunit;
import com.mattbock.llas.cardApi.service.RefService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/ref")
@Api(value="Reference Data", description = "Endpoints for retrieving reference data. Reference data is anything that won't change outside of major game updates.")
public class RefController {

    @Autowired
    private RefService refService;

    @ApiOperation(value = "Retrieves list of all idols.", response = Idol.class)
    @GetMapping(path="/idols")
    public @ResponseBody Iterable<Idol> getAllIdols() {
        return refService.getIdols();
    }

    @ApiOperation(value="Retrieves list of all idol Groups.", response = IdolGroup.class)
    @GetMapping(path="/idolGroups")
    public @ResponseBody Iterable<IdolGroup> getAllIdolGroups() {
        return refService.getIdolGroups();
    }

    @ApiOperation(value="Retrieves list of all Rarities.", response = Rarity.class)
    @GetMapping(path="/rarities")
    public @ResponseBody Iterable<Rarity> getAllRarities() {
        return refService.getRarities();
    }

    @ApiOperation(value="Retrieves list of all Schools.", response = School.class)
    @GetMapping(path="/schools")
    public @ResponseBody Iterable<School> getAllSchools() {
        return refService.getSchools();
    }

    @ApiOperation(value="Retrieves list of all card types.", response = CardType.class)
    @GetMapping(path="/types")
    public @ResponseBody Iterable<CardType> getAllCardTypes() {
        return refService.getCardTypes();
    }

    @ApiOperation(value="Retrieves list of all card attributes.", response = Attribute.class)
    @GetMapping(path="/attributes")
    public @ResponseBody Iterable<Attribute> getAllCardAttributes() {
        return refService.getAttributes();
    }

    @ApiOperation(value="Retrieves list of all Subunits.", response = Subunit.class)
    @GetMapping(path="/subunits")
    public @ResponseBody Iterable<Subunit> getAllSubunits() {
        return refService.getSubunits();
    }
}
