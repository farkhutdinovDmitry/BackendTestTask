package ru.kameleoon.trial.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "login", unique = true, nullable = false)
	private String login;

	@Column(name = "password", nullable = false)
	private String password;

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
}
