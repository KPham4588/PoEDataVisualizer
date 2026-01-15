package com.PhamKornbluhGroup.controllers;

import com.PhamKornbluhGroup.DAO.ItemDAO;
import com.PhamKornbluhGroup.DTO.ItemDTO;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/items")
public class ItemController {

    @GetMapping
    public ItemDTO GetItems(@RequestParam int id) {

        ItemDAO dao = new ItemDAO();


        var result = dao.getItemById(9655);

        return result;
    }
}
