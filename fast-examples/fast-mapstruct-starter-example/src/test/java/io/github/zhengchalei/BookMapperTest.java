package io.github.zhengchalei;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Map;

class BookMapperTest {

    BookMapper mapper = Mappers.getMapper(BookMapper.class);

    @Test
    public void test() {
        Book book = new Book();
        book.setName("Java Hello!");

        Map<String, String> map = Map.ofEntries(Map.entry("name", "Java Hello!"));

        System.out.println(mapper.toDto(book).toString());
        System.out.println(mapper.toEntity( map));
    }

}
