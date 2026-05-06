import {useQuery} from "@tanstack/react-query";
// import type {UTCTimestamp} from "lightweight-charts";

// interface Stash {
//     // This is the generic note attached to the stash tab itself. If the item doesn't have its own individual note,
//     // then price falls back to this. This can sometimes be in the format of "~price 2/35 chaos"
//     stashNote?: string;
//     items?: StashItem[];
// }
//
// interface StashItem {
//     timeStamp: UTCTimestamp;
//     // This is the note optionally attached to an item. This can sometimes be in the format of "~price 2/35 chaos"
//     itemNote?: string;
// }
//
// interface ChartData {
//     timeStamp: UTCTimestamp;
//     value: number | undefined;
// }

// const fetchChartData = async (name: string, league: string): Promise<ChartData[]> => {
//     const res = await fetch(
//         `http://localhost:8080/items/getItemsByCustomParameters?name=${name}&league=${league}`
//     );
//     const json = await res.json();
//
//     return json;
        // // Get the items from the stash
        // .flatMap((stash: Stash) => {
        //         return stash.items?.map((item: StashItem): ChartData => ({
        //             timeStamp: item.timeStamp as UTCTimestamp,
        //             value: parsePrice(item.itemNote ?? stash.stashNote),
        //         })) ?? [];
        //     }
        // )
        //
        // .filter((chartElement: ChartData) => {
        //     return chartElement !== null
        //         && chartElement ! != undefined
        //         && chartElement.value !== 0;
        // })
        //
        // .sort((a: ChartData, b: ChartData) => {
        //     return a.timeStamp - b.timeStamp;
        // });
// };
//
export function useChartData(name: string, league: string) {
    return useQuery({
        queryKey: ["items", name, league],
        queryFn: () => fetchChartData(name, league),
    });
}

// TODO: DELETE THIS AND SWAP BACK TO ORIGINAL FETCHCHARTDATA
const fetchChartData = async (name: string, league: string) => {
    const res = await fetch(
        `http://localhost:8080/items/getItemsByCustomParameters?name=${name}&league=${league}`
    );
    return await res.json();
}

// TODO: Implement parsePrice
// const parsePrice = (price: string | undefined) => {
//
//     // If the item note doesn't begin with ~price or ~b/o, then it's not a true price
//     if (!(price?.startsWith("~price ") || price?.startsWith("~b/o"))) {
//         return undefined;
//     }
//
//     // If price isn't undefined, match any sequence of numbers. if this isn't null, match returns a RegEx array.
//     // Since there should only be one sequence of numbers, we just grab index 0. Finally, convert this to a Number
//     // If undefined, number is 0
//     const noteRawPrice = Number(price?.match(/\d+/)?.at(0) ?? undefined);
//
//     if (!noteRawPrice) {
//         return noteRawPrice;
//     }
//
//     const notePricedInChaos = price?.endsWith(" chaos");
//     const notePricedInDivine = price?.match(" divine");
//     if (notePricedInChaos) {
//         return noteRawPrice;
//     }
//     // TODO: Update this to grab the actual Div price instead of hardcoding the div value at 300 chaos
//     else if (notePricedInDivine) {
//         return noteRawPrice * 300;
//     }
//     else {
//         return undefined;
//     }
// };