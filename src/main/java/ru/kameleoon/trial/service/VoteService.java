package ru.kameleoon.trial.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kameleoon.trial.dao.QuoteDao;
import ru.kameleoon.trial.dao.UserDao;
import ru.kameleoon.trial.dao.VoteDao;
import ru.kameleoon.trial.dto.vote.CreateVoteDto;
import ru.kameleoon.trial.dto.vote.VoteDto;
import ru.kameleoon.trial.entity.Quote;
import ru.kameleoon.trial.entity.User;
import ru.kameleoon.trial.entity.Vote;
import ru.kameleoon.trial.mapper.VoteMapper;

@AllArgsConstructor
@Service
public class VoteService {
	private final QuoteDao quoteDao;
	private final UserDao userDao;
	private final VoteDao voteDao;
	private final VoteMapper mapper;

	@Transactional
	public VoteDto addVote(CreateVoteDto dto) {
		User user = userDao.getUser(dto.getUserId());
		Quote quote = quoteDao.getQuote(dto.getQuoteId());
		Vote voteToAdd = mapper.mapCreateVoteDtoToVote(dto, user, quote);

		return mapper.mapVoteToVoteDto(voteDao.addVote(voteToAdd));
	}
}
