package dev.springboot.springbootpractice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.springboot.springbootpractice.model.Friend;

@RestController
@RequestMapping("/api/twitter")
public class FriendsController {

    private List<Friend> friends;

    public FriendsController() {
        friends = new ArrayList<>();
        friends.add(new Friend("omair", "Omair Mangondaya"));
        friends.add(new Friend("mags", "Abdulrahman Magoncar"));
        friends.add(new Friend("mats", "Abdul Matin Maruhom"));
        friends.add(new Friend("abs", "Mosaab Talib"));
        friends.add(new Friend("bash", "Yassier Basher"));
    }

    @GetMapping()
    public List<Friend> list() {
        return friends;
    } 

    @GetMapping("/{id}")
    public Friend  get(@PathVariable String id) {
        return friends.stream().filter(f -> id.equals(f.getId())).findAny().orElse(null);
    }

}
