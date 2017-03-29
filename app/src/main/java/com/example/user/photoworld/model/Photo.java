package com.example.user.photoworld.model;

import java.io.Serializable;
import java.util.Date;
import java.util.TreeMap;

public class Photo implements Comparable<Photo>, Serializable{
	
	public enum Category {ABSTRACT, ANIMAL, BLACK_AND_WHITE, FLOWER, FOOD, MACRO, NATURE, PATTERN, PEOPLE, PORTRAIT, SPORT, VINTAGE}

	private final String photographer;
	public final int photoId;
	Date uploadDate;
	private final Category category;
	private int rating;
	int numberOfDownloads;
	int numberOfShares;
	int numberOfSetAs;	
	private TreeMap<Date, Comment> comments;
	
	public Photo(String photographer, int photoId, String name, Category category) {
		this.photographer = photographer;
		this.photoId = photoId;
		this.category = category;
		this.rating = 0;
		this.comments = new TreeMap<>();
	}
	
	private void showPhotoProperties() {
		//TODO
	}
	private void showPhotoComments() {
		System.out.println(comments);
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

	@Override
	public int compareTo(Photo o) {
		return o.uploadDate.compareTo(this.uploadDate);
	}
}
