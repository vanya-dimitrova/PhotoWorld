package com.example.user.photoworld.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeMap;

public class Photo implements Comparable<Photo>, Serializable{
	
	public enum Category {ABSTRACT, ANIMAL, BLACK_AND_WHITE, FLOWER, FOOD, MACRO, NATURE, PATTERN, PEOPLE, PORTRAIT, SPORT, VINTAGE}

	private final String photographer;
	private final int photoId;
	private Date uploadDate;
	private final Category category;
	private int rating;
	private int numberOfDownloads;
	private int numberOfShares;
	private int numberOfSetAs;
	
	public Photo(String photographer, int photoId, Category category) {
		this.photographer = photographer;
		this.photoId = photoId;
		this.category = category;
	}

	public int getPhotoId() {
		return photoId;
	}

	public String getCategory(){
		return this.category.toString();
	}

	public String getPhotographer() {
		return this.photographer;
	}

	public int getRating() {
		return this.rating;
	}

	public int getPopularity() {
		return this.numberOfDownloads + this.numberOfSetAs + this.numberOfShares;
	}

	public void setUploadDate(){
		if(this.uploadDate == null){
			this.uploadDate = Calendar.getInstance().getTime();
		}
	}

	private void showPhotoProperties() {
		//TODO
	}

	@Override
	public int compareTo(Photo o) {
		return o.uploadDate.compareTo(this.uploadDate);
	}
}
