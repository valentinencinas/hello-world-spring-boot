package es.vencinas.examples.spring.boot.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import es.vencinas.examples.spring.boot.dao.UserDAO;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<UserDAO, Long> {

    // select * from UserDAO where firstname = :name
    @RestResource(path = "by-firstname")
    public Collection<UserDAO> findAllByFirstname(String name);

    @RestResource(path = "by-lower-firstname")
    @Query("from UserDAO where lower(firstname) like lower(?1)")
    UserDAO findByNameWithQuery(@Param("firstname") String name);
}
