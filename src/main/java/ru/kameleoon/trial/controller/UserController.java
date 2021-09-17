package ru.kameleoon.trial.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kameleoon.trial.api.UserApi;
import ru.kameleoon.trial.dto.user.CreateUserDto;
import ru.kameleoon.trial.dto.user.UserDto;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
	private final UserApi userApi;

	@PostMapping
	public UserDto addUser(@RequestBody CreateUserDto dto) {
		return userApi.addUser(dto);
	}
}



