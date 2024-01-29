package com.wale.TruckDriverApp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {
    private String email;
    private String password;
    private String username;
    private String dob;
    private String state;
    private String country;



}
