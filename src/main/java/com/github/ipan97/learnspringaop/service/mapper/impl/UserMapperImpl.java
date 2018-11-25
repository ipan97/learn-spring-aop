package com.github.ipan97.learnspringaop.service.mapper.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.ipan97.learnspringaop.domain.User;
import com.github.ipan97.learnspringaop.service.dto.UserDto;
import com.github.ipan97.learnspringaop.service.mapper.UserMapper;

import org.springframework.stereotype.Component;

/**
 * [DOCUMENTATION HERE].
 *
 * @author Ipan Taufik Rahman
 */
@Component
public class UserMapperImpl implements UserMapper {
	@Override
	public UserDto toDto(User user) {
		if (user == null) {
			return null;
		}
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		userDto.setAge(user.getAge());
		return userDto;
	}

	@Override
	public User toEntity(UserDto userDto) {
		if (userDto == null) {
			return null;
		}
		User user = new User();
		user.setId(user.getId());
		user.setFirstName(user.getFirstName());
		user.setLastName(user.getLastName());
		user.setEmail(user.getEmail());
		user.setAge(user.getAge());
		return user;
	}

	@Override
	public List<UserDto> toDtos(List<User> users) {
		if (users == null) {
			return Collections.emptyList();
		}
		List<UserDto> userDtos = new ArrayList<>(users.size());
		users.forEach(user -> userDtos.add(toDto(user)));
		return userDtos;
	}

	@Override
	public List<User> toEntities(List<UserDto> userDtos) {
		if (userDtos == null) {
			return Collections.emptyList();
		}
		List<User> users = new ArrayList<>(userDtos.size());
		userDtos.forEach(userDto -> users.add(toEntity(userDto)));
		return users;
	}
}
