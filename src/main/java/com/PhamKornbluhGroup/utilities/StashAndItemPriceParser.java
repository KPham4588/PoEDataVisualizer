package com.PhamKornbluhGroup.utilities;

import com.PhamKornbluhGroup.DTO.FiltrationDTO.PriceDTO;
import com.PhamKornbluhGroup.DTO.ItemDTO;
import com.PhamKornbluhGroup.DTO.PublicStashChangeDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StashAndItemPriceParser {

    private final static Logger StashAndItemPriceParserLogger = LogManager.getLogger(StashAndItemPriceParser.class);

    public static PriceDTO parseItemPrice(PublicStashChangeDTO stashChangeDTO, ItemDTO itemDTO) {

        //b Get item note, see if it's valid, and if so thats the price
        String itemNote = itemDTO.getNote();
        PriceDTO itemPrice = parsePrice(itemNote);
        // Must have non-null, with a currency type and quantity to be valid

        StashAndItemPriceParserLogger.trace("itemnote is: {}", itemNote);
        StashAndItemPriceParserLogger.trace("itemprice is: {}", itemPrice);
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
            StashAndItemPriceParserLogger.trace("note is null");
            return result;
        }

        // if blank, no valid price
        if (note.isBlank()) {
            StashAndItemPriceParserLogger.trace("note is blank");
            return result;
        }

        // Expected result is:
        //    [0] = ~b/o or ~price
        //    [1] = number like "30"
        //    [2] = currencyType
        String[] noteRegex = note.split(" ");

        // If the noteRegex doesn't match the expected size and format, then it's not a valid price
        if (noteRegex.length != 3) {
            StashAndItemPriceParserLogger.trace("note doesn't match the expected format");
            return result;
        }

        // If [0] isn't "~price" or "~b/o" then it's not a valid price
        String priceOrBuyout = noteRegex[0];
        if (!priceOrBuyout.equals("~price") && !priceOrBuyout.equals("~b/o")) {
            StashAndItemPriceParserLogger.trace("note beginning of \"{}\" doesn't match the expected values \"~price\" or \"~b/o\"", priceOrBuyout);
            return result;
        }

        // if [1] doesn't exclusively contain digits 0-9 or fractions, then it's not a valid price.
        // We are not currently accepting any fractions logic. See the to-do statement below for more info
        // TODO: Prices can also use fractions, for example "~price 3/1 alch" is a valid note, making [1] be "3/1".
        //  We need to update this parser to handle fractions, and then decide upon some rounding logic or change
        //  PriceDTO field "quantity" to double. Note that if we change quantity to double, then PriceDTO's method
        //  "calculateValueOfCurrencyTypeInChaos" will need updates as well
        String priceQuantityAsString = noteRegex[1];
        if (!priceQuantityAsString.matches("[0-9]+")) {
            StashAndItemPriceParserLogger.trace("note's priceQuantityAsString of \"{}\" contains non-number symbols", priceQuantityAsString);
            return result;
        }

        // TODO: We currently don't gate [2] (which maps to currencyType) thoroughly. This means that we can receive
        //  correct values like "chaos", "divine", "fractured-orb", etc, but that we can also receive "unsupported"
        //  currency types like 'vaal', as well as fake ones like "not-selling". This proves that the creation of a non
        //  blank PriceDTO does not mean we have a valid price. We handle this situation by relying on PriceDTO's
        //  calculateValueOfCurrencyTypeInChaos method, which currently returns a price value of 0 when dealing with
        //  unsupported currency types. Then, in the resultDAO, we don't send items priced at 0 (See Note).Instead, we, should create an enum which holds all supported currency
        //  types, and use it to gate improper currency types. This could be done, for example, by  changing the PriceDTO field currencyType to the enum type
        //  NOTE: It might be appropriate to migrate this logic elsewhere too, using some helper to generate a list
        //  of valid priceDTOs

        // All supported types can be found here:
        //    https://www.pathofexile.com/trade/about
        // Note that these can only contain letters and hyphens, so that's the basic pattern we expect
        String currencyType = noteRegex[2];
        if (!currencyType.matches("[a-zA-Z\\-]+]")) {
            StashAndItemPriceParserLogger.trace("note's currencyType of \"{}\" contains unsupported symbols", currencyType);
            return result;
        }

        // At this point, we're confident that the values are workable, so we can begin assigning value
        // to the PriceDTO result
        int quantity = Integer.parseInt(priceQuantityAsString);
        result.setQuantity(quantity);
        result.setCurrencyType(currencyType);

        return result;
    }

}