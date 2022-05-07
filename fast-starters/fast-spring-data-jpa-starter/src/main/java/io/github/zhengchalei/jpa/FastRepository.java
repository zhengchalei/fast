package io.github.zhengchalei.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author <a href="mailto:stone981023@gmail.com">zhengchalei</a>
 **/
@NoRepositoryBean
public interface FastRepository<T, ID> extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T>, JpaSpecificationExecutor<T> {

}
