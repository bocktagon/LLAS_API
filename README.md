# LLAS_API
API for cards in Love Live All Stars to support various apps.

## Features
- Complete set of data for cards on EN and JP
- Endpoints to grab cards by id or name. More planned.
- Text search functionality

## Text Search Support
The goal of text search is to take any free text sent to the API and try to discern what card they are looking for without having to enforce a strict format. Currently the search will look for specific elements of a card that may be specified in the params, pull those out, and check the rest of the params against card titles.

Currently supported searchable elements:
- First name
- Rarity
    - R, SR, UR
- Type
    - Voltage, Guard, Skill, Special
    - Also supports abbreviations
- Attribute
    - Active, Cool, Elegant, Natural, Pure, Smile
- Title 
    - Checks normal and idolized

Other planned searchable elements:
- Source
    - initial (in game at the start)
    - event (event reward)
    - gacha (normal or event gacha)
    - fes (fes gacha)
- Role
    - healer
    - shielder
    - scorer
    - etc.
