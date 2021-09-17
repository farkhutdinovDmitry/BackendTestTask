package ru.kameleoon.trial.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.kameleoon.trial.dto.vote.CreateVoteDto;
import ru.kameleoon.trial.dto.vote.VoteDto;
import ru.kameleoon.trial.entity.Quote;
import ru.kameleoon.trial.entity.User;
import ru.kameleoon.trial.entity.Vote;

@AllArgsConstructor
@Component
public class VoteMapper {
	private final UserMapper mapper;

	public VoteDto mapVoteToVoteDto(Vote vote) {
		return new VoteDto(
			vote.getId(),
			vote.getChoice(),
			vote.getQuote().getId(),
			mapper.mapUserToUserDto(vote.getUser()),
			vote.getVotingTime());
	}

	public Vote mapCreateVoteDtoToVote(CreateVoteDto dto, User user, Quote quote) {
		return new Vote(user, quote, dto.getChoice());
	}
}
