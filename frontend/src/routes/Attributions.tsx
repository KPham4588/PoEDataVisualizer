import '../css/Attributions.css';
import {createFileRoute} from "@tanstack/react-router";
import {useChartData} from "../hooks/fetchChartData.ts";

function Attributions() {
    // const { data, isLoading, isError } = useChartData("Mageblood", "Keepers");
    const { data, isLoading } = useChartData("Mageblood", "Keepers");
    const placeHolder = isLoading ? "Loading..." : "Done Loading";
    // if (isLoading) return <p>Loading...</p>;
    // if (isError) return <p>Error loading data.</p>;
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
        </div>
        )
}

export const Route = createFileRoute('/Attributions') ({
    component: Attributions,
})