package dev.br.teaming;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@SpringBootTest
@Transactional
class applicationTests {
    @Autowired
    EntityManager em;

    @Test
    void contextLoads() {

    }

}
