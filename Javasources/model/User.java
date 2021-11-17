package model;

public class User {

	private long userId;
	private String userName;
	private String city;
	private String country;

	public User() {
	}

	public User(long userId, String userName, String city, String country) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.city = city;
		this.country = country;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", city=" + city + ", country=" + country + "]";
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
