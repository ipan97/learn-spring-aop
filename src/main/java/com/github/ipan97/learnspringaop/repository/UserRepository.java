package com.github.ipan97.learnspringaop.repository;

import com.github.ipan97.learnspringaop.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ipan Taupik Rahman
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String> {
}
