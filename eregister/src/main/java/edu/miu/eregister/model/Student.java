package edu.miu.eregister.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Entity
@Table(name = "students")
public final class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(nullable = false)
    private String studentNumber;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private final LocalDate dateOfEnrollment =  LocalDate.now();

    @Column(name = "cgpa")
    private Double cgpa;

    @Column(name = "isInternational")
    private boolean isInternational;

}
