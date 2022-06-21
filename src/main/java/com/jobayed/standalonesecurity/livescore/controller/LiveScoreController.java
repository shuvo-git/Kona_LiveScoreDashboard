package com.jobayed.standalonesecurity.livescore.controller;

import com.jobayed.standalonesecurity.livescore.dto.PageRequestor;
import com.jobayed.standalonesecurity.livescore.model.Item;
import com.jobayed.standalonesecurity.livescore.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/live")
public class LiveScoreController {
    private final ItemService itemService;

    @GetMapping("/scores/getSingleItem")
    public Item getSingleItem(@RequestParam String id){
        return itemService.getOneItem(id);
    }

    @GetMapping(value = "/scores")
    public Page<Item> loadItems(@RequestBody PageRequestor pageRequestor) {
        return itemService.getItems(pageRequestor.getPageNumber(), pageRequestor.getPageSize());
    }

    @GetMapping(value = "/scores/{keyword}")
    public Page<Item> searchItems(@RequestBody PageRequestor pageRequestor, @PathVariable String keyword) {
        return itemService.searchItems(pageRequestor.getPageNumber(), pageRequestor.getPageSize(), keyword);
    }
}
