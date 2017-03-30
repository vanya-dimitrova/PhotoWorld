package com.example.user.photoworld.model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Stack;

public class Author extends User {

    private HashSet<Photo> uploadedPhotos;
    private Stack<Photo> photographerPhotos;
    private int uploads;

    public Author(String name, String username, String email, String password, Role role) {
        super(name, username, email, password, role);
        this.uploadedPhotos = new HashSet<>();
        this.photographerPhotos = new Stack<>();
    }

    public void addPhoto(Photo photo){
        this.photographerPhotos.add(photo);
    }


    public Photo uploadPhoto() {
        this.photographerPhotos.peek().setUploadDate();
        return this.photographerPhotos.pop();
    }

    public Photo offerPhoto() {
        return this.photographerPhotos.peek();
    }

    Photo removePhoto(Photo photo) {
        uploadedPhotos.remove(photo);
        return photo;
    }

    public int getUploads() {
        return uploads;
    }

    public void setUploads(int uploads) {
        this.uploads = uploads;
    }
}
