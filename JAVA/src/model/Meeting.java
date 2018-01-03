package model;

public class Meeting {
	protected int id;
	protected String date;
	protected String time;
	protected String client;
	protected String description;
	protected int fkClient;

	public Meeting(int id, String date, String time, String client, String description, int fkClient) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.client = client;
		this.description = description;
		this.fkClient = fkClient;
	}

	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getClient() {
		return client;
	}

	public String getDescription() {
		return description.replace(";", " ");
	}
	
	public int getFkClient() {
		return fkClient;
	}

}