package es.vencinas.examples.spring.boot.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.vencinas.examples.spring.boot.dao.UserDAO;

public interface UserRepository extends JpaRepository<UserDAO, Long> {

    // select * from UserDAO where firstname = :name
    public Collection<UserDAO> findAllByFirstname(String name);

    @Query("from UserDAO where lower(firstname) like lower(?1)")
    UserDAO findByNameWithQuery(@Param("firstname") String name);
}
