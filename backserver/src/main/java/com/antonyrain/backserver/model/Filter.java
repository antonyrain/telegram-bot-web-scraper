package com.antonyrain.backserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Table(name = "filters")
public class Filter {
    @Id
    @GeneratedValue()
    private Long filterId;

    private Long telegramUserId;
    private String searchString;

    public Filter() {};

    Filter(
        Long telegramUserId,
        String searchString
    ) {
        this.telegramUserId = telegramUserId;
        this.searchString = searchString;
    };

    // Getters

    public Long getfilterId() {
        return this.filterId;
    }

    public Long getTelegarmUserId() {
        return this.telegramUserId;
    }

    public String getSearchString() {
        return this.searchString;
    }

    // Setters

    public void setTelegramUserId(Long telegramUserId) {
        this.telegramUserId = telegramUserId;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}