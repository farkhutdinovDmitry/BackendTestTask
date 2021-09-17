package ru.kameleoon.trial.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateUserDto {
	private final String login;
	private final String password;
}
