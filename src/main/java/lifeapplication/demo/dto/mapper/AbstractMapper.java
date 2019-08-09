package lifeapplication.demo.dto.mapper;

import lifeapplication.demo.dto.BaseDto;
import lifeapplication.demo.entities.parrentEntities.CreatebleEntity;

import java.util.Objects;

interface AbstractMapper<E extends CreatebleEntity, D extends BaseDto> {

    abstract public E toEntity(D dto);

    public D toDto(E entity);
}
