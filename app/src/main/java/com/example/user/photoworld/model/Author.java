package com.example.user.photoworld.model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Stack;

public class Author extends User {

    private HashSet<Photo> photos;
    private Stack<Photo> photographerPhotos;

    public Author(String name, String username, String email, String password) {
        super(name, username, email, password);
        this.role = Role.AUTHOR;
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
}
