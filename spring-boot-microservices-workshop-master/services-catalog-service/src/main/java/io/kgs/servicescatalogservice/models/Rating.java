package io.javabrains.servicescatalogservice.models;

public class Rating {

    private String serviceId;
    private int rating;

    public Rating() {

    }

    public Rating(String serviceId, int rating) {
        this.serviceId = serviceId;
        this.rating = rating;
    }

    public String getserviceId() {
        return serviceId;
    }

    public void setserviceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
