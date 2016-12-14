package es.vencinas.examples.spring.boot.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author Valentín Encinas
 */
@Entity
@ToString(includeFieldNames = true)
@NoArgsConstructor
@RequiredArgsConstructor
@Accessors(fluent = true)
public class User {

    @Id
    @GeneratedValue
    @Getter
    private Long idUser;

    @NonNull
    @Getter
    @Setter
    @Size(min = 1, max = 16)
    private String firstname;

    @NotNull
    @Size(min = 1, max = 16)
    private String lastname;
}
