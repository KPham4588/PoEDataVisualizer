import '../css/Attributions.css';
import {createFileRoute} from "@tanstack/react-router";

function Attributions() {
    return (
        <p className="attributions">
            The following notice is in place due to this website's usage of TradingView for all charts and graphs:
            <br/>
            TradingView Lightweight Charts™
            <br/>
            Copyright (с) 2025 TradingView, Inc. https://www.tradingview.com/
        </p>
        )
}

export const Route = createFileRoute('/Attributions') ({
    component: Attributions,
})