package com.jobayed.standalonesecurity.authentication;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PACKAGE)
@Getter(AccessLevel.PACKAGE)
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String role;
}
