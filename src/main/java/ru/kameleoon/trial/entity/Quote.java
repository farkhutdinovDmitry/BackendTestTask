package ru.kameleoon.trial.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quotes")
public class Quote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private User user;

	@Column(name = "content", nullable = false)
	private String content;

	@Column(columnDefinition = "integer default 0")
	private int score;

	@OneToMany(mappedBy = "quote")
	private List<Vote> votes;

	public Quote(User user, String content) {
		this.user = user;
		this.content = content;
	}
}
