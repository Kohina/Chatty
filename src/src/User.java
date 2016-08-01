package src;

import java.util.regex.Pattern;

public class User {

	private String username;
	
	public User(){
		
	}

	/* Changes username of user, only allow alphanumerical chars and _ */
	public boolean changeUsername(String username) {
		/* if username contain any chars that are not alphanumerical or _, discard it */
		Pattern containsIllegalChars = Pattern.compile("[^\\p{Alnum}_]");
		if(containsIllegalChars.matcher(username).find()){
			return false;
		}
		this.username = username;
		return true;
	}
	
	public String getUsername(){
		return username;
	}
}
