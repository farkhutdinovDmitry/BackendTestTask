package ru.kameleoon.trial.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "voting")
public class Vote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "quote_id", nullable = false)
	private Quote quote;

	@Column(name = "choice")
	private int choice;

	@GeneratedValue
	@Column(name = "time", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	private Date votingTime;

	public Vote(User user, Quote quote, int choice) {
		this.user = user;
		this.quote = quote;
		this.choice = choice;
		this.votingTime = new Date();
	}
}
