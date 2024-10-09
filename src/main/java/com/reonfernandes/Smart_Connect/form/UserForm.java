package com.reonfernandes.Smart_Connect.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    private String name;
    private String email;
    private String password;
    private String gender;
    private String role;
    private String phoneNumber;
    private String address;
    private String region;
}
