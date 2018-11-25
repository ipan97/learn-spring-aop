package com.github.ipan97.learnspringaop.service.mapper;

import java.util.List;

/**
 * [DOCUMENTATION HERE].
 *
 * @author Ipan Taufik Rahman
 */
public interface EntityMapper<DTO, ENTITY> {
	DTO toDto(ENTITY entity);

	ENTITY toEntity(DTO dto);

	List<DTO> toDtos(List<ENTITY> entities);

	List<ENTITY> toEntities(List<DTO> dtos);
}
