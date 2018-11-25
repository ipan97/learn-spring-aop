package com.github.ipan97.learnspringaop.service;

import java.util.Optional;

import com.github.ipan97.learnspringaop.service.dto.UserDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [DOCUMENTATION HERE].
 *
 * @author Ipan Taufik Rahman
 */
public interface UserService {
	UserDto save(UserDto userDto);

	Page<UserDto> findAllUser(Pageable pageable);

	Optional<UserDto> findUserById(String id);
}
