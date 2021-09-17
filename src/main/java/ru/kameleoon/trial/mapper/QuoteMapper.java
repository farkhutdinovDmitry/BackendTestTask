package ru.kameleoon.trial.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.kameleoon.trial.dto.quote.CreateQuoteDto;
import ru.kameleoon.trial.dto.quote.QuoteDto;
import ru.kameleoon.trial.entity.Quote;
import ru.kameleoon.trial.entity.User;

import java.util.Collections;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class QuoteMapper {
	private final UserMapper userMapper;
	private final VoteMapper voteMapper;

	public Quote mapCreateQuoteDtoToQuote(CreateQuoteDto dto, User user) {
		return new Quote(user, dto.getContent());
	}

	public QuoteDto mapQuoteToQuoteDto(Quote quote) {
		return new QuoteDto(
			quote.getId(),
			quote.getContent(),
			quote.getScore(),
			userMapper.mapUserToUserDto(quote.getUser()),
			quote.getVotes() == null ?
				Collections.emptyList()
				: quote.getVotes()
				.stream()
				.map(voteMapper::mapVoteToVoteDto)
				.collect(Collectors.toList()));
	}
}
