import './GreatestHits.css';
import DefaultAreaChart from "./DefaultAreaChart.tsx";
// import {AreaSeries, ColorType, createChart, type UTCTimestamp} from "lightweight-charts";
// import {useEffect, useRef} from "react";

export default function GreatestHits() {
    // console.log("useEffect fired");
    // const containerRef = useRef<HTMLDivElement | null>(null);
    //
    // useEffect(() => {
    //     console.log("useEffect fired", containerRef.current);
    //     if (!containerRef.current) return;
    //
    //     const chart = createChart(containerRef.current, {
    //         autoSize: true,
    //         layout: {
    //             textColor: 'black',
    //             background: {type: ColorType.Solid, color: 'rgba(158,157,157,0.6)'},
    //             fontSize: 24,
    //         },
    //         grid: {
    //             vertLines: {visible: false},
    //             horzLines: {visible: false},
    //
    //         },
    //     });
    //
    //     const areaSeries = chart.addSeries(AreaSeries, {
    //         lineColor: '#0043fa',
    //         topColor: 'rgba(0,67,250,0.8)',
    //         bottomColor: 'rgba(0, 67, 250, 0.08)',
    //         baseLineStyle: 4
    //         });
    //
    //     const data = [
    //         {value: 1, time: 1642425322 as UTCTimestamp},
    //         {value: 8, time: 1642511722 as UTCTimestamp},
    //         {value: 10, time: 1642598122 as UTCTimestamp},
    //         {value: 20, time: 1642684522 as UTCTimestamp},
    //         {value: 3, time: 1642770922 as UTCTimestamp},
    //         {value: 43, time: 1642857322 as UTCTimestamp},
    //         {value: 41, time: 1642943722 as UTCTimestamp},
    //         {value: 43, time: 1643030122 as UTCTimestamp},
    //         {value: 56, time: 1643116522 as UTCTimestamp},
    //         {value: 46, time: 1643202922 as UTCTimestamp},
    //         {value: 85, time: 1693302922 as UTCTimestamp},
    //         {value: 86, time: 1693402922 as UTCTimestamp},
    //         {value: 88, time: 1693502922 as UTCTimestamp},
    //         {value: 92, time: 1694202922 as UTCTimestamp},
    //         {value: 84, time: 1694302922 as UTCTimestamp},
    //         {value: 82, time: 1694602922 as UTCTimestamp},
    //         {value: 103, time: 1705802922 as UTCTimestamp},
    //         {value: 55, time: 1707802922 as UTCTimestamp},
    //         {value: 98, time: 1715802922 as UTCTimestamp},
    //         {value: 185, time: 1725802922 as UTCTimestamp},
    //         {value: 278, time: 1736902922 as UTCTimestamp},
    //         {value: 467, time: 1747202922 as UTCTimestamp},
    //     ];
    //
    //     areaSeries.setData(data);
    //     chart.timeScale().fitContent();
    //
    //     return () =>
    //         chart.remove(); // cleanup
    // }, []);

    return (
        <div className="greatest-hits">
            <p>The absolute greatest hits of all time!</p>
            {/*<div ref={containerRef} className="container"></div>*/}
            <DefaultAreaChart/>
        </div>
    );
}