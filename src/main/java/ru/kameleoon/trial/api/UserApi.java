package ru.kameleoon.trial.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kameleoon.trial.dto.user.CreateUserDto;
import ru.kameleoon.trial.dto.user.UserDto;
import ru.kameleoon.trial.exception.BadInputException;
import ru.kameleoon.trial.service.UserService;

@AllArgsConstructor
@Service
public class UserApi {
	private final UserService service;

	public UserDto addUser(CreateUserDto dto) {
		if (dto.getLogin() == null || dto.getPassword() == null) {
			throw new BadInputException("Login and password shouldn't be null");
		}
		return service.addUser(dto);
	}
}
