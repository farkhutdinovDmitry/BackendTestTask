package ru.kameleoon.trial.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kameleoon.trial.dao.UserDao;
import ru.kameleoon.trial.dto.user.CreateUserDto;
import ru.kameleoon.trial.dto.user.UserDto;
import ru.kameleoon.trial.entity.User;
import ru.kameleoon.trial.exception.ConflictException;
import ru.kameleoon.trial.mapper.UserMapper;

@AllArgsConstructor
@Service
public class UserService {
	private final UserDao userDao;
	private final UserMapper mapper;

	@Transactional
	public UserDto addUser(CreateUserDto dto) {
		if (userDao.findUserByLogin(dto.getLogin()).isPresent()) {
			throw new ConflictException("User with such login already exists");
		}
		User addedUser = userDao.addUser(mapper.mapCreateUserDtoToUser(dto));
		return mapper.mapUserToUserDto(addedUser);
	}
}
