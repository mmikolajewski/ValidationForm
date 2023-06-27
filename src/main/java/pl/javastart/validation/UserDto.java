package pl.javastart.validation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import pl.javastart.validation.constraint.ValidPassword;
import pl.javastart.validation.constraint.ZipCode;

@Entity
public class UserDto {

    static final String NO_EMPTY_MESSAGE = "Pole nie może być puste";
    static final String MIN_3_CHAR_MESSAGE = "Pole musi mieć conajmniej 3 znaki";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = NO_EMPTY_MESSAGE)
    @Size(min = 3, max = 20, message = MIN_3_CHAR_MESSAGE)
    private String firstName;
    @NotBlank(message = NO_EMPTY_MESSAGE)
    @Size(min = 2, max = 20, message = MIN_3_CHAR_MESSAGE)
    private String lastName;
    @NotBlank(message = NO_EMPTY_MESSAGE)
    @Size(min = 2, max = 50, message = MIN_3_CHAR_MESSAGE)
    private String streetHouseNo;

    @NotBlank(message = NO_EMPTY_MESSAGE)
    @ZipCode
    private String zipCode;
    @NotBlank(message = NO_EMPTY_MESSAGE)
    private String town;
    @Email(message = "musi być poprawnie sformatowanym adresem e-mail", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    @NotBlank(message = NO_EMPTY_MESSAGE)
    @Size(min = 8, max = 20, message = "Hasło musi mieć co najmniej 8 znaków")
    @ValidPassword
    private String password;
    @AssertTrue(message = "akceptacja regulaminu jest wymagana")
    private boolean termsOfServiceAccepted;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStreetHouseNo() {
        return streetHouseNo;
    }

    public void setStreetHouseNo(String streetHouseNo) {
        this.streetHouseNo = streetHouseNo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String code) {
        this.zipCode = code;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTermsOfServiceAccepted() {
        return termsOfServiceAccepted;
    }

    public void setTermsOfServiceAccepted(boolean termsOfServiceAccepted) {
        this.termsOfServiceAccepted = termsOfServiceAccepted;
    }
}
