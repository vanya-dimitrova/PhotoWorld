package com.example.user.photoworld.model;

import com.example.user.photoworld.model.Photo.Category;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class PhotoWorld implements Serializable{
	
	private static PhotoWorld photoWorld;
	private String currentUser;

	private HashMap<Category, TreeSet<Photo>> photos;
	private HashMap<String, User> users;
	
	private PhotoWorld() {
		this.setCategories();
		this.users = new HashMap<String, User>();
	}
	
	public static PhotoWorld getPhotoWorld() {
		if (photoWorld == null) {
			return photoWorld = new PhotoWorld();
		}
		return photoWorld;
	}

	public String getCurrentUser() {
		return currentUser;
	}


	private void setCategories() {
		this.photos = new HashMap<Category, TreeSet<Photo>>();
		this.photos.put(Category.ABSTRACT, new TreeSet<Photo>());
		this.photos.put(Category.ANIMAL, new TreeSet<Photo>());
		this.photos.put(Category.BLACK_AND_WHITE, new TreeSet<Photo>());
		this.photos.put(Category.FLOWER, new TreeSet<Photo>());
		this.photos.put(Category.FOOD, new TreeSet<Photo>());
		this.photos.put(Category.MACRO, new TreeSet<Photo>());
		this.photos.put(Category.NATURE, new TreeSet<Photo>());
		this.photos.put(Category.PATTERN, new TreeSet<Photo>());
		this.photos.put(Category.PEOPLE, new TreeSet<Photo>());
		this.photos.put(Category.PORTRAIT, new TreeSet<Photo>());
		this.photos.put(Category.SPORT, new TreeSet<Photo>());
		this.photos.put(Category.VINTAGE, new TreeSet<Photo>());
	}

	public HashMap<Category, TreeSet<Photo>> getPhotos() {
		return (HashMap<Category, TreeSet<Photo>>) Collections.unmodifiableMap(this.photos);
	}

	//done
	public void register(User user) {
		users.put(user.getUserName(), user);
		currentUser = user.getUserName();
	}
	//done
	public boolean checkUser(String userName) {
		if (!this.users.isEmpty() && this.users.containsKey(userName)) {
			return true;
		}
		return false;
	}
	//done
	public boolean checkEmail(String email) {
		if (!this.users.isEmpty()) {
			for (User user : this.users.values()) {
				if (user.getEmail().equals(email)) {
					return true;
				}
			}
		} 
		return false;
	}
	//done
	public boolean checkPassword(String userName, String password) {
		if (!this.users.isEmpty() && this.users.containsKey(userName)) {
			if (this.users.get(userName).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public void login(String username) {
		currentUser = username;
	}
	
	private void logOut() {
		//TODO move to home page
	}

	private void showOnePhotoPerCategory() {
		for (Iterator<TreeSet<Photo>> itCategory = photos.values().iterator(); itCategory.hasNext();) {
			Iterator<Photo> itPhoto = itCategory.next().iterator();
			if (itPhoto != null && itPhoto.hasNext()) {
				//TODO appropriate visualization code
				//TODO show category name under photo
			} else {
				//TODO show some icon which says "empty category"
			}
		}
	}

	private void updatePhotos(User photographer, String category) { //TODO remove user param
		if(photographer.isPhotographer){
			if (!this.photos.get(category).contains(photographer.offerPhoto())) {
				this.photos.get(category).add(this.users.get(photographer).uploadPhoto());
				this.notifyUsers();		
		    } else {
		    	System.out.println("Photo already exists!");
		    }
		} else {
			System.out.println("Unauthorised operation!");
		}
	}		
	
	private void notifyUsers(){
		for(User user: this.users.values()){
			this.sendEmail(user.getEmail());
		}
	}
	
	private void sendEmail(String email){
		//TODO send email code
	}																								
																						
	private void showPhotographerPhotos(String username) {
		boolean containsPhotographer = false;
		for (Iterator<TreeSet<Photo>> itCategory = photos.values().iterator(); itCategory.hasNext();) {
			Iterator<Photo> itPhotos = itCategory.next().iterator();
			if (itPhotos != null && itPhotos.hasNext()) {
				Photo photo = itPhotos.next();
				if (photo.getPhotographer().equals(username)) {
					//TODO appropriate visualization code
					containsPhotographer = true;
				}
			}
		}
		if (!containsPhotographer) {
			System.out.println("Not found!");
		}
	}
	
	private void showCategoryByDate(String category) {
		if (this.photos.get(category) != null) {
			for (Photo photo : this.photos.get(category)) {
				//TODO appropriate visualization code
			}
		} else {
			System.out.println("Sorry! This category is empty!");
		}
	}
	
	private void showPhoto() {
		//TODO appropriate visualization code
	}
	
	private void showCategoryByRating(String category) { 												
		TreeSet<Photo> byRating = new TreeSet<>(new Comparator<Photo>() {
			@Override
			public int compare(Photo o1, Photo o2) {
				return o1.getRating() - o2.getRating();
			}
		});
		if (this.photos.get(category) != null) {
			for (Iterator<Photo> itPhoto = this.photos.get(category).iterator(); itPhoto.hasNext();) {
				Photo photoCopy = itPhoto.next();
				byRating.add(photoCopy);
			} //
			for (Photo photo : byRating) {
				//TODO appropriate visualization code
			}
		} else {
			System.out.println("Sorry! This category is empty!");
		}
	}
	
	private void showCategoryByPopularity(String category) { 												
		TreeSet<Photo> byPopularity = new TreeSet<>(new Comparator<Photo>() {
			@Override
			public int compare(Photo o1, Photo o2) {
				return o1.getPopularity() - o2.getPopularity();
			}
		});
		if (this.photos.get(category) != null) {
			for (Iterator<Photo> itPhoto = this.photos.get(category).iterator(); itPhoto.hasNext();) {
				Photo photoCopy = itPhoto.next();
				byPopularity.add(photoCopy);
			}
			for (Photo photo : byPopularity) {
				//TODO appropriate visualization code
			}
		} else {
			System.out.println("Sorry! This category is empty!");
		}
	}
	
	private void removePhoto(Category category, Photo photo) {
		photos.get(category).remove(photo);
	}
	
	private void setPhotoAs() {
		// TODO check for better collection to get a picture depending on app building
	}

	private void sharePhoto() {
		// TODO check for better collection to get a picture depending on app building
	}
	
	private void downloadPhoto() {
		// TODO check for better collection to get a picture depending on app building
	}

	private void ratePhoto() {
		// TODO check for better collection to get a picture depending on app building
	}
	
	private void commentOnPhoto(String text){
		// TODO check for better collection to get a picture depending on app building
	}
	
	private void rateComment() {
		// TODO check for better collection to get a comment depending on app building
	}


	// TODO remove this method if necessary
	public void addPhoto(Category category, Photo photo){
		this.photos.get(category).add(photo);
	}
}