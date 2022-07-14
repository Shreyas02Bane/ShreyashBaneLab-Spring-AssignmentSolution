package com.greatlearning.debate.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.debate.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}