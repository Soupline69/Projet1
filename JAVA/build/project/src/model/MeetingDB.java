package model;

import java.sql.CallableStatement;
import java.sql.Connection;

import interfaces.CRUD;

public class MeetingDB extends Meeting implements CRUD {
	private static Connection dbConnect;
	
	public MeetingDB(int id, String date, String time, String client, String description, int fkClient) {
		super(id, date, time, client, description, fkClient);
	}
	
	public MeetingDB(int id) {
		super(id, "", "", "", "", -1);
	}
	
	public static void setConnection(Connection nouvDbConnect) {
		dbConnect = nouvDbConnect;
	}

	@Override
	public void create() {
		try {
            CallableStatement cstmt = dbConnect.prepareCall("call CREATEMEETING(?, ?, ?, ?, ?)");
			applyQuery(cstmt, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void read() {
		
	}

	@Override
	public void update() {
		try {
			CallableStatement cstmt = dbConnect.prepareCall("call UPDATEMEETING(?, ?, ?, ?, ?, ?)");
			cstmt.setInt(1, id);
			applyQuery(cstmt, 2);
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private void applyQuery(CallableStatement cstmt, int pos) throws Exception {
        cstmt.setString(pos++, date);
        cstmt.setString(pos++, time);
        cstmt.setString(pos++, client);
        cstmt.setString(pos++, description);
        cstmt.setInt(pos, fkClient);
        cstmt.executeQuery();
        cstmt.close();
	}

	@Override
	public void delete() {
		try {
			CallableStatement cstmt = dbConnect.prepareCall("call DELETEMEETING(?)");
			cstmt.setInt(1, id);
			cstmt.executeQuery();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
