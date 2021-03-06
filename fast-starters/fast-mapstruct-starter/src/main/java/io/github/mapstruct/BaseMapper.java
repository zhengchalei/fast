package io.github.mapstruct;

import io.github.mapstruct.matadata.Dto;
import io.github.mapstruct.matadata.Vo;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Map;

/**
 * @author <a href="mailto:stone981023@gmail.com">zhengchalei</a>
 **/
public interface BaseMapper<E, D extends Dto, V extends Vo> {

    /**
     * vo to entity
     *
     * @param vo vo
     * @return entity
     */
    E toEntity(V vo);

    /**
     * dto to entity
     *
     * @param dto dto
     * @return entity
     */
    E toEntity(D dto);

    /**
     * map to entity
     *
     * @param map map
     * @return entity
     */
    E toEntity(Map<String, String> map);

    /**
     * entity to vo
     *
     * @param entity entity
     * @return entity
     */
    V toVo(E entity);

    /**
     * dto to vo
     *
     * @param dto dto
     * @return vo
     */
    V toVo(D dto);

    /**
     * entity to dto
     *
     * @param entity entity
     * @return dto
     */
    D toDto(E entity);

    /**
     * vo to dto
     *
     * @param vo vo
     * @return dto
     */
    D toDto(V vo);

    void fireMerge(E source, @MappingTarget D dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fireMergeIgnoreNull(E source, @MappingTarget D dto);
}
