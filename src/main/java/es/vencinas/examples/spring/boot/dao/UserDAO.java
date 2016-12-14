package es.vencinas.examples.spring.boot.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Valentín Encinas
 */
@Entity
@Table(name = "user")
@Data
@ToString(includeFieldNames=true)
@NoArgsConstructor
@RequiredArgsConstructor
public class UserDAO {

    @Id
    @GeneratedValue
    @Setter(value=AccessLevel.NONE)
    private Long idUser;

    @NonNull
    @Size(min = 1, max = 16)
    private String firstname;

    @NotNull
    @Size(min = 1, max = 16)
    private String lastname;
}
