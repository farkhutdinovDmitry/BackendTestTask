package ru.kameleoon.trial.dto.quote;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.kameleoon.trial.dto.user.UserDto;
import ru.kameleoon.trial.dto.vote.VoteDto;

import java.util.List;

@AllArgsConstructor
@Data
public class QuoteDto {
	private final long id;
	private final String content;
	private final int score;
	private final UserDto userId;
	private final List<VoteDto> votes;
}
