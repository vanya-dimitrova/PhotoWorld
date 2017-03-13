package com.example.user.photoworld.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Stack;

public class User {

	private final String username;
	private final String email;

	private String password;
	private String verifiedPassword;
	private String name;
	private String address;
	private int age;
	protected boolean isPhotographer;
	private boolean beNotified;
	private File profilePicture;
	private ArrayList<Comment> madeComments;
	private HashSet<Photo> photos;
	private Stack<Photo> photographerPhotos;
	
	// TODO remove name
	public User(String name, String username, String email, String password, boolean isPhotographer) {
		if (username == null || username.isEmpty() || username.length() < 3) {
			throw new InputMismatchException("Please, enter a valid username!");
		}
		if (!validatePassword(password) || !validatePassword(verifiedPassword) || password.length() < 5) {
			throw new InputMismatchException("The password must be at lest 5 symbols!");
		}
		if (!confirmPassword(password, verifiedPassword)) {
			throw new InputMismatchException("The passwords don't match!");
		}
		this.username = username;
		this.password = password;
		this.email = email; // TODO validation
		this.isPhotographer = isPhotographer;
		setName(name);
		beNotified = true;
		madeComments = new ArrayList<>();
	}
	
	public String getEmail(){
		return this.email;
	}
	
	private void setName(String name) {
		if (name == null || name.isEmpty() || name.length() < 2) {
			throw new InputMismatchException("Please, enter a valid name!");
		}
		this.name = name;
	}

	private void setAge(int age) {
		if (age > 0 && age <= 100) {
			this.age = age;
		}
	}

	//TODO remove verifiedPassword field
	private boolean validatePassword(String password) {
		if (password != null && !password.isEmpty() && password.length() < 5) {
			this.password = password;
			return true;
		}
		return false;
	}
	
	private boolean confirmPassword(String pass1, String pass2) {
		if (!pass1.equals(pass2)) {
			return false;
		}
		return true;
	}

	private void changeAddress(String address) {
		this.address = address;
	}

	private void changeProfilePicture(File profilePicture) {
		this.profilePicture = profilePicture;
	}

	private void beNotified(boolean beNotified) {
		this.beNotified = beNotified;
	}

	private void changePassword(String oldPassword, String newPassword, String verifiedNewPassword) {
		if (!confirmPassword(this.password, oldPassword)) {
			System.out.println("This password and the current one don't match!");
			return;
		}
		if (!confirmPassword(newPassword, verifiedNewPassword)) {
			System.out.println("The new passwords don't match!");
			return;
		}
		this.password = newPassword;
	}

	Photo uploadPhoto() {
		this.photographerPhotos.peek().uploadDate = Calendar.getInstance().getTime();
		return this.photographerPhotos.pop();
	}
	
	Photo offerPhoto() {
		return this.photographerPhotos.peek();
	}

	Photo removePhoto(Photo photo) {
		photos.remove(photo);
		return photo;
	}
	
	private void changeNotificationOption() {
		if (beNotified) {
			this.beNotified = false;
			return;
		} 
		beNotified = true;
	}

	private void showUserInfo() {
		// TODO
		//check if address value is null
	}
	
	public String getUserName() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}
}
