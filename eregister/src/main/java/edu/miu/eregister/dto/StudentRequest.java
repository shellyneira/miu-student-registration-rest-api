package edu.miu.eregister.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentRequest {
    private String studentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private Double cgpa;
    private boolean isInternational;

    public String getStudentNumber() {
        return this.studentNumber;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Double getCgpa() {
        return this.cgpa;
    }

    public boolean isInternational() {
        return this.isInternational;
    }
}
