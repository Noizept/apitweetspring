package com.sergio.restapi.Repository.User;

import com.sergio.restapi.Entity.User;
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

class IUserRepositoryImplTest {

     @Autowired
     IUserRepository userRepository;

     @Test
     @Order(1)
     public void userShouldBecreatedOnDatabase() throws Exception {
          Boolean b = userRepository.saveUser(new User("sergio","sergio","Sergio Viula"));
          assertEquals(true,b);
     }

     @Test
     @Order(2)
     public void userShouldFailDuplicateException()  {
          try{
               userRepository.saveUser(new User("sergio","sergio","Sergio Viula"));
               fail();
          } catch (Exception exception) {
               assertTrue(true);
          }
     }

     @Test
     @Order(3)
     public void shouldReturnUser()  {
          User user=userRepository.getUser("sergio");
          assertEquals("sergio",user.getUserName());
     }

     @Test
     @Order(4)
     public void shouldGiveExceptionWithNoFoundUser()  {

          try{
                userRepository.getUser("sergio2");
               fail();
          } catch (Exception exception) {
               assertTrue(true);
          }
     }





}