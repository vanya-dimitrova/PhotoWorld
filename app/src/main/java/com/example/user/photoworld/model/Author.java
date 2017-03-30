package com.example.user.photoworld.model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Stack;

public class Author extends User {

    private HashSet<Photo> photos;
    private Stack<Photo> photographerPhotos;
    private int uploads;

    public Author(String name, String username, String email, String password) {
        super(name, username, email, password);
        this.role = Role.AUTHOR;
        this.uploads = 0;
    }

    public void addPhoto(Photo photo){
        this.photographerPhotos.add(photo);
    }


    public Photo uploadPhoto() {
        this.photographerPhotos.peek().uploadDate = Calendar.getInstance().getTime();
        return this.photographerPhotos.pop();
    }

    public Photo offerPhoto() {
        return this.photographerPhotos.peek();
    }

    Photo removePhoto(Photo photo) {
        photos.remove(photo);
        return photo;
    }

    public int getUploads() {
        return uploads;
    }

    public void setUploads(int uploads) {
        this.uploads = uploads;
    }
}
