package com.antonyrain.backserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue
    private Integer resultId;

    private String model;
    private String year;
    private String price;
    private String url;
    private Long telegramUserId;

    public Result() {};

    Result(
        String model,
        String year,
        String price,
        String url,
        Long telegramUserId
    ) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.url = url;
        this.telegramUserId = telegramUserId;
    };

    public Integer getResultId() {
        return resultId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getTelegramUserId() {
        return telegramUserId;
    }

    public void setTelegramUserId(Long telegramUserId) {
        this.telegramUserId = telegramUserId;
    }
    
}
