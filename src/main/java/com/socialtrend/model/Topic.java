package com.socialtrend.model;

public class Topic {
	
	private String name;
	private String title;
	private String description;
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPreviewImageUrl() {
		return previewImageUrl;
	}

	public void setPreviewImageUrl(String previewImageUrl) {
		this.previewImageUrl = previewImageUrl;
	}

	public String getShowContentUrl() {
		return showContentUrl;
	}

	public void setShowContentUrl(String showContentUrl) {
		this.showContentUrl = showContentUrl;
	}

	private String previewImageUrl;
	private String showContentUrl;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
