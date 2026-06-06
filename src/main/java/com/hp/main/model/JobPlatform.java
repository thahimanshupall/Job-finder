package com.hp.main.model;



public class JobPlatform {

	private String name;
	private String description;
	private String link;
	private String icon;

	public JobPlatform(String name, String description, String link, String icon) {
		this.name = name;
		this.description = description;
		this.link = link;
		this.icon = icon;
	}

	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getLink() {
		return link;
	}
	public String getIcon() {
		return icon;
	}
}
