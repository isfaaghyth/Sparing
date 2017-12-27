package kelompok.app.sparing.model;

public class Team{
	private int id;
	private String name;
	private String status;
	private String createdAt;
	private String updatedAt;

	public String getCreatedAt(){
		return createdAt;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getStatus(){
		return status;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	@Override
 	public String toString(){
		return 
			"Team{" + 
			"createdAt = '" + createdAt + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",status = '" + status + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}
