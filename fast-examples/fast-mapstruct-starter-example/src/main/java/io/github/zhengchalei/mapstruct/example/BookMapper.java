package io.github.zhengchalei.mapstruct.example;

import io.github.mapstruct.BaseMapper;
import org.mapstruct.Mapper;

/**
 * @author <a href="mailto:stone981023@gmail.com">zhengchalei</a>
 **/
@Mapper
public interface BookMapper extends BaseMapper<Book, BookDto, BookVo> {
}
