package model.entity;

import java.io.Serializable;

public class Hotel implements Serializable{
	
	private String name;
	private String nameLarge;
	private String address; 
	private Place place;
	private String phone;
	private String url;
	private String email;
	
	public Hotel(String name, String nameLarge, String address, Place place, String phone, String url, String email) {
		this.name = name;
		this.nameLarge = nameLarge;
		this.address = address;
		this.place = place;
		this.phone = phone;
		this.url = url;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameLarge() {
		return nameLarge;
	}

	public void setNameLarge(String nameLarge) {
		this.nameLarge = nameLarge;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", nameLarge=" + nameLarge + ", address=" + address + ", place=" + place
				+ ", phone=" + phone + ", url=" + url + ", email=" + email + "]";
	}
}
