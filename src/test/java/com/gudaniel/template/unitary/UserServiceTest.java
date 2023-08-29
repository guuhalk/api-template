package com.gudaniel.template.unitary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;

import com.gudaniel.template.base.MocksUtils;
import com.gudaniel.template.entities.models.User;
import com.gudaniel.template.repositories.UserRepository;
import com.gudaniel.template.services.UserService;


@DisplayName("Unitary test class - UserService")
class UserServiceTest {

	@Spy
	@InjectMocks
	private UserService userService;
	
	@Mock
	private ModelMapper modelMapper;
	
	@Mock
	private UserRepository userRepository;
		
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);	
		doReturn(MocksUtils.mockOptionalUser()).when(userRepository).findById(anyLong());
		
	}

	
	@Test
	@DisplayName("Test Method getUserById() ")
	void testGetUserById() {
		
		Optional<User> expected, result;
		
		expected = MocksUtils.mockOptionalUser();
		result = userService.getUserById(1L);
		
		assertEquals(expected, result);
		assertNotNull(result);
		
		expected = null;
		result = userService.getUserById(null);
		
		assertEquals(expected, result);
		assertNull(result);
		
		doReturn(null).when(userRepository).findById(anyLong());
		
		expected = null;
		result = userService.getUserById(1L);
		
		assertEquals(expected, result);
		assertNull(result);

	}
	


}
