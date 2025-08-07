package com.example.productmanagement.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    private String pname;
    private double price;
    private String review;

    public Long getPid() { return pid; }
    public void setPid(Long pid) { this.pid = pid; }
    public String getPname() { return pname; }
    public void setPname(String pname) { this.pname = pname; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }
}
