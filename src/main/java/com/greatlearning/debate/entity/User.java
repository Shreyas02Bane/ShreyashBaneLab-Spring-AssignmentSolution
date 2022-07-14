package com.greatlearning.debate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "roles")
@ToString(exclude = "roles")
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_id;
	private String username;
	private String password;
	@ManyToMany(mappedBy = "user")
	@Column(name = "roles")
	private Set<Role> roles;

	public void addRole(Role r) {
		if (this.roles == null) {
			this.roles = new HashSet<Role>();
		}
		this.roles.add(r);
		r.getUsers().add(this);
	}
}