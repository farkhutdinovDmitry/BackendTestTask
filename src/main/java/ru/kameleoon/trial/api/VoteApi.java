package ru.kameleoon.trial.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kameleoon.trial.dto.vote.CreateVoteDto;
import ru.kameleoon.trial.dto.vote.VoteDto;
import ru.kameleoon.trial.service.VoteService;

@AllArgsConstructor
@Service
public class VoteApi {
	private final VoteService voteService;

	public VoteDto addVote(CreateVoteDto createDto) {
		return voteService.addVote(createDto);
	}
}
