package com.djungleacademy.entity;

import com.djungleacademy.enums.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

//    @Column(name = "first_name")
    // firstName will become first_name in DB
    private String firstName;

//    @Column(name = "last_name")
    private String lastName;

//    @Column(name = "user_name")
    private String userName;

//    @Column(name = "password")
    private String password;

//    @Column(name = "email")
    private String email;

//    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    private UserType userType;

/*      fetch: eager -> load All entity straight away, lazy -> load All entity when is needed

  cascade: ALL -> effect change from a-z for all connected entities, Includes all the following
          PERSIST -> when saving the entity, bring the change to all associated entities.
          REMOVE -> when deleting the entity, bring the change to all associated entities.
          MERGE -> when merging the entity, bring the change to all associated entities.
          DETACH -> when detaching the entity, bring the change to all associated entities.
          REFRESH -> when refreshing the entity, bring the change to all associated entities.



    @JoinColumn(name = "role_id", referencedColumnName = "description")
    JoinColumn: if referencedColumnName is specified, then the attribute value will be used.(must be unique)
    If not, the default ID will be used because that is unique.*/

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;
}
