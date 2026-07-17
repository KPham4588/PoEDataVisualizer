import '../css/Attributions.css';
import {createFileRoute} from "@tanstack/react-router";
import {useChartData} from "../hooks/fetchChartInfo.ts";

function Attributions() {
    // const { data, isLoading, isError } = useChartData("Mageblood", "Keepers");
    const { data, isLoading } = useChartData("Tabula Rasa", "Keepers");
    const placeHolder = isLoading ? "Loading..." : "Done Loading";
    // if (isLoading) return <p>Loading...</p>;
    // if (isError) return <p>Error loading data.</p>;
    console.log("before data foreach in attributions")
    console.log(data)
    console.log("after logging initial \"data\" object")

    data?.forEach((item) => {
        console.log("Im in the for each loop")
        console.log("item = " + item)
        // children[children.length - 1] = item;
    })

    console.log("im in attributions")
    return (
        <div>
        <p className="attributions">
            The following notice is in place due to this website's usage of TradingView for all charts and graphs:
            <br/>
            TradingView Lightweight Charts™
            <br/>
            Copyright (с) 2025 TradingView, Inc. https://www.tradingview.com/
        </p>
            <p>{placeHolder}</p>
            <p>{JSON.stringify(data)}</p>
            {/*<p>{children}</p>*/}
        </div>
        )
}

export const Route = createFileRoute('/Attributions') ({
    component: Attributions,
})