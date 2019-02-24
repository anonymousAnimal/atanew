package com.ata.bean;

public class RouteBean {
	private String routeID;
	private String source;
	private String destination;
	private int distance;
	private int travelduration;

	public RouteBean() {
		super();
	}

	public RouteBean(String routeID, String source, String destination,
			int distance, int travelduration) {
		super();
		this.routeID = routeID;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.travelduration = travelduration;
	}

	public String getRouteID() {
		return routeID;
	}

	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getTravelduration() {
		return travelduration;
	}

	public void setTravelduration(int travelduration) {
		this.travelduration = travelduration;
	}
}
