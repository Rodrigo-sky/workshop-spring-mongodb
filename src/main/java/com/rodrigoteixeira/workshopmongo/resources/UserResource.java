package com.rodrigoteixeira.workshopmongo.resources;

import com.rodrigoteixeira.workshopmongo.domain.User;
import com.rodrigoteixeira.workshopmongo.dto.UserDto;
import com.rodrigoteixeira.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {

        List<User> userList = userService.findAll();

        return ResponseEntity.ok().body(userList.stream().map(UserDto::new).toList());

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDto(user));
    }
}
