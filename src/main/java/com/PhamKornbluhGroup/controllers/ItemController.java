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

    @GetMapping
    public ItemDTO getItems(@RequestParam int id) {

        ItemDAO dao = new ItemDAO();


        var result = dao.getItemById(id);

        return result;
    }

    // https://localhost:8080/items/getItemsByNameAndLeague?itemName=Mageblood&league=Keepers
    @GetMapping
    public ArrayList<PublicStashChangeDTO> getItemsByNameAndLeague(@RequestParam("itemName") String itemName,
                                                                   @RequestParam("league") String league) {
        PublicStashChangeDAO dao = new PublicStashChangeDAO();
        return dao.findByItemNameAndLeague(itemName, league);
    }
}
