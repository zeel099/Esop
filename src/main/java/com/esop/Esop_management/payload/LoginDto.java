package com.esop.Esop_management.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoginDto {
    private String email;
    private String password;

}
