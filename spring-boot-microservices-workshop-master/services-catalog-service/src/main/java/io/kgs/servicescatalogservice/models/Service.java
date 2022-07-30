package io.javabrains.servicescatalogservice.models;

public class services {
    private String serviceId;
    private String name;
    private String description;

    public services() {

    }

    public services(String serviceId, String name, String description) {
        this.serviceId = serviceId;
        this.name = name;
        this.description = description;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
