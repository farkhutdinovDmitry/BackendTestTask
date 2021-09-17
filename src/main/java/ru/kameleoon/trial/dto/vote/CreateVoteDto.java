package ru.kameleoon.trial.dto.vote;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateVoteDto {
	private final int choice;
	private final long quoteId;
	private final long userId;
}
