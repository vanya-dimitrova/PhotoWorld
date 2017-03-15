package com.example.user.photoworld.model;

import com.example.user.photoworld.model.Photo.Category;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class PhotoWorld {
	
	private static PhotoWorld photoWorld;

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

	private void register(String name, String username, String email, String password, boolean isPhotographer) {
		User temp = new User(name, username, email, password, isPhotographer);
		if (this.checkUser(username)) {
			System.out.println("Sorry! This username is not available!");
			//TODO stay on the same activity
		} else if (this.checkEmail(email)) {
			System.out.println("Sorry! This email address already exists!");
			//TODO stay on the same activity		
		}
		else if (temp == null) {
			System.out.println();
			//TODO stay on the same activity
		} else {
			this.showOnePhotoPerCategory();
		}
	}
	
	private boolean checkUser(String userName) {
		if (this.users.isEmpty() || (!this.users.isEmpty() && !this.users.containsKey(userName))) {
			return false;
		}
		return true;
	}
	
	private boolean checkEmail(String email) {
		if (!this.users.isEmpty()) {
			for (User user : this.users.values()) {
				if (user.getEmail() == email) {
					return true;
				}
			}
		} 
		return false;
	}
	
	private boolean checkLogInInformation(String userName, String password) {
		if (this.users.containsKey(userName)) {
			if (this.users.get(userName).getPassword().equals(password)) {
				return false;
			}
		}
		return true;
	}
	
	private void logIn(String userName, String password) {
		if (this.checkLogInInformation(userName, password)) {
			this.showOnePhotoPerCategory();
		} else {
			System.out.println("Wrong user name or password!\nPlease try again!");
			//TODO stay on the same activity
		}
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
			} //
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
}