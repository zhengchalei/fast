package io.github.zhengchalei.mapstruct.example;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.HashMap;
import java.util.Map;

class BookMapperTest {

    BookMapper mapper = Mappers.getMapper(BookMapper.class);

    @Test
    public void test() {
        Book book = new Book();
        book.setName("Java Hello!");

        Map<String, String> map = new HashMap<>();
        map.put("name", "Java Hello!");

        System.out.println(mapper.toDto(book).toString());
        System.out.println(mapper.toEntity( map));
    }

}
