package es.vencinas.examples.spring.boot.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import es.vencinas.examples.spring.boot.dao.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // select * from user where name = :name
    public Collection<User> findAllByName(String name);
}
