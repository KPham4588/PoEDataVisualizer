package com.PhamKornbluhGroup.utilities;

import com.PhamKornbluhGroup.DTO.FiltrationDTO.PriceDTO;
import com.PhamKornbluhGroup.DTO.ItemDTO;
import com.PhamKornbluhGroup.DTO.PublicStashChangeDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class StashAndItemPriceParser {

    private final static Logger StashAndItemPriceParserLogger = LogManager.getLogger(StashAndItemPriceParser.class);

    public static PriceDTO parseItemPrice(PublicStashChangeDTO stashChangeDTO, ItemDTO itemDTO) {

        //b Get item note, see if it's valid, and if so thats the price
        String itemNote = itemDTO.getNote();
        PriceDTO itemPrice = parsePrice(itemNote);
        // Must have non-null, with a currency type and quantity to be valid


        //r ------ LOGGING -------
        StashAndItemPriceParserLogger.error("itemnote is: " + itemNote);
        StashAndItemPriceParserLogger.error("itemprice is: " + itemPrice);
        //r ------ LOGGING -------
        if (itemPrice.isPriceValid()) {
            return itemPrice;
        }

        //b If we reach here, item price wasn't valid, so fallback to checking stash note
        String stashNote = stashChangeDTO.getStash();
        PriceDTO stashPrice = parsePrice(stashNote);

        if (stashPrice.isPriceValid()) {
            return stashPrice;
        }

        //b if we reach here, return no price. This DTO will return false for priceIsValid()
        return new PriceDTO();
    }

    private static PriceDTO parsePrice(String note) {
        PriceDTO result = new PriceDTO();

        // if null, no valid price
        if (note == null) {
            //r note is null
            System.out.println("note is null");

            return result;
        }

        // If it doesn't start w/ one of these, it's not really listed for sale
        if (!note.startsWith("~price") && !note.startsWith("~b/o")) {
            //r not for sale
            System.out.println("item is not for sale");

            return result;
        }
        try {
            // There should only ever be one match, so if we get one in here, it's likely a valid price
//            String[] regexPrice = note.split(" \\d+");

            //r Test -- Split on space instead
            //r [0] = ~b/o or ~price, [1] = number like "30", [2] = currencyType
            //r running into errors when getting something like ""~b/o  chaos". This makes [1] be empty, causing number exception
            String[] noteRegex = note.split(" ");

            //r noteregex split
            System.out.println("noteregex is");
            System.out.println(Arrays.toString(noteRegex));

            //r comment not true if red
            // If length of array is 0, there is no quantity found. Not valid price
            if (noteRegex.length == 0) {
                return result;
            }

            //r swapped 0 to 1
            String itemCostQuantityAsString = noteRegex[1].trim();
            int itemCostQuantity = Integer.parseInt(itemCostQuantityAsString);
            result.setQuantity(itemCostQuantity);

            
            // now get CurrencyType --
            // Regex Explanation: Lookbehind to make sure there was a digit and a space,
            // then grab any letters or hyphens 1 or more times
//            String[] regexCurrencyType = note.split("(?<=\\d )[a-zA-Z\\-]+");
            //r 2 should be the currencyType
            String itemCurrencyType = noteRegex[2].trim();
            result.setCurrencyType(itemCurrencyType);
        }
        catch (Exception e) {
            // If we fail here, PriceDTO will simply have the default values, and will fail the isPriceValid() check
            StashAndItemPriceParserLogger.error("Failure in parsePrice " + "\r\n" +
                    e.getMessage() + "\r\n"
                    + Arrays.toString(e.getStackTrace()));

        }
        return result;
    }

}