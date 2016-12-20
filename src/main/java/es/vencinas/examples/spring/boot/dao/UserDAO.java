package es.vencinas.examples.spring.boot.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Size(min = 1, max = 16)
    private String lastname;
    
    @Email
    private String email;
    
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Past
    private Date birthday;
}
