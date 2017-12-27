package kelompok.app.sparing.model;

public class User {
	private int id;
	private String name;
	private String createdAt;
	private String phone_number;
	private String sportId;
	private String firebase_token;
	private String avatar;
	private String email;
	private String updatedAt;

	public String getAvatar() {
		return avatar;
	}

	public String getSportId() {
		return sportId;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getName(){
		return name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public int getId(){
		return id;
	}

	public String getFirebase_token() {
		return firebase_token;
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
			",phone_number = '" + phone_number + '\'' +
			",sportId = '" + sportId + '\'' +
			",id = '" + id + '\'' + 
			",firebase_token = '" + firebase_token + '\'' +
			",email = '" + email + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}
