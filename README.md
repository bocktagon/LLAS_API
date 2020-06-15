# LLAS_API
API for cards in Love Live All Stars to support various apps.

## Features
- Complete set of data for cards on EN and JP
- Endpoints to grab cards by id or name. More planned.
- Text search functionality

## Text Search Support
The goal of text search is to take any free text sent to the API and try to discern what card they are looking for without having to enforce a strict format. Currently the search will look for specific elements of a card that may be specified in the params, pull those out, and check the rest of the params against card titles.

Currently supported searchable elements:
- First names, and the following nicknames:
    - honk, birb, nozo, pana, yohane, maru, pomu, kasu, kasukasu
- Rarity
    - R, SR, UR
- Type
    - Voltage, Guard, Skill, Special
    - Also supports abbreviations
- Attribute
    - Active, Cool, Elegant, Natural, Pure, Smile
- Title 
    - Checks normal and idolized

Special cases:
- "\<name\> \<rarity(optional)\> #"
    - Search for a specific card based on the order it came out. Ex: "Rina UR 2" returns Vegetable Wonderland Rina. "Riko SR 2" will return KimiKoko Riko.
    - If you don't specify a rarity, it will search through URs.
- id search
    - Just giving a number will search by in-game school idol number. Ex: 112 is Blu Amor Umi
- "new" keyword
    - Returns the newest card that matches a search. Ex: "new Riko" returns Riko's newest card. "new Riko SR" return's Riko's newest SR.

Other planned searchable elements:
- Card Source
    - initial (in game at launch)
    - event (event reward)
    - gacha (normal gacha)
    - fes (fes gacha)
- Role
    - healer
    - shielder
    - scorer
    - etc.

Example searches:
- "party Kotori"
    - Returns "Welcome to the Party" Kotori
- "Elegant Dia UR"
    - Returns "Priestess Dance" Dia (because that's the only one that meets all those requirements)
- "Smile UR"
    - Returns all Smile UR cards
- "Snow Halation"
    - Returns all 9 Snow Halation cards
