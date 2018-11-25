package com.github.ipan97.learnspringaop.web.rest;

import javax.validation.Valid;

import com.github.ipan97.learnspringaop.service.UserService;
import com.github.ipan97.learnspringaop.service.dto.UserDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ipan Taupik Rahman
 */
@RestController
@RequestMapping("/api")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public ResponseEntity<Page<UserDto>> getAllUsers(Pageable pageable) {
		Page<UserDto> result = userService.findAllUser(pageable);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") String id) {
		return userService.findUserById(id)
				.map(ResponseEntity::ok)
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/users")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto request) {
		UserDto result = userService.save(request);
		return ResponseEntity.ok(result);
	}
}
