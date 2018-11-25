package com.github.ipan97.learnspringaop.service.impl;

import java.util.Optional;

import com.github.ipan97.learnspringaop.domain.User;
import com.github.ipan97.learnspringaop.repository.UserRepository;
import com.github.ipan97.learnspringaop.service.UserService;
import com.github.ipan97.learnspringaop.service.dto.UserDto;
import com.github.ipan97.learnspringaop.service.mapper.UserMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [DOCUMENTATION HERE].
 *
 * @author Ipan Taufik Rahman
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	private final UserMapper userMapper;


	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	@Override
	public UserDto save(UserDto userDto) {
		User user = userMapper.toEntity(userDto);
		user = userRepository.save(user);
		return userMapper.toDto(user);
	}

	@Override
	public Page<UserDto> findAllUser(Pageable pageable) {
		return userRepository.findAll(pageable)
				.map(userMapper::toDto);
	}

	@Override
	public Optional<UserDto> findUserById(String id) {
		return userRepository.findById(id)
				.map(userMapper::toDto);
	}
}
