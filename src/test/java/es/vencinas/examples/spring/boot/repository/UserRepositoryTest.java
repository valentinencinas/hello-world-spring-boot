package es.vencinas.examples.spring.boot.repository;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import es.vencinas.examples.spring.boot.dao.UserDAO;

/**
 * Unit tests for {@link UserRepository}.
 *
 * @author Valentín Encinas
 */
@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        Arrays.asList("Howard", "Leonar", "Raj", "Sheldon").forEach(t -> {
            entityManager.persist(new UserDAO(t));
        });
    }

    // ------------------------------------------------- find all
    @Test
    public void testFindAll() {
        List<UserDAO> users = userRepository.findAll();
        users.iterator().forEachRemaining(user -> {
            System.out.println(user.toString());
        });
    }

}
