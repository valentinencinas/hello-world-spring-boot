package es.vencinas.examples.spring.boot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsCollectionWithSize;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import es.vencinas.examples.spring.boot.dao.UserDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloWordSpringBootApplicationTests {

    @MockBean
    private Collection<UserDAO> listUsers;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        listUsers = new ArrayList<>();
        Arrays.asList("Howard", "Leonar", "Raj", "Sheldon").forEach(t -> {
            listUsers.add(new UserDAO(t));
        });
    }

    @Test
    public void testMockHasItem() {
        MatcherAssert.assertThat(listUsers, CoreMatchers.hasItems(new UserDAO("Raj")));
    }

    @Test
    public void testMockHasSize() {
        MatcherAssert.assertThat(listUsers, IsCollectionWithSize.hasSize(4));
        MatcherAssert.assertThat(listUsers.size(), CoreMatchers.is(4));
    }

    @Test
    public void testMockIsEmpty() {
        MatcherAssert.assertThat(listUsers, CoreMatchers.not(IsEmptyCollection.empty()));
    }
}
