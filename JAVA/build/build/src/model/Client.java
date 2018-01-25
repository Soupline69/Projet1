package model;

public class Client extends Object {
	protected int id;
	protected String lastName;
	protected String firstName;
	protected String adress;
	protected String postal;
	protected String city;
	protected String phoneNumber;
	
	public Client(int id, String lastName, String firstName, String adress, String postal, String city, String phoneNumber) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.adress = adress;
		this.postal = postal;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}
	
	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getName() {
		String space = lastName.isEmpty() ? "" : " ";
		return lastName + space + firstName;
	}

	public String getAdress() {
		return adress;
	}
	
	public String getPostal() {
		return postal;
	}

	public String getCity() {
		return city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

}