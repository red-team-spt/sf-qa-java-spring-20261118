package com.septeo.corpus.controller;

import com.septeo.corpus.model.Item;
import com.septeo.corpus.repository.ItemRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemRepository items;

    public ItemController(ItemRepository items) {
        this.items = items;
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable long id) {
        return items.findById(id);
    }

    @GetMapping("/search")
    public List<Item> search(@RequestParam("q") String q) {
        return items.searchByName(q);
    }

    @GetMapping
    public List<Item> byCategory(@RequestParam String category) {
        return items.findByCategory(category);
    }
}
