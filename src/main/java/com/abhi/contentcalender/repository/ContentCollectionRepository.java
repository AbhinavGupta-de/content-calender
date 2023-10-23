package com.abhi.contentcalender.repository;

import com.abhi.contentcalender.model.Content;
import com.abhi.contentcalender.model.Status;
import com.abhi.contentcalender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

import java.util.*;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll() {
//        System.out.println("findAll");
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(content -> content.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public void deleteById(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }

    @PostConstruct
    private void init(){
        Content c = new Content(1,
                "Initial Post!",
                "Test first blog post! Nothing to worry about!",
                Status.IN_PROGRESS,
                Type.ARTICLE,
                LocalDateTime.now(),
                LocalDateTime.now(),
                "");
        contentList.add(c);
    }
}
