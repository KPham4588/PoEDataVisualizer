package com.PhamKornbluhGroup;

import com.PhamKornbluhGroup.DAO.CrucibleDAO;

import com.PhamKornbluhGroup.DTO.CrucibleDTO;
import com.PhamKornbluhGroup.DTO.CrucibleNodeDTO;
import com.PhamKornbluhGroup.utilities.SessionPool;

import java.util.ArrayList;

public class runner {

    public static void main(String[] args) {
        CrucibleDTO testCrucible = new CrucibleDTO();
        testCrucible.setLayout("Khoa's new layout");

        ArrayList<CrucibleNodeDTO> testNodes = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            CrucibleNodeDTO node = new CrucibleNodeDTO();
            node.setIn("hi Khoa " + i);
            node.setOut("ho Khoa " + i);
            testNodes.add(node);
        }
        testCrucible.setNodes(testNodes);

        CrucibleDAO testCrucibleInsert = new CrucibleDAO();
        testCrucibleInsert.insertCrucible(testCrucible);

        System.out.println();
        System.out.println();

        SessionPool.getSession().close();
        System.out.println("Reached the end of main without exception");

        //p This is the old way that we got and saved 1 API Result file
        //System.out.println("WE ARE RUNNING THE getAndSaveOnePOEAPIResult FUNCTION");
        //GGGAPIHandler handler = new GGGAPIHandler();
        //handler.getAndSaveOnePOEAPIResult();

        //p This gets gets and saves 10 API result files
//        BulkAPIResultHandler handler = new BulkAPIResultHandler();
//        handler.getBulkPOEApiResults(10);

        //p This is the new logic to parse JSON by passing in the data
//        DeprecatedJSONParsingTool tool = new DeprecatedJSONParsingTool();
//        APIResultData apiResultData = new APIResultData();
//        apiResultData.setContent(returnTestJSON());
//        tool.traverseJson(apiResultData);
//        tool.printElements();

//        BulkJSONTester.run(100);

//        BulkAPIUtils.loadKnownFields();
//        BulkAPIUtils.knownFields.stream().sorted().forEach(System.out::println);
//        for (String element : BulkAPIUtils.knownFields) {
//            System.out.println(element);
//        }
    }

    public static String returnTestJSON() {
        String json = """
                        {
                           "id": "c5956c281ee71cb55b4737c85524e9094700bab32b425fea1a32aaba4c76f7e8",
                           "public": true,
                           "accountName": "KeepHopeAlive#7579",
                           "stash": "R",
                           "stashType": "PremiumStash",
                           "league": "Standard",
                           "items": [
                             {
                               "verified": false,
                               "fakeFieldInsideItems": true,
                               "w": 1,
                               "h": 3,
                               "icon": "https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvV2VhcG9ucy9PbmVIYW5kV2VhcG9ucy9XYW5kcy9XYW5kMyIsInciOjEsImgiOjMsInNjYWxlIjoxfV0/6322bd53f5/Wand3.png",
                               "league": "Standard",
                               "id": "d7e37c3a0f2cf27b17f6fc4acc80ae3f58dc97dbc8f47c1ba9f12b756804235e",
                               "sockets": [
                                 {
                                   "group": 0,
                                   "attr": "I",
                                   "sColour": "B"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "I",
                                   "sColour": "B"
                                 },
                                 {
                                   "group": 1,
                                   "attr": "D",
                                   "sColour": "G"
                                 }
                               ],
                               "name": "Sol Needle",
                               "typeLine": "Imbued Wand",
                               "baseType": "Imbued Wand",
                               "rarity": "Rare",
                               "ilvl": 82,
                               "identified": true,
                               "properties": [
                                 {
                                   "name": "Wand",
                                   "values": [],
                                   "displayMode": 0
                                 },
                                 {
                                   "name": "Physical Damage",
                                   "values": [
                                     [
                                       "27-50",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 9
                                 },
                                 {
                                   "name": "Critical Strike Chance",
                                   "values": [
                                     [
                                       "8.00%",
                                       0
                                     ],
                                     [
                                       "8.00%",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 12
                                 },
                                 {
                                   "name": "Attacks per Second",
                                   "values": [
                                     [
                                       "1.60",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 13
                                 }
                               ],
                               "requirements": [
                                 {
                                   "name": "Level",
                                   "values": [
                                     [
                                       "59",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 62
                                 },
                                 {
                                   "name": "Int",
                                   "values": [
                                     [
                                       "188",
                                       0
                                     ]
                                   ],
                                   "displayMode": 1,
                                   "type": 65
                                 }
                               ],
                               "implicitMods": [
                                 "17% increased Spell Damage"
                               ],
                               "explicitMods": [
                                 "61% increased Spell Damage",
                                 "24% increased Cold Damage",
                                 "+36% to Global Critical Strike Multiplier"
                               ],
                               "craftedMods": [
                                 "54% increased Spell Critical Strike Chance"
                               ],
                               "frameType": 2,
                               "extended": {
                                 "category": "weapons",
                                 "subcategories": [
                                   "wand"
                                 ],
                                 "prefixes": 1,
                                 "suffixes": 3
                               },
                               "x": 11,
                               "y": 6,
                               "inventoryId": "Stash1",
                               "socketedItems": []
                             },
                             {
                               "verified": false,
                               "w": 2,
                               "h": 4,
                               "icon": "https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvV2VhcG9ucy9Ud29IYW5kV2VhcG9ucy9TdGF2ZXMvU3RhZmY2IiwidyI6MiwiaCI6NCwic2NhbGUiOjF9XQ/5e3de6f391/Staff6.png",
                               "league": "Standard",
                               "id": "7efc4a8dc88db0984410a9e54a4506482b2eae0bbc3a6a16d5db77497d79c03a",
                               "sockets": [
                                 {
                                   "group": 0,
                                   "attr": "D",
                                   "sColour": "G"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "S",
                                   "sColour": "R"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "S",
                                   "sColour": "R"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "D",
                                   "sColour": "G"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "I",
                                   "sColour": "B"
                                 }
                               ],
                               "name": "",
                               "typeLine": "Scholar's Imperial Staff of Needling",
                               "baseType": "Imperial Staff",
                               "rarity": "Magic",
                               "ilvl": 73,
                               "identified": true,
                               "properties": [
                                 {
                                   "name": "Staff",
                                   "values": [],
                                   "displayMode": 0
                                 },
                                 {
                                   "name": "Physical Damage",
                                   "values": [
                                     [
                                       "57-171",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 9
                                 },
                                 {
                                   "name": "Critical Strike Chance",
                                   "values": [
                                     [
                                       "9.52%",
                                       1
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 12
                                 },
                                 {
                                   "name": "Attacks per Second",
                                   "values": [
                                     [
                                       "1.15",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 13
                                 },
                                 {
                                   "name": "Weapon Range: {0} metres",
                                   "values": [
                                     [
                                       "1.3",
                                       0
                                     ]
                                   ],
                                   "displayMode": 3,
                                   "type": 14
                                 }
                               ],
                               "requirements": [
                                 {
                                   "name": "Level",
                                   "values": [
                                     [
                                       "66",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 62
                                 },
                                 {
                                   "name": "Str",
                                   "values": [
                                     [
                                       "113",
                                       0
                                     ]
                                   ],
                                   "displayMode": 1,
                                   "type": 63
                                 },
                                 {
                                   "name": "Int",
                                   "values": [
                                     [
                                       "113",
                                       0
                                     ]
                                   ],
                                   "displayMode": 1,
                                   "type": 65
                                 }
                               ],
                               "implicitMods": [
                                 "+12% Chance to Block Attack Damage while wielding a Staff"
                               ],
                               "explicitMods": [
                                 "49% increased Spell Damage",
                                 "12% increased Critical Strike Chance"
                               ],
                               "frameType": 1,
                               "extended": {
                                 "category": "weapons",
                                 "subcategories": [
                                   "twomelee",
                                   "staff"
                                 ],
                                 "prefixes": 1,
                                 "suffixes": 1
                               },
                               "x": 2,
                               "y": 3,
                               "inventoryId": "Stash2",
                               "socketedItems": []
                             },
                             {
                               "verified": false,
                               "w": 2,
                               "h": 3,
                               "icon": "https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvQXJtb3Vycy9Cb2R5QXJtb3Vycy9Cb2R5U3RyMUMiLCJ3IjoyLCJoIjozLCJzY2FsZSI6MX1d/94a3d5d98e/BodyStr1C.png",
                               "league": "Standard",
                               "id": "9a38a4f8986a1ed6f8a7744d13808519c7d367151ccf290d8fa9c068ffe59ed7",
                               "sockets": [
                                 {
                                   "group": 0,
                                   "attr": "S",
                                   "sColour": "R"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "D",
                                   "sColour": "G"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "I",
                                   "sColour": "B"
                                 }
                               ],
                               "name": "",
                               "typeLine": "Astral Plate",
                               "baseType": "Astral Plate",
                               "rarity": "Normal",
                               "ilvl": 77,
                               "identified": true,
                               "properties": [
                                 {
                                   "name": "Armour",
                                   "values": [
                                     [
                                       "711",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 16
                                 }
                               ],
                               "requirements": [
                                 {
                                   "name": "Level",
                                   "values": [
                                     [
                                       "62",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 62
                                 },
                                 {
                                   "name": "Str",
                                   "values": [
                                     [
                                       "180",
                                       0
                                     ]
                                   ],
                                   "displayMode": 1,
                                   "type": 63
                                 }
                               ],
                               "implicitMods": [
                                 "+12% to all Elemental Resistances"
                               ],
                               "frameType": 0,
                               "extended": {
                                 "category": "armour",
                                 "subcategories": [
                                   "chest"
                                 ]
                               },
                               "x": 6,
                               "y": 2,
                               "inventoryId": "Stash3",
                               "socketedItems": []
                             },
                             {
                               "verified": false,
                               "w": 1,
                               "h": 3,
                               "icon": "https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvV2VhcG9ucy9PbmVIYW5kV2VhcG9ucy9XYW5kcy9XYW5kNiIsInciOjEsImgiOjMsInNjYWxlIjoxfV0/30763e0fe7/Wand6.png",
                               "league": "Standard",
                               "id": "262c2f311f14bcdaa8c7e98df1baa9a13a4cfd8d7aa8a2c63e20acf8f62967da",
                               "sockets": [
                                 {
                                   "group": 0,
                                   "attr": "I",
                                   "sColour": "B"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "I",
                                   "sColour": "B"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "I",
                                   "sColour": "B"
                                 }
                               ],
                               "name": "Brimstone Bite",
                               "typeLine": "Sage Wand",
                               "baseType": "Sage Wand",
                               "rarity": "Rare",
                               "ilvl": 55,
                               "identified": true,
                               "properties": [
                                 {
                                   "name": "Wand",
                                   "values": [],
                                   "displayMode": 0
                                 },
                                 {
                                   "name": "Physical Damage",
                                   "values": [
                                     [
                                       "31-58",
                                       1
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 9
                                 },
                                 {
                                   "name": "Critical Strike Chance",
                                   "values": [
                                     [
                                       "10.00%",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 12
                                 },
                                 {
                                   "name": "Attacks per Second",
                                   "values": [
                                     [
                                       "1.40",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 13
                                 }
                               ],
                               "requirements": [
                                 {
                                   "name": "Level",
                                   "values": [
                                     [
                                       "40",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 62
                                 },
                                 {
                                   "name": "Int",
                                   "values": [
                                     [
                                       "119",
                                       0
                                     ]
                                   ],
                                   "displayMode": 1,
                                   "type": 65
                                 }
                               ],
                               "implicitMods": [
                                 "11% increased Spell Damage"
                               ],
                               "explicitMods": [
                                 "54% increased Spell Damage",
                                 "72% increased Physical Damage",
                                 "9% increased Cold Damage",
                                 "22% increased Lightning Damage",
                                 "+42 to maximum Mana"
                               ],
                               "frameType": 2,
                               "extended": {
                                 "category": "weapons",
                                 "subcategories": [
                                   "wand"
                                 ],
                                 "prefixes": 3,
                                 "suffixes": 2
                               },
                               "x": 5,
                               "y": 9,
                               "inventoryId": "Stash4",
                               "socketedItems": []
                             },
                             {
                               "verified": false,
                               "w": 2,
                               "h": 4,
                               "icon": "https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvV2VhcG9ucy9Ud29IYW5kV2VhcG9ucy9TdGF2ZXMvU3RhZmYyIiwidyI6MiwiaCI6NCwic2NhbGUiOjF9XQ/69ff746d86/Staff2.png",
                               "league": "Standard",
                               "id": "e65c6b6bf01a0c0fb6e16c5b5e3d019c7f75165c05dafbf468bb57ca9ac20b4b",
                               "sockets": [
                                 {
                                   "group": 0,
                                   "attr": "I",
                                   "sColour": "B"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "I",
                                   "sColour": "B"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "S",
                                   "sColour": "R"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "I",
                                   "sColour": "B"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "D",
                                   "sColour": "G"
                                 }
                               ],
                               "name": "",
                               "typeLine": "Woodful Staff of Incision",
                               "baseType": "Woodful Staff",
                               "rarity": "Magic",
                               "ilvl": 77,
                               "identified": true,
                               "properties": [
                                 {
                                   "name": "Staff",
                                   "values": [],
                                   "displayMode": 0
                                 },
                                 {
                                   "name": "Physical Damage",
                                   "values": [
                                     [
                                       "34-102",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 9
                                 },
                                 {
                                   "name": "Critical Strike Chance",
                                   "values": [
                                     [
                                       "10.80%",
                                       1
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 12
                                 },
                                 {
                                   "name": "Attacks per Second",
                                   "values": [
                                     [
                                       "1.15",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 13
                                 },
                                 {
                                   "name": "Weapon Range: {0} metres",
                                   "values": [
                                     [
                                       "1.3",
                                       0
                                     ]
                                   ],
                                   "displayMode": 3,
                                   "type": 14
                                 }
                               ],
                               "requirements": [
                                 {
                                   "name": "Level",
                                   "values": [
                                     [
                                       "58",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 62
                                 },
                                 {
                                   "name": "Str",
                                   "values": [
                                     [
                                       "65",
                                       0
                                     ]
                                   ],
                                   "displayMode": 1,
                                   "type": 63
                                 },
                                 {
                                   "name": "Int",
                                   "values": [
                                     [
                                       "65",
                                       0
                                     ]
                                   ],
                                   "displayMode": 1,
                                   "type": 65
                                 }
                               ],
                               "implicitMods": [
                                 "+12% Chance to Block Attack Damage while wielding a Staff"
                               ],
                               "explicitMods": [
                                 "35% increased Critical Strike Chance"
                               ],
                               "frameType": 1,
                               "extended": {
                                 "category": "weapons",
                                 "subcategories": [
                                   "twomelee",
                                   "staff"
                                 ],
                                 "suffixes": 1
                               },
                               "x": 2,
                               "y": 7,
                               "inventoryId": "Stash5",
                               "socketedItems": []
                             },
                             {
                               "verified": false,
                               "w": 2,
                               "h": 3,
                               "icon": "https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvQXJtb3Vycy9Cb2R5QXJtb3Vycy9Cb2R5U3RyMkMiLCJ3IjoyLCJoIjozLCJzY2FsZSI6MX1d/429eee131d/BodyStr2C.png",
                               "league": "Standard",
                               "id": "4195b039502ccdf6d0b2af0f32fa3724d4625e3c69c22c5332863fb93d7f4781",
                               "sockets": [
                                 {
                                   "group": 0,
                                   "attr": "S",
                                   "sColour": "R"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "S",
                                   "sColour": "R"
                                 },
                                 {
                                   "group": 1,
                                   "attr": "S",
                                   "sColour": "R"
                                 }
                               ],
                               "name": "Demon Carapace",
                               "typeLine": "Gladiator Plate",
                               "baseType": "Gladiator Plate",
                               "rarity": "Rare",
                               "ilvl": 74,
                               "identified": true,
                               "properties": [
                                 {
                                   "name": "Armour",
                                   "values": [
                                     [
                                       "1432",
                                       1
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 16
                                 }
                               ],
                               "requirements": [
                                 {
                                   "name": "Level",
                                   "values": [
                                     [
                                       "65",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 62
                                 },
                                 {
                                   "name": "Str",
                                   "values": [
                                     [
                                       "177",
                                       0
                                     ]
                                   ],
                                   "displayMode": 1,
                                   "type": 63
                                 }
                               ],
                               "explicitMods": [
                                 "94% increased Armour",
                                 "+85 to maximum Life",
                                 "+35% to Cold Resistance",
                                 "+42% to Lightning Resistance",
                                 "+21% to Chaos Resistance"
                               ],
                               "frameType": 2,
                               "extended": {
                                 "category": "armour",
                                 "subcategories": [
                                   "chest"
                                 ],
                                 "prefixes": 2,
                                 "suffixes": 3
                               },
                               "x": 0,
                               "y": 6,
                               "inventoryId": "Stash6",
                               "socketedItems": []
                             },
                             {
                               "verified": false,
                               "w": 1,
                               "h": 1,
                               "icon": "https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvQW11bGV0cy9DaXRyaW5lQW11bGV0IiwidyI6MSwiaCI6MSwic2NhbGUiOjF9XQ/95804f838b/CitrineAmulet.png",
                               "league": "Standard",
                               "id": "3bf43ec6f1a992bedf6a52c358113722f8ab29cd11b84b3f024e35e364972652",
                               "name": "Golem Scarab",
                               "typeLine": "Citrine Amulet",
                               "baseType": "Citrine Amulet",
                               "rarity": "Rare",
                               "ilvl": 73,
                               "identified": true,
                               "requirements": [
                                 {
                                   "name": "Level",
                                   "values": [
                                     [
                                       "57",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 62
                                 }
                               ],
                               "implicitMods": [
                                 "+18 to Strength and Dexterity"
                               ],
                               "explicitMods": [
                                 "+9 to all Attributes",
                                 "19% increased Spell Damage",
                                 "22% increased Mana Regeneration Rate",
                                 "+44% to Fire Resistance"
                               ],
                               "frameType": 2,
                               "extended": {
                                 "category": "accessories",
                                 "subcategories": [
                                   "amulet"
                                 ],
                                 "prefixes": 1,
                                 "suffixes": 3
                               },
                               "x": 9,
                               "y": 7,
                               "inventoryId": "Stash7"
                             },
                             {
                               "verified": false,
                               "w": 2,
                               "h": 4,
                               "icon": "https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvV2VhcG9ucy9Ud29IYW5kV2VhcG9ucy9TdGF2ZXMvU3RhZmYyIiwidyI6MiwiaCI6NCwic2NhbGUiOjF9XQ/69ff746d86/Staff2.png",
                               "league": "Standard",
                               "id": "226ed6cf2ffb80d0b849189abccd9976f72d785aa48cbbb2320fb773623fb3ec",
                               "sockets": [
                                 {
                                   "group": 0,
                                   "attr": "S",
                                   "sColour": "R"
                                 },
                                 {
                                   "group": 1,
                                   "attr": "I",
                                   "sColour": "B"
                                 },
                                 {
                                   "group": 2,
                                   "attr": "I",
                                   "sColour": "B"
                                 }
                               ],
                               "name": "Brimstone Branch",
                               "typeLine": "Primordial Staff",
                               "baseType": "Primordial Staff",
                               "rarity": "Rare",
                               "ilvl": 59,
                               "identified": true,
                               "properties": [
                                 {
                                   "name": "Staff",
                                   "values": [],
                                   "displayMode": 0
                                 },
                                 {
                                   "name": "Physical Damage",
                                   "values": [
                                     [
                                       "55-165",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 9
                                 },
                                 {
                                   "name": "Critical Strike Chance",
                                   "values": [
                                     [
                                       "8.00%",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 12
                                 },
                                 {
                                   "name": "Attacks per Second",
                                   "values": [
                                     [
                                       "1.15",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 13
                                 },
                                 {
                                   "name": "Weapon Range: {0} metres",
                                   "values": [
                                     [
                                       "1.3",
                                       0
                                     ]
                                   ],
                                   "displayMode": 3,
                                   "type": 14
                                 }
                               ],
                               "requirements": [
                                 {
                                   "name": "Level",
                                   "values": [
                                     [
                                       "58",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 62
                                 },
                                 {
                                   "name": "Str",
                                   "values": [
                                     [
                                       "99",
                                       0
                                     ]
                                   ],
                                   "displayMode": 1,
                                   "type": 63
                                 },
                                 {
                                   "name": "Int",
                                   "values": [
                                     [
                                       "99",
                                       0
                                     ]
                                   ],
                                   "displayMode": 1,
                                   "type": 65
                                 }
                               ],
                               "implicitMods": [
                                 "+12% Chance to Block Attack Damage while wielding a Staff"
                               ],
                               "explicitMods": [
                                 "+26 to Strength",
                                 "115% increased Spell Damage",
                                 "22% increased Lightning Damage",
                                 "Adds 2 to 4 Cold Damage to Spells",
                                 "+30% to Global Critical Strike Multiplier",
                                 "+14 to maximum Mana"
                               ],
                               "frameType": 2,
                               "extended": {
                                 "category": "weapons",
                                 "subcategories": [
                                   "twomelee",
                                   "staff"
                                 ],
                                 "prefixes": 3,
                                 "suffixes": 3
                               },
                               "x": 8,
                               "y": 8,
                               "inventoryId": "Stash8",
                               "socketedItems": []
                             },
                             {
                               "verified": false,
                               "w": 2,
                               "h": 3,
                               "icon": "https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvUXVpdmVycy9RdWl2ZXJQZW5ldHJhdGluZyIsInciOjIsImgiOjMsInNjYWxlIjoxfV0/7db7561558/QuiverPenetrating.png",
                               "league": "Standard",
                               "id": "f81cf05e858b444d2b46076391239c6de666b1b89260acf086471eb319258f63",
                               "name": "Wrath Spire",
                               "typeLine": "Penetrating Arrow Quiver",
                               "baseType": "Penetrating Arrow Quiver",
                               "rarity": "Rare",
                               "ilvl": 76,
                               "identified": true,
                               "requirements": [
                                 {
                                   "name": "Level",
                                   "values": [
                                     [
                                       "43",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 62
                                 }
                               ],
                               "explicitMods": [
                                 "Adds 1 to 23 Lightning Damage to Attacks",
                                 "+15% to Global Critical Strike Multiplier",
                                 "+81 to maximum Life",
                                 "21% increased Projectile Speed",
                                 "10% increased Elemental Damage with Attack Skills"
                               ],
                               "frameType": 2,
                               "extended": {
                                 "category": "armour",
                                 "subcategories": [
                                   "quiver"
                                 ],
                                 "prefixes": 3,
                                 "suffixes": 2
                               },
                               "x": 2,
                               "y": 0,
                               "inventoryId": "Stash9"
                             },
                             {
                               "verified": false,
                               "w": 2,
                               "h": 3,
                               "icon": "https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvQXJtb3Vycy9Cb2R5QXJtb3Vycy9Cb2R5U3RyRGV4MUIiLCJ3IjoyLCJoIjozLCJzY2FsZSI6MX1d/d9b2da2bce/BodyStrDex1B.png",
                               "league": "Standard",
                               "id": "e707309b3a7e6ea53c3a95b1b2ecac4bb26b13f988fb23607f688bfd9dae77fa",
                               "sockets": [
                                 {
                                   "group": 0,
                                   "attr": "S",
                                   "sColour": "R"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "I",
                                   "sColour": "B"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "D",
                                   "sColour": "G"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "S",
                                   "sColour": "R"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "S",
                                   "sColour": "R"
                                 }
                               ],
                               "name": "",
                               "typeLine": "Dragonscale Doublet",
                               "baseType": "Dragonscale Doublet",
                               "rarity": "Normal",
                               "ilvl": 75,
                               "identified": true,
                               "properties": [
                                 {
                                   "name": "Armour",
                                   "values": [
                                     [
                                       "313",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 16
                                 },
                                 {
                                   "name": "Evasion Rating",
                                   "values": [
                                     [
                                       "313",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 17
                                 }
                               ],
                               "requirements": [
                                 {
                                   "name": "Level",
                                   "values": [
                                     [
                                       "57",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 62
                                 },
                                 {
                                   "name": "Str",
                                   "values": [
                                     [
                                       "83",
                                       0
                                     ]
                                   ],
                                   "displayMode": 1,
                                   "type": 63
                                 },
                                 {
                                   "name": "Dex",
                                   "values": [
                                     [
                                       "83",
                                       0
                                     ]
                                   ],
                                   "displayMode": 1,
                                   "type": 64
                                 }
                               ],
                               "frameType": 0,
                               "extended": {
                                 "category": "armour",
                                 "subcategories": [
                                   "chest"
                                 ]
                               },
                               "x": 10,
                               "y": 3,
                               "inventoryId": "Stash10",
                               "socketedItems": []
                             },
                             {
                               "verified": false,
                               "w": 1,
                               "h": 4,
                               "icon": "https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvV2VhcG9ucy9PbmVIYW5kV2VhcG9ucy9SYXBpZXJzL1JhcGllcjYiLCJ3IjoxLCJoIjo0LCJzY2FsZSI6MX1d/f9bc0a5aa1/Rapier6.png",
                               "league": "Standard",
                               "id": "7bd9a450fc9b94572aaaef92ef62715a7944d251a78dda55e64aef1bb5fb71f2",
                               "sockets": [
                                 {
                                   "group": 0,
                                   "attr": "D",
                                   "sColour": "G"
                                 },
                                 {
                                   "group": 1,
                                   "attr": "D",
                                   "sColour": "G"
                                 },
                                 {
                                   "group": 1,
                                   "attr": "I",
                                   "sColour": "B"
                                 }
                               ],
                               "name": "Woe Needle",
                               "typeLine": "Vaal Rapier",
                               "baseType": "Vaal Rapier",
                               "rarity": "Rare",
                               "ilvl": 69,
                               "identified": true,
                               "properties": [
                                 {
                                   "name": "One Handed Sword",
                                   "values": [],
                                   "displayMode": 0
                                 },
                                 {
                                   "name": "Quality",
                                   "values": [
                                     [
                                       "+5%",
                                       1
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 6
                                 },
                                 {
                                   "name": "Physical Damage",
                                   "values": [
                                     [
                                       "52-206",
                                       1
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 9
                                 },
                                 {
                                   "name": "Elemental Damage",
                                   "values": [
                                     [
                                       "1-4",
                                       4
                                     ],
                                     [
                                       "32-54",
                                       5
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 10
                                 },
                                 {
                                   "name": "Critical Strike Chance",
                                   "values": [
                                     [
                                       "6.50%",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 12
                                 },
                                 {
                                   "name": "Attacks per Second",
                                   "values": [
                                     [
                                       "1.38",
                                       1
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 13
                                 },
                                 {
                                   "name": "Weapon Range: {0} metres",
                                   "values": [
                                     [
                                       "1.4",
                                       0
                                     ]
                                   ],
                                   "displayMode": 3,
                                   "type": 14
                                 }
                               ],
                               "requirements": [
                                 {
                                   "name": "Level",
                                   "values": [
                                     [
                                       "66",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 62
                                 },
                                 {
                                   "name": "Dex",
                                   "values": [
                                     [
                                       "212",
                                       0
                                     ]
                                   ],
                                   "displayMode": 1,
                                   "type": 64
                                 }
                               ],
                               "implicitMods": [
                                 "+20% to Global Critical Strike Multiplier"
                               ],
                               "explicitMods": [
                                 "125% increased Physical Damage",
                                 "Adds 1 to 4 Fire Damage",
                                 "Adds 32 to 54 Cold Damage",
                                 "6% increased Attack Speed",
                                 "27% increased Stun Duration on Enemies"
                               ],
                               "frameType": 2,
                               "extended": {
                                 "category": "weapons",
                                 "subcategories": [
                                   "onemelee",
                                   "rapier",
                                   "onesword"
                                 ],
                                 "prefixes": 3,
                                 "suffixes": 2
                               },
                               "x": 8,
                               "y": 4,
                               "inventoryId": "Stash11",
                               "socketedItems": []
                             },
                             {
                               "verified": false,
                               "w": 1,
                               "h": 1,
                               "icon": "https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvQW11bGV0cy9BbXVsZXQ3IiwidyI6MSwiaCI6MSwic2NhbGUiOjF9XQ/58942b1ab3/Amulet7.png",
                               "league": "Standard",
                               "id": "cb19d0610deca12dfb00c7f66b85ef2809f7ac8eea46d11e60a38afb0d2bb100",
                               "name": "Horror Idol",
                               "typeLine": "Onyx Amulet",
                               "baseType": "Onyx Amulet",
                               "rarity": "Rare",
                               "ilvl": 76,
                               "identified": true,
                               "requirements": [
                                 {
                                   "name": "Level",
                                   "values": [
                                     [
                                       "60",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 62
                                 }
                               ],
                               "implicitMods": [
                                 "+13 to all Attributes"
                               ],
                               "explicitMods": [
                                 "Adds 4 to 9 Physical Damage to Attacks",
                                 "Adds 20 to 43 Fire Damage to Attacks",
                                 "Adds 1 to 2 Cold Damage to Attacks",
                                 "20% increased Rarity of Items found",
                                 "+32% to Fire Resistance"
                               ],
                               "frameType": 2,
                               "extended": {
                                 "category": "accessories",
                                 "subcategories": [
                                   "amulet"
                                 ],
                                 "prefixes": 3,
                                 "suffixes": 2
                               },
                               "x": 3,
                               "y": 11,
                               "inventoryId": "Stash12"
                             },
                             {
                               "verified": false,
                               "w": 1,
                               "h": 3,
                               "icon": "https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvV2VhcG9ucy9PbmVIYW5kV2VhcG9ucy9XYW5kcy9XYW5kMiIsInciOjEsImgiOjMsInNjYWxlIjoxfV0/896948eee2/Wand2.png",
                               "league": "Standard",
                               "id": "4fe53225b529f333539fab8680b2485c35ba4c93fd177625e0061bf544879449",
                               "sockets": [
                                 {
                                   "group": 0,
                                   "attr": "I",
                                   "sColour": "B"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "I",
                                   "sColour": "B"
                                 }
                               ],
                               "name": "Dragon Gnarl",
                               "typeLine": "Demon's Horn",
                               "baseType": "Demon's Horn",
                               "rarity": "Rare",
                               "ilvl": 76,
                               "identified": true,
                               "properties": [
                                 {
                                   "name": "Wand",
                                   "values": [],
                                   "displayMode": 0
                                 },
                                 {
                                   "name": "Physical Damage",
                                   "values": [
                                     [
                                       "31-57",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 9
                                 },
                                 {
                                   "name": "Critical Strike Chance",
                                   "values": [
                                     [
                                       "12.92%",
                                       1
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 12
                                 },
                                 {
                                   "name": "Attacks per Second",
                                   "values": [
                                     [
                                       "1.40",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 13
                                 }
                               ],
                               "requirements": [
                                 {
                                   "name": "Level",
                                   "values": [
                                     [
                                       "58",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 62
                                 },
                                 {
                                   "name": "Int",
                                   "values": [
                                     [
                                       "179",
                                       0
                                     ]
                                   ],
                                   "displayMode": 1,
                                   "type": 65
                                 }
                               ],
                               "implicitMods": [
                                 "15% increased Spell Damage"
                               ],
                               "explicitMods": [
                                 "50% increased Spell Damage",
                                 "Adds 4 to 48 Lightning Damage to Spells",
                                 "36% increased Critical Strike Chance",
                                 "+11% to Global Critical Strike Multiplier"
                               ],
                               "frameType": 2,
                               "extended": {
                                 "category": "weapons",
                                 "subcategories": [
                                   "wand"
                                 ],
                                 "prefixes": 2,
                                 "suffixes": 2
                               },
                               "x": 0,
                               "y": 3,
                               "inventoryId": "Stash13",
                               "socketedItems": []
                             },
                             {
                               "verified": false,
                               "w": 2,
                               "h": 4,
                               "icon": "https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvV2VhcG9ucy9Ud29IYW5kV2VhcG9ucy9Cb3dzL0JvdzgiLCJ3IjoyLCJoIjo0LCJzY2FsZSI6MX1d/8d079c60ed/Bow8.png",
                               "league": "Standard",
                               "id": "7ca779f71d855b3429ec5410e052e85d7283fdf154af6e580c434a7a4f8d62e3",
                               "sockets": [
                                 {
                                   "group": 0,
                                   "attr": "D",
                                   "sColour": "G"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "D",
                                   "sColour": "G"
                                 },
                                 {
                                   "group": 0,
                                   "attr": "D",
                                   "sColour": "G"
                                 }
                               ],
                               "name": "Entropy Rain",
                               "typeLine": "Harbinger Bow",
                               "baseType": "Harbinger Bow",
                               "rarity": "Rare",
                               "ilvl": 77,
                               "identified": true,
                               "properties": [
                                 {
                                   "name": "Bow",
                                   "values": [],
                                   "displayMode": 0
                                 },
                                 {
                                   "name": "Physical Damage",
                                   "values": [
                                     [
                                       "71-174",
                                       1
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 9
                                 },
                                 {
                                   "name": "Critical Strike Chance",
                                   "values": [
                                     [
                                       "6.50%",
                                       1
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 12
                                 },
                                 {
                                   "name": "Attacks per Second",
                                   "values": [
                                     [
                                       "1.20",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 13
                                 }
                               ],
                               "requirements": [
                                 {
                                   "name": "Level",
                                   "values": [
                                     [
                                       "68",
                                       0
                                     ]
                                   ],
                                   "displayMode": 0,
                                   "type": 62
                                 },
                                 {
                                   "name": "Dex",
                                   "values": [
                                     [
                                       "212",
                                       0
                                     ]
                                   ],
                                   "displayMode": 1,
                                   "type": 64
                                 }
                               ],
                               "implicitMods": [
                                 "30% increased Critical Strike Chance"
                               ],
                               "explicitMods": [
                                 "+2 to Level of Socketed Bow Gems",
                                 "Adds 21 to 41 Physical Damage",
                                 "Grants 4 Life per Enemy Hit",
                                 "+35 to Accuracy Rating",
                                 "10% increased Light Radius"
                               ],
                               "frameType": 2,
                               "extended": {
                                 "category": "weapons",
                                 "subcategories": [
                                   "bow"
                                 ],
                                 "prefixes": 2,
                                 "suffixes": 2
                               },
                               "x": 8,
                               "y": 0,
                               "inventoryId": "Stash14",
                               "socketedItems": []
                             }
                           ],
                           "fakenewField": "Yeppers",
                           "secondNewFakeField": "Thats True"
                         }
                """; // String json
        return json;
    }
}
