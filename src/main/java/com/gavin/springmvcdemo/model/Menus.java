package com.gavin.springmvcdemo.model;

public class Menus {

	private int id;
	private String title;

	public Menus() {
	}

	public Menus(String title) {
		this.title = title;
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

	@Override
	public String toString() {
		return "Menus{" +
				"id=" + id +
				", title='" + title + '\'' +
				'}';
	}
}
