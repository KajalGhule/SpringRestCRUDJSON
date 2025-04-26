package com.example.entities;

public class Product {
    
	private int id;
	private String title;
	private String category;
    private String description;
    private String imageUrl;
    private double unitPrice;
    private int quantity;
    private int Likes;
	
    public Product() {
		super();
	}

	public Product(int id, String title, String category, String description, String imageUrl, double unitPrice,
			int quantity, int likes) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.description = description;
		this.imageUrl = imageUrl;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		Likes = likes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getLikes() {
		return Likes;
	}

	public void setLikes(int likes) {
		Likes = likes;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", category=" + category + ", description=" + description
				+ ", imageUrl=" + imageUrl + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", Likes=" + Likes
				+ "]";
	}
    
    
    
}
