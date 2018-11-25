package com.github.ipan97.learnspringaop.service.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * [DOCUMENTATION HERE].
 *
 * @author Ipan Taufik Rahman
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto implements Serializable {
	private String id;

	private String firstName;

	private String lastName;

	private String email;

	private Integer age;
}
