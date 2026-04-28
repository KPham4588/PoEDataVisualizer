import './GreatestHits.css';
import DefaultAreaChart from "./DefaultAreaChart.tsx";

export default function GreatestHits() {
    return (
        <div className="greatest-hits">
            <p>The absolute greatest hits of all time!</p>
            <DefaultAreaChart/>
        </div>
    );
}