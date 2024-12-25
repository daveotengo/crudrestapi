package org.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Entity;

@Entity
public class Person extends PanacheEntity {
    @NotNull
    public String firstName;
    @NotNull
    public String lastName;
    public String otherName;

    public Person(String firstName, String lastName, String otherName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherName = otherName;
    }

    public Person() {

    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", otherName='" + otherName + '\'' +
//                '}';
//    }
}
