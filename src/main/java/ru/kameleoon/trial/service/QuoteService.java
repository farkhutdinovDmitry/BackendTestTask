package ru.kameleoon.trial.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kameleoon.trial.dao.QuoteDao;
import ru.kameleoon.trial.dao.UserDao;
import ru.kameleoon.trial.dto.quote.CreateQuoteDto;
import ru.kameleoon.trial.dto.quote.QuoteDto;
import ru.kameleoon.trial.dto.quote.UpdateQuoteDto;
import ru.kameleoon.trial.entity.Quote;
import ru.kameleoon.trial.entity.User;
import ru.kameleoon.trial.mapper.QuoteMapper;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class QuoteService {
	private final QuoteDao quoteDao;
	private final UserDao userDao;
	private final QuoteMapper mapper;

	@Transactional
	public QuoteDto addQuote(CreateQuoteDto dto) {
		User user = userDao.getUser(dto.getUserId());
		Quote addedQuote = quoteDao.addQuote(mapper.mapCreateQuoteDtoToQuote(dto, user));
		return mapper.mapQuoteToQuoteDto(addedQuote);
	}

	@Transactional(readOnly = true)
	public QuoteDto getQuote(long id) {
		Quote foundQuote = quoteDao.getQuote(id);
		return mapper.mapQuoteToQuoteDto(foundQuote);
	}

	@Transactional
	public QuoteDto updateQuote(UpdateQuoteDto dto) {
		Quote quoteToUpdate = quoteDao.getQuote(dto.getId());
		quoteToUpdate.setContent(dto.getContent());
		Quote updatedQuote = quoteDao.updateQuote(quoteToUpdate);
		return mapper.mapQuoteToQuoteDto(updatedQuote);
	}

	@Transactional
	public void deleteQuote(Long quoteId) {
		quoteDao.deleteQuote(quoteId);
	}

	@Transactional(readOnly = true)
	public List<QuoteDto> getFirstNQuotesByScore(int count) {
		List<Quote> quotes = quoteDao.getFirstNQuotesByScore(count);
		return quotes.stream().map(mapper::mapQuoteToQuoteDto).collect(Collectors.toList());
	}
}
