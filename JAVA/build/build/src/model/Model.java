package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import myconnections.DBConnection;

public class Model {
	private Connection dbConnect;
	
	public Model() {
		dbConnect = DBConnection.getInstance().getConnection();
	}
	
	public Connection getDbConnect() {
		return dbConnect;
	}
	
	public List<Client> getClients(String search) {
		List<Client> clients = new ArrayList<>();

		try {
            CallableStatement cstmt = dbConnect.prepareCall("call GETCLIENTS(?)");
            cstmt.setString(1, search);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
            	int id = rs.getInt("id");
                String lastName = rs.getString("lastName");
                String firstName = rs.getString("firstName");
                String adress = rs.getString("adress");
                String postal = rs.getString("postal");
                String city = rs.getString("city");
                String phoneNumber = rs.getString("phoneNumber");
                clients.add(new Client(id, lastName, firstName, adress, postal, city, phoneNumber));
            }
            rs.close();
            cstmt.close();
        } catch (Exception e) {
        	e.printStackTrace();
        } 
		
		return clients;
	}
	
	public List<Meeting> getMeetings(String search) {
		List<Meeting> meetings = new ArrayList<>();

		try {
            CallableStatement cstmt = dbConnect.prepareCall("call GETMEETINGS(?)");
            cstmt.setString(1, search);
            meetings = applyQuery(cstmt);
        } catch (Exception e) {
        	e.printStackTrace();
        } 

		return meetings;
	}
	
	public List<Meeting> getClientMeetings(int clientId) {
		List<Meeting> meetings = new ArrayList<>();
		
		try {
            CallableStatement cstmt = dbConnect.prepareCall("call GETCLIENTMEETINGS(?)");
            cstmt.setInt(1, clientId);
            meetings = applyQuery(cstmt);
        } catch (Exception e) {
        	e.printStackTrace();
        } 

		return meetings;	
	}
	
	private List<Meeting> applyQuery(CallableStatement cstmt) throws Exception {
		List<Meeting> meetings = new ArrayList<>();
		
		ResultSet rs = cstmt.executeQuery();
        while (rs.next()) {
        	int id = rs.getInt("id");
            String date = rs.getString("date");
            String time = rs.getString("time");
            String client = rs.getString("client");
            String description = rs.getString("description");
            int fkClient = rs.getInt("fkClient");
            meetings.add(new Meeting(id, date, time, client, description, fkClient));
        }
        rs.close();
        cstmt.executeUpdate();
        cstmt.close();
        
        return meetings;
	}

	
}