package ru.kameleoon.trial.mapper;

import org.springframework.stereotype.Component;
import ru.kameleoon.trial.dto.user.CreateUserDto;
import ru.kameleoon.trial.dto.user.UserDto;
import ru.kameleoon.trial.entity.User;

@Component
public class UserMapper {
	public UserDto mapUserToUserDto(User user) {
		return new UserDto(user.getId(), user.getLogin());
	}

	public User mapCreateUserDtoToUser(CreateUserDto dto) {
		return new User(dto.getLogin(), dto.getPassword());
	}
}
