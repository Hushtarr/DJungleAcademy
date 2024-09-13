package com.djungleacademy.dto;

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
public class UserDTO {

    @NotBlank(message="First Name must not be blank")
    private String firstName;

    @NotBlank(message="Last Name must not be blank")
    private String lastName;

    @NotBlank(message="user name must not be blank")
    private String userName;

    @NotBlank(message="Password must not be blank")
    private String password;

    @NotBlank(message = "Confirm Password is required field.")
    private String confirmPassword;

    @NotBlank(message="Mobile number must not be blank")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String phone;

    @NotBlank(message="Email must not be blank")
    private String email;

    @NotBlank(message = "Confirm email is required field.")
    private String confirmEmail;
}
