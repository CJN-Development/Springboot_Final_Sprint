package com.keyin.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Genre {
    @Id
    @SequenceGenerator(name = "genre_sequence", sequenceName = "genre_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "genre_sequence")
    private long id;
    private String genreName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genreName='" + genreName + '\'' +
                '}';
}}
