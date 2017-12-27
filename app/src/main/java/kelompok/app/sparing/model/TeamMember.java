package kelompok.app.sparing.model;

public class TeamMember{
	private String createdAt;
	private int member;
	private int team;
	private int id;
	private String updatedAt;

	public String getCreatedAt(){
		return createdAt;
	}

	public int getMember(){
		return member;
	}

	public int getTeam(){
		return team;
	}

	public int getId(){
		return id;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	@Override
 	public String toString(){
		return 
			"TeamMember{" + 
			"createdAt = '" + createdAt + '\'' + 
			",member = '" + member + '\'' + 
			",team = '" + team + '\'' + 
			",id = '" + id + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}
