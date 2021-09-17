package ru.kameleoon.trial.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kameleoon.trial.api.VoteApi;
import ru.kameleoon.trial.dto.vote.CreateVoteDto;
import ru.kameleoon.trial.dto.vote.VoteDto;

@RestController
@AllArgsConstructor
@RequestMapping("/vote")
public class VoteController {
	private final VoteApi voteApi;

	@PostMapping
	public VoteDto addVote(@RequestBody CreateVoteDto quote) {
		return voteApi.addVote(quote);
	}
}
