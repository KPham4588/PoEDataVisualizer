package com.PhamKornbluhGroup.controllers;

import com.PhamKornbluhGroup.DAO.ItemDAO;
import com.PhamKornbluhGroup.DAO.PublicStashChangeDAO;
import com.PhamKornbluhGroup.DTO.ItemDTO;
import com.PhamKornbluhGroup.DTO.PublicStashChangeDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/items")
public class ItemController {

    @GetMapping("/getItems")
    public ItemDTO getItems(@RequestParam("id") int id) {

        ItemDAO dao = new ItemDAO();

        ItemDTO result = dao.getItemById(id);

        return result;
    }

    // Example: http://localhost:8080/items/getItemsByNameAndLeague?itemName=Mageblood&league=Keepers
    @GetMapping("/getItemsByNameAndLeague")
    public ArrayList<PublicStashChangeDTO> getItemsByNameAndLeague(@RequestParam(name = "itemName") String itemName,
                                                                   @RequestParam(name = "league")   String league) {
        PublicStashChangeDAO dao = new PublicStashChangeDAO();
        return dao.findByItemNameAndLeague(itemName, league);
    }

    // Example: http://localhost:8080/items/getItemsByCustomParameters?itemName=Mageblood&league=Keepers
    @GetMapping("/getItemsByCustomParameters")
    public ArrayList<PublicStashChangeDTO> getItemsByCustomParameters(@RequestParam(name = "itemName",
                                                                                    required = false) String itemName,
                                                                      @RequestParam(name = "league",
                                                                                    required = false) String league) {
        PublicStashChangeDAO dao = new PublicStashChangeDAO();
        return dao.findByCustomParameters(itemName, league);
    }
}
