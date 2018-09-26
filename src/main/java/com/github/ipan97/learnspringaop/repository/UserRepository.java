package com.github.ipan97.learnspringaop.repository;

import com.github.ipan97.learnspringaop.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Ipan Taupik Rahman
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {
}
