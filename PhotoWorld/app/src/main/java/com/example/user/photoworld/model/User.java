package com.example.user.photoworld.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable, Cloneable{

	public enum Role {USER, AUTHOR}

	private final String username;
	private final String email;

	private String password;
	private String name;
	private String address;
	private int age;
	private boolean beNotified;
	private File profilePicture;
	protected Role role;

	public User(String name, String username, String email, String password, Role role) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		beNotified = true;
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Role getRole() {
		return role;
	}

	public String getUserName() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}
	
	public String getEmail(){
		return this.email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAge(int age) {
		this.age = age;
	}

	boolean confirmPassword(String pass1, String pass2) {
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
	
	private void changeNotificationOption() {
		if (beNotified) {
			this.beNotified = false;
			return;
		} 
		beNotified = true;
	}
}
