package com.cedacri.progetoDocumentale.controller;

import com.cedacri.progetoDocumentale.dto.UserDto;
import com.cedacri.progetoDocumentale.dto.UserView;
import com.cedacri.progetoDocumentale.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid UserDto userDto) {
        userService.createUser(userDto);
    }

    @GetMapping("/all")
    public List<UserView> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/paginate")
    public List<UserView> getPaginateUsers(@RequestParam int pageNumber,
                                           @RequestParam int pageSize) {
        return userService.getPaginateUsers(pageNumber, pageSize);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable long id,
                           @RequestBody @Valid UserDto userDto) {
        userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable long id) {
        userService.removeUser(id);
    }
}
