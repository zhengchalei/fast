package io.github.zhengchalei.jpa.example;

import io.github.zhengchalei.jpa.demo.QBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void test() {
        Book book = new Book();
        book.setName("halo Java");
        this.bookRepository.saveAndFlush(book);

        List<Book> all = this.bookRepository.findAll();
        all.forEach(System.out::println);

        Book halo_java = this.bookRepository.findOne(QBook.book.name.eq("halo Java")).orElseThrow(RuntimeException::new);
        System.out.println(halo_java);
    }

}
