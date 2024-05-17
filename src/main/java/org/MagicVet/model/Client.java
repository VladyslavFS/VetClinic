package org.MagicVet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class Client {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm", Locale.ENGLISH);
    private String firstName;
    private String lastName;
    private String email;
    private Pet pet;
    private final LocalDateTime registrationDate = LocalDateTime.now();

    @Override
    public String toString() {
        return "Client {"
                + "\n\tfirstName = " + firstName
                + ", lastName = " + lastName
                + ", email = " + email
                + ", registration date = " + registrationDate.format(FORMATTER)
                + ",\n\tpet = " + pet
                + "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName)
                && Objects.equals(lastName, client.lastName)
                && Objects.equals(email, client.email)
                && Objects.equals(pet, client.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, pet);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
