package com.test.TestExample;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {
	private String name;
	private int id;
	private int points;
	
	public Alien() {
		super();
		this.name = "SpiderMan";
		this.id = 100;
		this.points = 100;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "Alien [name=" + name + ", id=" + id + ", points=" + points + "]";
	}
	
}
