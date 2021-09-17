package ru.kameleoon.trial.dto.vote;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import ru.kameleoon.trial.dto.user.UserDto;

import java.util.Date;

@AllArgsConstructor
@Data
@Getter
public class VoteDto {
	private final long id;
	private final int choice;
	private final long quoteId;
	private final UserDto userDto;
	private final Date time;
}
