package com.example.user.photoworld.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;

public class Comment implements Comparable<Comment>, Serializable{

	private final String commenterUsername;
	private final Date commentDate;
	private String commentText;
	private int numberOfLikes;

	public Comment(String commenterUsername, String text) {
		// TODO check if we need validation on commenter user name
		this.commenterUsername = commenterUsername;
		if(commentText != null && !commentText.isEmpty()){
			this.commentText = text;
		}
		else{
			throw new InputMismatchException("Enter some text!");
		}
		this.commentDate = Calendar.getInstance().getTime();
		this.numberOfLikes = 0;
	}

	public void setText(String text) {
		// TODO check how to validate text for app
		this.commentText = text;
	}

	@Override
	public int compareTo(Comment o) {
		return o.commentDate.compareTo(this.commentDate);
	}
}

