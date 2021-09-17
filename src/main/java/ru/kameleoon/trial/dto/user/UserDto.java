package ru.kameleoon.trial.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDto {
	private final long id;
	private final String login;
}
