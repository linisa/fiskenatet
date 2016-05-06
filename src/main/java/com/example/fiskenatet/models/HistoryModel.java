package com.example.fiskenatet.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Marcin Retek on 2016-05-04.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "history")
public class HistoryModel implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserModel owner;

    @Lob
    @Column(name = "description")
    private String description;

    private String title;

    @Column(name = "start_date")
    private Date startDate; //datum + tid?

    @Column(name = "end_date")
    private Date endDate; //datum + tid?

    @Column(name = "sold_for")
    private int soldFor;

    private String image;

    private String category;

    public HistoryModel() {
    }

    public Long getId() {
        return id;
    }

    public Long getOwner() {
        return owner.getId();
    }

    public void setOwner(UserModel owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getSoldFor() {
        return soldFor;
    }

    public void setSoldFor(int soldFor) {
        this.soldFor = soldFor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
