package kelompok.app.sparing.model;

public class User {
	private int id;
	private String name;
	private String createdAt;
	private String phoneNumber;
	private String firebaseToken;
	private String email;
	private String updatedAt;

	public String getCreatedAt(){
		return createdAt;
	}

	public String getName(){
		return name;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public int getId(){
		return id;
	}

	public String getFirebaseToken(){
		return firebaseToken;
	}

	public String getEmail(){
		return email;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"createdAt = '" + createdAt + '\'' + 
			",name = '" + name + '\'' + 
			",phone_number = '" + phoneNumber + '\'' + 
			",id = '" + id + '\'' + 
			",firebase_token = '" + firebaseToken + '\'' + 
			",email = '" + email + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}
