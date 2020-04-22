package com.sergio.restapi.DTO;


import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UserDTO {


    @NonNull private String userName;
    @NonNull private String password;
    private String fullName;

}
