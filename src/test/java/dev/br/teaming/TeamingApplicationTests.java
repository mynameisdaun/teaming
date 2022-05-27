package dev.br.teaming;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dev.br.teaming.entity.Hello;
import dev.br.teaming.entity.QHello;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@Transactional
class TeamingApplicationTests {
    @Autowired
    EntityManager em;

    @Test
    void contextLoads() {
        Hello hello = new Hello();
        em.persist(hello);
        JPAQueryFactory query = new JPAQueryFactory(em);
        QHello qHello = QHello.hello;
        Hello result = query
                .selectFrom(qHello)
                .fetchOne();
       assertThat(result).isEqualTo(hello);
    }

}
