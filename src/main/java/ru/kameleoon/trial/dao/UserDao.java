package ru.kameleoon.trial.dao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.kameleoon.trial.database.UserRepository;
import ru.kameleoon.trial.entity.User;
import ru.kameleoon.trial.exception.NotFoundException;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class UserDao {
	private final UserRepository repository;

	public User addUser(User user) {
		return repository.save(user);
	}

	public User getUser(long id) {
		return repository.findById(id).orElseThrow(NotFoundException::new);
	}

	public Optional<User> findUserByLogin(String login) {
		return repository.findUserByLogin(login);
	}
}
