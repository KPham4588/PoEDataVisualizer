package com.PhamKornbluhGroup.services;

import com.PhamKornbluhGroup.DTO.FiltrationDTO.ChartData;
import com.PhamKornbluhGroup.DTO.FiltrationDTO.PriceDTO;
import com.PhamKornbluhGroup.DTO.ItemDTO;
import com.PhamKornbluhGroup.DTO.PublicStashChangeDTO;
import com.PhamKornbluhGroup.utilities.StashAndItemPriceParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemChartDataService {
    private final static Logger ItemChartDataServiceLogger = LogManager.getLogger(ItemChartDataService.class);


    public ArrayList<ChartData> getItemsAsChartDataByCustomParametersAsCostInChaos(
            ArrayList<PublicStashChangeDTO> publicStashChangeDTOs) {

        ArrayList<ChartData> chartDataArrayList = new ArrayList<>();

        // Go through the list converting relevant objects into ChartData format
        // ChartData is the format expected by "Lightweight Charts" on the front-end
        for (PublicStashChangeDTO currentStash : publicStashChangeDTOs) {

            // When querying for Magebloods in Kalandra league for example, you might get a list of
            // 5 publicStashChangeDTOs. But there might be 2 Magebloods in each of them, so grab all items
            // from each stash tab. for each one, see if it has a valid sale price
            ArrayList<ItemDTO> itemsInCurrentStash = currentStash.getItems();
            for (ItemDTO currentItem : itemsInCurrentStash) {
                ItemChartDataServiceLogger.trace("currentItem = {}", currentItem.toString());

                PriceDTO parsedItem = StashAndItemPriceParser.parseItemPriceAndTimestamp(currentStash, currentItem);
                ItemChartDataServiceLogger.trace("parsedItem = {}", parsedItem.toString());


                ItemChartDataServiceLogger.trace("parsedItem isPriceValid = {}", parsedItem.isPriceValid());
                if (parsedItem.isPriceValid()) {
                    ChartData data = new ChartData();

                    data.setValue(parsedItem.calculatePriceInChaos());
                    data.setTimeStamp(parsedItem.getTimestamp());
                    ItemChartDataServiceLogger.trace("parsedItem calculatePriceInChaos = {}", parsedItem.calculatePriceInChaos());

                    chartDataArrayList.add(data);
                }
            }
        }

        ItemChartDataServiceLogger.trace("chartDataArrayList = {}", chartDataArrayList.toString());
        return chartDataArrayList;
    }

}
