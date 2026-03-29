package model;

import java.sql.Date;

/**
 * Booking.java ─────────────────────────────────────────────────────────────
 * Model class representing a booking made by a user. Location :
 * src/main/java/model/Booking.java
 */
public class Booking {

	private int id;
	private int userId;
	private int packageId;
	private Date bookingDate;
	private int people;

	// Joined display fields (populated via SQL JOIN — not DB columns)
	private String userName;
	private String packageName;
	private String location;

	// ── Constructors ────────────────────────────────────────────────────
	public Booking() {
	}

	public Booking(int id, int userId, int packageId, Date bookingDate, int people) {
		this.id = id;
		this.userId = userId;
		this.packageId = packageId;
		this.bookingDate = bookingDate;
		this.people = people;
	}

	// ── Getters & Setters ───────────────────────────────────────────────
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String n) {
		this.packageName = n;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Booking{id=" + id + ", userId=" + userId + ", packageId=" + packageId + ", date=" + bookingDate + "}";
	}
}