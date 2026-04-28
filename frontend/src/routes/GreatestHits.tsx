// src/routes/GreatestHits.tsx
import '../css/GreatestHits.css';
import { createFileRoute } from '@tanstack/react-router';
import DefaultAreaChart from "../DefaultAreaChart.tsx";

function GreatestHits() {
    return (
        <div className="greatest-hits">
            <p>The absolute greatest hits of all time!</p>
            <DefaultAreaChart/>
        </div>
    );
}

export const Route = createFileRoute('/GreatestHits')({
    component: GreatestHits
});