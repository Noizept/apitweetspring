package com.sergio.restapi.Entity;


import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private Integer id;
    @NonNull private String userName;
    @NonNull private String password;
    private String fullName;

    public User(String aUserName,String aPassword,String aFullName){
        userName=aUserName;
        password=aPassword;
        fullName=aFullName;

    }



}
