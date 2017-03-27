package com.example.user.photoworld.model;

import com.example.user.photoworld.model.Photo.Category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class PhotoWorld implements Serializable{
	
	private static PhotoWorld photoWorld;
	public static String currentUser;

	public HashMap<Category, ArrayList<Photo>> photos;
	private static HashMap<String, User> users;
	
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
		this.photos = new HashMap<Category, ArrayList<Photo>>();
		this.photos.put(Category.ABSTRACT, new ArrayList<Photo>());
		this.photos.put(Category.ANIMAL,new ArrayList<Photo>());
		this.photos.put(Category.BLACK_AND_WHITE, new ArrayList<Photo>());
		this.photos.put(Category.FLOWER, new ArrayList<Photo>());
		this.photos.put(Category.FOOD, new ArrayList<Photo>());
		this.photos.put(Category.MACRO, new ArrayList<Photo>());
		this.photos.put(Category.NATURE, new ArrayList<Photo>());
		this.photos.put(Category.PATTERN, new ArrayList<Photo>());
		this.photos.put(Category.PEOPLE, new ArrayList<Photo>());
		this.photos.put(Category.PORTRAIT, new ArrayList<Photo>());
		this.photos.put(Category.SPORT, new ArrayList<Photo>());
		this.photos.put(Category.VINTAGE, new ArrayList<Photo>());
	}

	// can't use it in category activity
//	public HashMap<Category, ArrayList<Photo>> getPhotos() {
//		return (HashMap<Category, ArrayList<Photo>>) Collections.unmodifiableMap(this.photos);
//	}

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
		for (Iterator<ArrayList<Photo>> itCategory = photos.values().iterator(); itCategory.hasNext();) {
			Iterator<Photo> itPhoto = itCategory.next().iterator();
			if (itPhoto != null && itPhoto.hasNext()) {
				//TODO appropriate visualization code
				//TODO show category name under photo
			} else {
				//TODO show some icon which says "empty category"
			}
		}
	}

	private void updatePhotos(Author author, String category) {
			if (!this.photos.get(category).contains(author.offerPhoto())) {
				this.photos.get(category).add(((Author)this.users.get(author)).uploadPhoto());
				this.notifyUsers();		
		    } else {
		    	System.out.println("Photo already exists!");
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
																						
//	private void showPhotographerPhotos(String username) {
//		boolean containsPhotographer = false;
//		for (Iterator<TreeSet<Photo>> itCategory = photos.values().iterator(); itCategory.hasNext();) {
//			Iterator<Photo> itPhotos = itCategory.next().iterator();
//			if (itPhotos != null && itPhotos.hasNext()) {
//				Photo photo = itPhotos.next();
//				if (photo.getPhotographer().equals(username)) {
//					//TODO appropriate visualization code
//					containsPhotographer = true;
//				}
//			}
//		}
//		if (!containsPhotographer) {
//			System.out.println("Not found!");
//		}
//	}
	
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