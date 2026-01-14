package com.PhamKornbluhGroup.controllers;

import com.PhamKornbluhGroup.DAO.ResultDAO;
import com.PhamKornbluhGroup.DTO.ResultDTO;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/items")
public class ItemController {

    @GetMapping
    public ResultDTO GetItems(@RequestParam int id) {

        ResultDAO dao = new ResultDAO();


        var results = dao.getResultById(id);

        return results;
    }
}
