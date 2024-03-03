package demo.Profile.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "profile")
public class Profile {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate bornOn;
}