package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import interfaces.CRUD;

public class ClientDB extends Client implements CRUD {
	private static Connection dbConnect;
	
	public ClientDB(int id, String lastName, String firstName, String adress, String postal, String city, String phoneNumber) {
		super(id, lastName, firstName, adress, postal, city, phoneNumber);
	}
	
	public ClientDB(int id) {
		super(id, "", "", "", "", "", "");
	}
	
	public static void setConnection(Connection nouvDbConnect) {
		dbConnect = nouvDbConnect;
	}

	@Override
	public void create() {
		try {
            CallableStatement cstmt = dbConnect.prepareCall("call CREATECLIENT(?, ?, ?, ?, ?, ?)");
			applyQuery(cstmt, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void read() {		
		try {
            CallableStatement cstmt = dbConnect.prepareCall("call READCLIENT(?)");
            cstmt.setInt(1, id);
            ResultSet rs = cstmt.executeQuery();
            if(rs.next()) {
                this.lastName = rs.getString("lastName");
                this.firstName = rs.getString("firstName");
                this.adress = rs.getString("adress");
                this.postal = rs.getString("postal");
                this.city = rs.getString("city");
                this.phoneNumber = rs.getString("phoneNumber");
            }
            rs.close();
            cstmt.close();
        } catch (Exception e) {
        	e.printStackTrace();
        } 
	}

	@Override
	public void update() {
		try {
			CallableStatement cstmt = dbConnect.prepareCall("call UPDATECLIENT(?, ?, ?, ?, ?, ?, ?)");
			cstmt.setInt(1, id);
			applyQuery(cstmt, 2);
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		try {
			CallableStatement cstmt = dbConnect.prepareCall("call DELETECLIENT(?)");
			cstmt.setInt(1, id);
			cstmt.executeQuery();
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void applyQuery(CallableStatement cstmt, int pos) throws Exception {
        cstmt.setString(pos++, lastName);
        cstmt.setString(pos++, firstName);
        cstmt.setString(pos++, adress);
        cstmt.setString(pos++, postal);
        cstmt.setString(pos++, city);
        cstmt.setString(pos, phoneNumber);
        cstmt.executeQuery();
        cstmt.close();
	}

}