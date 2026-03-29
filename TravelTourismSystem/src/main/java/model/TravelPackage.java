package model;

import java.math.BigDecimal;

/**
 * TravelPackage.java
 * ───────────────────────────────────────────────────────────── Model class
 * representing a travel package offered on the site. Location :
 * src/main/java/model/TravelPackage.java
 */
public class TravelPackage {

	private int id;
	private String packageName;
	private String location;
	private BigDecimal price;
	private String duration;
	private String description;
	private String imageUrl;

	// ── Constructors ────────────────────────────────────────────────────
	public TravelPackage() {
	}

	public TravelPackage(int id, String packageName, String location, BigDecimal price, String duration,
			String description, String imageUrl) {
		this.id = id;
		this.packageName = packageName;
		this.location = location;
		this.price = price;
		this.duration = duration;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	// ── Getters & Setters ───────────────────────────────────────────────
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "TravelPackage{id=" + id + ", name='" + packageName + "', location='" + location + "', price=" + price
				+ "}";
	}
}