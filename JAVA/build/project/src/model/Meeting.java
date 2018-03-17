package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Meeting {
	protected int id;
	protected String date;
	protected String dateFormat;
	protected String time;
	protected String client;
	protected String description;
	protected int fkClient;

	public Meeting(int id, String date, String time, String client, String description, int fkClient) {
		this.id = id;
		this.date = date;
		if(date != "") createDateFormat();
		this.time = time;
		this.client = client;
		this.description = description;
		this.fkClient = fkClient;
	}
	
	private void createDateFormat() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date = sdf.parse(this.date);
			sdf.applyPattern("dd MMM yyyy");
			this.dateFormat = sdf.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}
	
	public String getDateFormat() {
		return dateFormat;
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