package com.ltts.projectname.model;

public class Auction {
	private int auctionId;
	private int playerId;
	private int teamId;
	private int year;
	private int amount;
	public Auction() {
		super();
	}
	public Auction(int auctionId, int playerId, int teamId, int year, int amount) {
		super();
		this.auctionId = auctionId;
		this.playerId = playerId;
		this.teamId = teamId;
		this.year = year;
		this.amount = amount;
	}
	public int getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Auction [auctionId=" + auctionId + ", playerId=" + playerId + ", teamId=" + teamId + ", year=" + year
				+ ", amount=" + amount + "]";
	}
	
}
