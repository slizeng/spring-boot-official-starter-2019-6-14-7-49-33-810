package com.oocl.web.sampleWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


@RestController
@RequestMapping(path = "/users", produces = "application/json")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user) throws URISyntaxException {
        int createdId;
        try {
            createdId = userService.add(user);
        } catch (Exception ignored) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.created(new URI(String.format("/users/%d", createdId))).build();
    }
}
