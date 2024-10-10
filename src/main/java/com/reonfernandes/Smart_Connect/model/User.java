package com.reonfernandes.Smart_Connect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false, length = 1000)
    private String address;

    private String profilePic;

    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contactList;

    private boolean accountEnabled = false;
    private boolean emailVerified = false;
    private boolean phoneNumberVerified = false;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private Providers providers = Providers.SELF;

    @Column(unique = true)
    private String providerId;
}
