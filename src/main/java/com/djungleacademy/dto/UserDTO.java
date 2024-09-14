package com.djungleacademy.dto;

import com.djungleacademy.validation.FieldMatch;
import com.djungleacademy.validation.Password;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldMatch.List({
        @FieldMatch(fieldOne = "password", fieldTwo = "confirmPassword", message = "Passwords must match"),
        @FieldMatch(fieldOne = "email", fieldTwo = "confirmEmail", message = "email must match")
})
public class UserDTO {

    @NotBlank(message="First Name must not be blank")
    private String firstName;

    @NotBlank(message="Last Name must not be blank")
    private String lastName;

    @NotBlank(message="user name must not be blank")
    private String userName;

    @Password
    @NotBlank(message="Password must not be blank")
    private String password;

    @NotBlank(message = "Confirm Password is required field.")
    @Transient // telling the jpa this is the field no need to interact
    private String confirmPassword;

    @NotBlank(message="Mobile number must not be blank")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String phone;

    @NotBlank(message="Email must not be blank")
    @Email(message = "provide email pls")
    private String email;

    @NotBlank(message = "Confirm email is required field.")
    @Email(message = "provide email pls")
    @Transient // telling the jpa this is the field no need to interact
    private String confirmEmail;
}
