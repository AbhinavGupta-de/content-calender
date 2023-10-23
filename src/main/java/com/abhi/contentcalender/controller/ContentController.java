package com.abhi.contentcalender.controller;

import com.abhi.contentcalender.model.Content;
import com.abhi.contentcalender.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.*;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository contentCollectionRepository;

    public ContentController(ContentCollectionRepository contentCollectionRepository) {
//        System.out.println("ContentController constructor");
        this.contentCollectionRepository = contentCollectionRepository;
    }

    @GetMapping("")
    public List<Content> getAllContent() {
//        System.out.println("getAllContent");
        return contentCollectionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Content getContentById(@PathVariable Integer id) {
        return contentCollectionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content) {
        contentCollectionRepository.save(content);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Content content) {
        if(contentCollectionRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");
        }
        contentCollectionRepository.save(content);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        contentCollectionRepository.deleteById(id);
    }

}
