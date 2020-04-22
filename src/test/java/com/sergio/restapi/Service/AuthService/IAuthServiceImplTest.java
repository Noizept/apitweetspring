package com.sergio.restapi.Service.AuthService;

import com.sergio.restapi.DTO.UserDTO;
import com.sergio.restapi.RestapiApplication;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = RestapiApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IAuthServiceImplTest {

    @Autowired
    IAuthService authService;

    @Test
    @Order(1)
    public void shouldSaveUserDTOintoDatabase() throws Exception {
        UserDTO userDTO=new UserDTO("sergio","sergio","Sergio Viula");
        Boolean b = authService.register(userDTO);
        assertEquals(true,b);
    }

    @Test
    @Order(2)
    public void userShouldFailDuplicateException() {
        try{
            authService.register(new UserDTO("sergio","sergio","Sergio Viula"));
            fail();
        } catch (Exception exception) {
            assertTrue(true);
        }
    }

    @Test
    @Order(3)
    public void loginShouldBeValid() {
        assertTrue(authService.login(new UserDTO("sergio","sergio")));
    }

    @Test
    @Order(4)
    public void loginShouldBe__NOT__Valid() {
        assertFalse(authService.login(new UserDTO("sergio","sergio2")));
    }

    @Test
    @Order(5)
    public void loginUserDoesNotExist() {
        try{
            authService.login(new UserDTO("sergio2","sergio","Sergio Viula"));
            fail();
        } catch (Exception exception) {
            assertTrue(true);
        }
    }




}