package com.keyin.entities;

import javax.persistence.*;

@Entity
public class Platform {

    @Id
    @SequenceGenerator(name = "platform_sequence", sequenceName = "platform_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "platform_sequence")
    private Long id;

    private String platformName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public String toString() {
        return "Platform{" +
                "id=" + id +
                ", platformName='" + platformName + '\'' +
                '}';
    }
}
