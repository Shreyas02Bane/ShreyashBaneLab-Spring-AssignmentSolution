package com.greatlearning.debate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(exclude = "user")
@ToString(exclude = "user")
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int role_id;

	private String role_name;

	@ManyToMany
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "fk_role_id"), inverseJoinColumns = @JoinColumn(name = "fk_user_id"))
	@Column(name = "user")
	private Set<User> user;

	public Set<User> getUsers() {
		if (this.user == null) {
			this.user = new HashSet<User>();
		}
		return user;
	}
}