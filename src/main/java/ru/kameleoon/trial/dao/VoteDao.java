package ru.kameleoon.trial.dao;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.kameleoon.trial.database.VoteRepository;
import ru.kameleoon.trial.entity.Vote;

@AllArgsConstructor
@Repository
public class VoteDao {
	private final VoteRepository repository;

	public Vote addVote(Vote vote) {
		return repository.save(vote);
	}
}
