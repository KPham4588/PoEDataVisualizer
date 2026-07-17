import {useQuery} from "@tanstack/react-query";
import type {UTCTimestamp} from "lightweight-charts";

interface ChartData {
    value: number
    time: UTCTimestamp;
}

export function useChartData(name: string, league: string) {
    return useQuery({
        queryKey: ["items", name, league],
        queryFn: () => fetchChartData(name, league),
    });
}

// const getExampleJSON = () => {
//     const result = `[{"accountName":"Soyosup#2041","dbId":8549,"id":"67c6219d96f9a1acfb59c1c951a014bd348c8007f27580d67b09e50388a2a8fc","items":[{"abyssJewel":false,"additionalProperties":[],"artFilename":"","baseType":"Heavy Belt","cisRaceReward":false,"colour":"","corrupted":false,"cosmeticMods":[],"craftedMods":[],"dbId":150020,"delve":false,"descrText":"","duplicated":false,"elder":false,"enchantMods":[],"explicitMods":["+56 to Dexterity","+17% to Fire Resistance","+15% to Cold Resistance","Magic Utility Flasks cannot be Used","Leftmost 4 Magic Utility Flasks constantly apply their Flask Effects to you","Magic Utility Flask Effects cannot be removed"],"extended":null,"flavourText":["Rivers of power course through your veins."],"flavourTextNote":"","foilVariation":-1,"foreseeing":false,"forum_note":"","fractured":false,"fracturedMods":[],"frameType":null,"h":1,"hybrid":null,"icon":"https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvQmVsdHMvSW5qZWN0b3JCZWx0IiwidyI6MiwiaCI6MSwic2NhbGUiOjF9XQ/21ec0269de/InjectorBelt.png","id":"f8d6461aa90429ced1aedc58e8498e637f60d5e2e724ac7272555e82a2056b1b","identified":true,"ilvl":85,"implicitMods":["+40 to Strength"],"incubatedItem":null,"influences":null,"inventoryId":"Stash31","isRelic":false,"itemLevel":-1,"league":"Keepers","lockedToAccount":false,"lockedToCharacter":false,"logbookMods":[],"maxStackSize":-1,"memoryItem":false,"name":"Mageblood","nextLevelRequirements":[],"notableProperties":[],"note":"","properties":[{"dbId":409613,"displayMode":"Name should be followed by values","hybridId":0,"icon":null,"itemId":150020,"name":"Quality (Attribute Modifiers)","progress":0,"propertyType":"Properties","suffix":null,"type":6,"values":[{"dbId":398274,"itemPropertyId":409613,"value":"+20%","valueType":1}]}],"prophecyText":"","publicStashChangeId":8549,"rarity":"Unique","relic":false,"replica":false,"requirements":[{"dbId":409614,"displayMode":"Name should be followed by values","hybridId":0,"icon":null,"itemId":150020,"name":"Level","progress":0,"propertyType":"Requirements","suffix":null,"type":62,"values":[{"dbId":398275,"itemPropertyId":409614,"value":"44","valueType":0}]}],"rewards":[],"ruthless":false,"scourgeMods":[],"scourged":null,"seaRaceReward":false,"searing":false,"secDescrText":"","shaper":false,"socket":-1,"sockets":[],"split":false,"stackSize":-1,"stackSizeText":"","support":false,"synthesised":false,"talismanTier":-1,"tangled":false,"thRaceReward":false,"typeLine":"Heavy Belt","ultimatumMods":[],"unmodifiable":false,"unmodifiableExceptChaos":false,"utilityMods":[],"veiled":false,"veiledMods":[],"verified":false,"w":2,"x":124,"y":0}],"league":"Keepers","public":true,"resultId":189,"stash":"unique","stashType":"UniqueStash"},{"accountName":"Shikinyan#4178","dbId":10449,"id":"5aba4b422f1507334b3b08e31708d0800a63b8e4b6cf1eea02d5fdf7044017a4","items":[{"abyssJewel":false,"additionalProperties":[],"artFilename":"","baseType":"Heavy Belt","cisRaceReward":false,"colour":"","corrupted":false,"cosmeticMods":[],"craftedMods":[],"dbId":184340,"delve":false,"descrText":"","duplicated":false,"elder":false,"enchantMods":[],"explicitMods":["+42 to Dexterity","+18% to Fire Resistance","+23% to Cold Resistance","Magic Utility Flasks cannot be Used","Leftmost 4 Magic Utility Flasks constantly apply their Flask Effects to you","Magic Utility Flask Effects cannot be removed"],"extended":null,"flavourText":["Rivers of power course through your veins."],"flavourTextNote":"","foilVariation":-1,"foreseeing":false,"forum_note":"","fractured":false,"fracturedMods":[],"frameType":null,"h":1,"hybrid":null,"icon":"https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvQmVsdHMvSW5qZWN0b3JCZWx0IiwidyI6MiwiaCI6MSwic2NhbGUiOjF9XQ/21ec0269de/InjectorBelt.png","id":"c992ff4529526e2cdc19de2adbc59633144302a825d53e756a8725219e5fffc2","identified":true,"ilvl":86,"implicitMods":["+34 to Strength"],"incubatedItem":null,"influences":null,"inventoryId":"Stash3","isRelic":false,"itemLevel":-1,"league":"Keepers","lockedToAccount":false,"lockedToCharacter":false,"logbookMods":[],"maxStackSize":-1,"memoryItem":false,"name":"Mageblood","nextLevelRequirements":[],"notableProperties":[],"note":"~b/o 245 divine","properties":[],"prophecyText":"","publicStashChangeId":10449,"rarity":"Unique","relic":false,"replica":false,"requirements":[{"dbId":497868,"displayMode":"Name should be followed by values","hybridId":0,"icon":null,"itemId":184340,"name":"Level","progress":0,"propertyType":"Requirements","suffix":null,"type":62,"values":[{"dbId":483435,"itemPropertyId":497868,"value":"44","valueType":0}]}],"rewards":[],"ruthless":false,"scourgeMods":[],"scourged":null,"seaRaceReward":false,"searing":false,"secDescrText":"","shaper":false,"socket":-1,"sockets":[],"split":false,"stackSize":-1,"stackSizeText":"","support":false,"synthesised":false,"talismanTier":-1,"tangled":false,"thRaceReward":false,"typeLine":"Heavy Belt","ultimatumMods":[],"unmodifiable":false,"unmodifiableExceptChaos":false,"utilityMods":[],"veiled":false,"veiledMods":[],"verified":false,"w":2,"x":4,"y":4}],"league":"Keepers","public":true,"resultId":196,"stash":"22","stashType":"TradeStash"},{"accountName":"Larkee#5985","dbId":11095,"id":"96a70c95437694f997b7159a9cb6c23e53dd3b04f80a007f3a0ff71e9f64802f","items":[{"abyssJewel":false,"additionalProperties":[],"artFilename":"","baseType":"Heavy Belt","cisRaceReward":false,"colour":"","corrupted":false,"cosmeticMods":[],"craftedMods":[],"dbId":196556,"delve":false,"descrText":"","duplicated":false,"elder":false,"enchantMods":[],"explicitMods":["+39 to Dexterity","+16% to Fire Resistance","+15% to Cold Resistance","Magic Utility Flasks cannot be Used","Leftmost 4 Magic Utility Flasks constantly apply their Flask Effects to you","Magic Utility Flask Effects cannot be removed"],"extended":null,"flavourText":["Rivers of power course through your veins."],"flavourTextNote":"","foilVariation":-1,"foreseeing":false,"forum_note":"","fractured":false,"fracturedMods":[],"frameType":null,"h":1,"hybrid":null,"icon":"https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvQmVsdHMvSW5qZWN0b3JCZWx0IiwidyI6MiwiaCI6MSwic2NhbGUiOjF9XQ/21ec0269de/InjectorBelt.png","id":"8e5e62bf9087c04b46c85ae1f3d26a2a0b4460bbeccdda7913ff1a9235bde590","identified":true,"ilvl":80,"implicitMods":["+25 to Strength"],"incubatedItem":null,"influences":null,"inventoryId":"Stash1","isRelic":false,"itemLevel":-1,"league":"Keepers","lockedToAccount":false,"lockedToCharacter":false,"logbookMods":[],"maxStackSize":-1,"memoryItem":false,"name":"Mageblood","nextLevelRequirements":[],"notableProperties":[],"note":"","properties":[],"prophecyText":"","publicStashChangeId":11095,"rarity":"Unique","relic":false,"replica":false,"requirements":[{"dbId":533145,"displayMode":"Name should be followed by values","hybridId":0,"icon":null,"itemId":196556,"name":"Level","progress":0,"propertyType":"Requirements","suffix":null,"type":62,"values":[{"dbId":517752,"itemPropertyId":533145,"value":"44","valueType":0}]}],"rewards":[],"ruthless":false,"scourgeMods":[],"scourged":null,"seaRaceReward":false,"searing":false,"secDescrText":"","shaper":false,"socket":-1,"sockets":[],"split":false,"stackSize":-1,"stackSizeText":"","support":false,"synthesised":false,"talismanTier":-1,"tangled":false,"thRaceReward":false,"typeLine":"Heavy Belt","ultimatumMods":[],"unmodifiable":false,"unmodifiableExceptChaos":false,"utilityMods":[],"veiled":false,"veiledMods":[],"verified":false,"w":2,"x":10,"y":0}],"league":"Keepers","public":true,"resultId":198,"stash":"Sell","stashType":"PremiumStash"},{"accountName":"Soyosup#2041","dbId":16969,"id":"67c6219d96f9a1acfb59c1c951a014bd348c8007f27580d67b09e50388a2a8fc","items":[{"abyssJewel":false,"additionalProperties":[],"artFilename":"","baseType":"Heavy Belt","cisRaceReward":false,"colour":"","corrupted":false,"cosmeticMods":[],"craftedMods":[],"dbId":298839,"delve":false,"descrText":"","duplicated":false,"elder":false,"enchantMods":[],"explicitMods":["+56 to Dexterity","+17% to Fire Resistance","+15% to Cold Resistance","Magic Utility Flasks cannot be Used","Leftmost 4 Magic Utility Flasks constantly apply their Flask Effects to you","Magic Utility Flask Effects cannot be removed"],"extended":null,"flavourText":["Rivers of power course through your veins."],"flavourTextNote":"","foilVariation":-1,"foreseeing":false,"forum_note":"","fractured":false,"fracturedMods":[],"frameType":null,"h":1,"hybrid":null,"icon":"https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvQmVsdHMvSW5qZWN0b3JCZWx0IiwidyI6MiwiaCI6MSwic2NhbGUiOjF9XQ/21ec0269de/InjectorBelt.png","id":"f8d6461aa90429ced1aedc58e8498e637f60d5e2e724ac7272555e82a2056b1b","identified":true,"ilvl":85,"implicitMods":["+40 to Strength"],"incubatedItem":null,"influences":null,"inventoryId":"Stash31","isRelic":false,"itemLevel":-1,"league":"Keepers","lockedToAccount":false,"lockedToCharacter":false,"logbookMods":[],"maxStackSize":-1,"memoryItem":false,"name":"Mageblood","nextLevelRequirements":[],"notableProperties":[],"note":"","properties":[{"dbId":808505,"displayMode":"Name should be followed by values","hybridId":0,"icon":null,"itemId":298839,"name":"Quality (Attribute Modifiers)","progress":0,"propertyType":"Properties","suffix":null,"type":6,"values":[{"dbId":786461,"itemPropertyId":808505,"value":"+20%","valueType":1}]}],"prophecyText":"","publicStashChangeId":16969,"rarity":"Unique","relic":false,"replica":false,"requirements":[{"dbId":808506,"displayMode":"Name should be followed by values","hybridId":0,"icon":null,"itemId":298839,"name":"Level","progress":0,"propertyType":"Requirements","suffix":null,"type":62,"values":[{"dbId":786462,"itemPropertyId":808506,"value":"44","valueType":0}]}],"rewards":[],"ruthless":false,"scourgeMods":[],"scourged":null,"seaRaceReward":false,"searing":false,"secDescrText":"","shaper":false,"socket":-1,"sockets":[],"split":false,"stackSize":-1,"stackSizeText":"","support":false,"synthesised":false,"talismanTier":-1,"tangled":false,"thRaceReward":false,"typeLine":"Heavy Belt","ultimatumMods":[],"unmodifiable":false,"unmodifiableExceptChaos":false,"utilityMods":[],"veiled":false,"veiledMods":[],"verified":false,"w":2,"x":124,"y":0}],"league":"Keepers","public":true,"resultId":217,"stash":"unique","stashType":"UniqueStash"},{"accountName":"Larkee#5985","dbId":19465,"id":"96a70c95437694f997b7159a9cb6c23e53dd3b04f80a007f3a0ff71e9f64802f","items":[{"abyssJewel":false,"additionalProperties":[],"artFilename":"","baseType":"Heavy Belt","cisRaceReward":false,"colour":"","corrupted":false,"cosmeticMods":[],"craftedMods":[],"dbId":344138,"delve":false,"descrText":"","duplicated":false,"elder":false,"enchantMods":[],"explicitMods":["+39 to Dexterity","+16% to Fire Resistance","+15% to Cold Resistance","Magic Utility Flasks cannot be Used","Leftmost 4 Magic Utility Flasks constantly apply their Flask Effects to you","Magic Utility Flask Effects cannot be removed"],"extended":null,"flavourText":["Rivers of power course through your veins."],"flavourTextNote":"","foilVariation":-1,"foreseeing":false,"forum_note":"","fractured":false,"fracturedMods":[],"frameType":null,"h":1,"hybrid":null,"icon":"https://web.poecdn.com/gen/image/WzI1LDE0LHsiZiI6IjJESXRlbXMvQmVsdHMvSW5qZWN0b3JCZWx0IiwidyI6MiwiaCI6MSwic2NhbGUiOjF9XQ/21ec0269de/InjectorBelt.png","id":"8e5e62bf9087c04b46c85ae1f3d26a2a0b4460bbeccdda7913ff1a9235bde590","identified":true,"ilvl":80,"implicitMods":["+25 to Strength"],"incubatedItem":null,"influences":null,"inventoryId":"Stash1","isRelic":false,"itemLevel":-1,"league":"Keepers","lockedToAccount":false,"lockedToCharacter":false,"logbookMods":[],"maxStackSize":-1,"memoryItem":false,"name":"Mageblood","nextLevelRequirements":[],"notableProperties":[],"note":"","properties":[],"prophecyText":"","publicStashChangeId":19465,"rarity":"Unique","relic":false,"replica":false,"requirements":[{"dbId":929039,"displayMode":"Name should be followed by values","hybridId":0,"icon":null,"itemId":344138,"name":"Level","progress":0,"propertyType":"Requirements","suffix":null,"type":62,"values":[{"dbId":903110,"itemPropertyId":929039,"value":"44","valueType":0}]}],"rewards":[],"ruthless":false,"scourgeMods":[],"scourged":null,"seaRaceReward":false,"searing":false,"secDescrText":"","shaper":false,"socket":-1,"sockets":[],"split":false,"stackSize":-1,"stackSizeText":"","support":false,"synthesised":false,"talismanTier":-1,"tangled":false,"thRaceReward":false,"typeLine":"Heavy Belt","ultimatumMods":[],"unmodifiable":false,"unmodifiableExceptChaos":false,"utilityMods":[],"veiled":false,"veiledMods":[],"verified":false,"w":2,"x":10,"y":0}],"league":"Keepers","public":true,"resultId":226,"stash":"Sell","stashType":"PremiumStash"}]`;
//     return JSON.parse(result);
// }

const fetchChartData = async (name: string, league: string): Promise<ChartData[]> => {
    //b Fetch data
    console.log("Checkpoint 1 - Inside fetchChartData before doing anything");
    const res = await fetch(
        `http://localhost:8080/items/getItemsAsChartDataByCustomParametersAsCostInChaos?name=${name}&league=${league}`);
    console.log("res = ", res);

    console.log("Checkpoint 2 - turning response into json as \"listOfItems\"");
    const listOfItems = await res.json();
    console.log("res as json = ", listOfItems);
    // console.log("res as json to string = ", listOfItems.stringify());

    // console.log("Checkpoint 3 - turning \"listOfItems\" into ChartData format as \"listofItemsAsChartData\"");
    // const listofItemsAsChartData: ChartData[] = listOfItems;
    // console.log("listofItemsAsChartData = ", listofItemsAsChartData);
    // console.log("listofItemsAsChartData to string = ", listOfItems.stringify());


    console.log("Checkpoint 4 - about to go through listOfItems");
        const result: ChartData[] = [];

        for (const item of listOfItems) {
            console.log("Checkpoint 5 - Looking at \"item\" from \"listOfItems\"")
            console.log("item is: ");
            console.log(item);
            console.log("item as string is: " + JSON.stringify(item));

            console.log("item value is: " + item.value);
            console.log("item value as string is: " + JSON.stringify(item.value));

            console.log("item timestamp is: " + item.timeStamp);
            console.log("item timestamp as string is: " + JSON.stringify(item.timeStamp));

            console.log("item chartData is: " + item.ChartData);
            console.log("item chartData as string is: " + JSON.stringify(item.ChartData));

            console.log("item as string is: " + JSON.stringify(item));



            result.push({
                value: item.value,
                time: item.timeStamp as UTCTimestamp,
            });
        }

        console.log("Checkpoint 6 - about to return \"result\"");
        console.log(result);

        return result;
        // return resultAsChartData;

//     if (name !== null && league !== null) {;}


    //b We need to do this if we're parsing the chartdata from a full PublicStashChangeDTO-->ItemDTO-->...
    //b -- if we return chartdata format in from back-end side instead, this isn't needed
    // const listOfItems: ChartData[] = [];
    // for (const item of apiResult) {
    //     listOfItems.push({
    //         value: parseInt(item.accountName.slice(-4)),
    //         timeStamp: item.dbId as UTCTimestamp,
    //     });
    // }
}