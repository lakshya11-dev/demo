package com.example.demo.controller;

import com.example.demo.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;



    @PostMapping("/words")
    public String addWord(@RequestParam String word) {
        return dictionaryService.addWord(word);
    }

    @GetMapping("/search")
    public String search(@RequestParam String word) {
        return dictionaryService.search(word);
    }

    @GetMapping("/suggest")
    public List<String> suggest(
            @RequestParam String prefix,
            @RequestParam int k) {

        return dictionaryService.suggest(prefix, k);
    }
}
