import {AreaSeries, ColorType, createChart, type IChartApi, type UTCTimestamp} from "lightweight-charts";
import {useEffect, useRef} from "react";

interface ChartData {
    value: number;
    time: UTCTimestamp;
}

export default function DefaultAreaChart() {
    const containerRef: React.RefObject<HTMLDivElement | null> = useRef<HTMLDivElement | null>(null);

    useEffect(() => {
        if (!containerRef.current) return;
        // This is a chart. It defines the box, gridlines, etc.
        // We can also consider it as a container. We represent data within, for example by attaching a data series
        const chart: IChartApi = getDefaultChart(containerRef.current);

        // AreaSeries is the way the data will be represented in our chart.
        // Instead of a line to plot price, we use area which is similar.
        // Before creating the areaSeries, we set aesthetics here. LineColor, etc
        const areaSeriesOptions = getDefaultAreaSeriesOptions();

        // This does 3 things:
        //    1. Creates a Series using the options we've chosen
        //    2. Attaches it to the chart
        //    3. Returns an areaSeries object which we can edit
        const areaSeries = chart.addSeries(AreaSeries, areaSeriesOptions);

        // Now that the areaSeries is attached to the chart, we get the data
        const data: ChartData[] = getExampleChartData();

        // Represent the data using the areaSeries
        areaSeries.setData(data);

        // Let Lightweight Charts handle default zoom-level to make the chart clean upon first-load
        chart.timeScale().fitContent();

        return () =>
            chart.remove(); // cleanup
    }, []);

    return (
        <div ref={containerRef} className="container"></div>
    );
}

const getExampleChartData = (): ChartData[] => {
    return [
        {value: 1, time: 1642425322 as UTCTimestamp},
        {value: 8, time: 1642511722 as UTCTimestamp},
        {value: 10, time: 1642598122 as UTCTimestamp},
        {value: 20, time: 1642684522 as UTCTimestamp},
        {value: 3, time: 1642770922 as UTCTimestamp},
        {value: 43, time: 1642857322 as UTCTimestamp},
        {value: 41, time: 1642943722 as UTCTimestamp},
        {value: 43, time: 1643030122 as UTCTimestamp},
        {value: 56, time: 1643116522 as UTCTimestamp},
        {value: 46, time: 1643202922 as UTCTimestamp},
        {value: 85, time: 1693302922 as UTCTimestamp},
        {value: 86, time: 1693402922 as UTCTimestamp},
        {value: 88, time: 1693502922 as UTCTimestamp},
        {value: 92, time: 1694202922 as UTCTimestamp},
        {value: 84, time: 1694302922 as UTCTimestamp},
        {value: 82, time: 1694602922 as UTCTimestamp},
        {value: 103, time: 1705802922 as UTCTimestamp},
        {value: 55, time: 1707802922 as UTCTimestamp},
        {value: 98, time: 1715802922 as UTCTimestamp},
        {value: 185, time: 1725802922 as UTCTimestamp},
        {value: 278, time: 1736902922 as UTCTimestamp},
        {value: 467, time: 1747202922 as UTCTimestamp},
    ];
}

const getDefaultChart = (referenceCurrent: HTMLDivElement) => {
    return createChart(referenceCurrent, {
        autoSize: true,

        layout: {
            textColor: 'black',
            background: {type: ColorType.Solid, color: 'rgba(158,157,157,0.6)'},
            fontSize: 24,
        },

        grid: {
            vertLines: {visible: false},
            horzLines: {visible: false},
        },
    });
}

const getDefaultAreaSeriesOptions = () => {
    return {
        lineColor: '#0043fa',
        topColor: 'rgba(0,67,250,0.8)',
        bottomColor: 'rgba(0, 67, 250, 0.08)',
        baseLineStyle: 4,
    };
};