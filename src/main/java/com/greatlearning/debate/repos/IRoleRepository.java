package com.greatlearning.debate.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.debate.entity.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {

}