
  package com.capgimini.vehicleinsurance;
  
  
  import static org.junit.Assert.assertEquals;
  import static org.junit.Assert.assertNotNull;
  
  import org.junit.runner.RunWith;
  import javax.persistence.Column; import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType; import javax.persistence.Id; import
  javax.validation.constraints.NotEmpty; import
  javax.validation.constraints.NotNull;
  
  import org.junit.jupiter.api.Test;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.boot.test.context.SpringBootTest; import
  org.springframework.boot.test.mock.mockito.MockBean; import
  org.springframework.test.context.junit4.SpringRunner;
  
  import com.capgimini.vehicleinsurance.entity.User; import
  com.capgimini.vehicleinsurance.repository.UserRepository; import
  com.capgimini.vehicleinsurance.service.UserService;
  
  @RunWith(SpringRunner.class)




  @SpringBootTest
  class VehicleInsuranceTest {
  	
  	@Autowired
  	private UserService userService;
  	
  	
  	
  	
  	@Test
  	public void saveUserRetTest() {
  System.out.println("******");
  		
  		User user = new User();
  		user.setUserName("Pavitra Nagaral");
  		user.setUserPassword("12345");
  		user.setLicence("TN7890");
  		user.setMailId("abcs@gmail.com");
  		user.setNationality("indian");
  		user.setUserGender("Female");
  		assertNotNull(userService.addUser(user));
  	}

	/*
	 * @Test public void saveUsersCusTest() { System.out.println("******");
	 * 
	 * User userDetails = new UserDetails(); userDetails.setName("Haleema");
	 * userDetails.setPassword("12346"); userDetails.setRole("Customer");
	 * assertNotNull(userDetailsService.addUserDetails(userDetails)); }
	 * 
	 * @Test public void saveUserSupTest() { System.out.println("******");
	 * 
	 * UserDetails userDetails = new UserDetails(); userDetails.setName("Zareena");
	 * userDetails.setPassword("12347"); userDetails.setRole("Supplier");
	 * assertNotNull(userDetailsService.addUserDetails(userDetails)); }
	 */

  }
  
	/*
	 * @SpringBootTest class SpringbootThymeleafWebApp1ApplicationTests {
	 * 
	 * @Autowired private UserService userService;
	 * 
	 * @MockBean private UserRepository userRepository;
	 * 
	 * @Test public void saveUserTest() {
	 * 
	 * User user = new User(); user.setUserName("Pavitra");
	 * user.setUserPassword("12345"); user.setUserGender("Female");
	 * user.setNationality("Indian"); user.setLicence("KT908766");
	 * user.setMailId("Rt@gmail"); assertEquals(user, userService.addUser(user)); }
	 * 
	 * }
	 */