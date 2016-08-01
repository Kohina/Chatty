package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import src.User;

public class UserAttributesTest {

	User user = new User();
	
	@Before
	public void setUp() throws Exception {
		user.changeUsername("ValidName");
	}

	@After
	public void tearDown() throws Exception {
	}

	/* 
	 * Usernames are only allowed to contain alphanumericals and _
	 */
	@Test
	public void whenUsernameChangedHaveIllegalCharsThenFalseReturnedAndUsernameUnchanged() {
		String nameBeforeChange = user.getUsername();
		assertFalse(user.changeUsername("Inv@l*dName"));
		assertEquals(nameBeforeChange, user.getUsername());
	}

	/* Usernames should allow _ to be a part of the name */
	@Test
	public void whenValidUsernameChangeContainUnderscoreThenReturnTrueAndChangeName(){
		assertTrue(user.changeUsername("_Valid_Name_"));
		assertEquals("_Valid_Name_", user.getUsername());
	}
}
