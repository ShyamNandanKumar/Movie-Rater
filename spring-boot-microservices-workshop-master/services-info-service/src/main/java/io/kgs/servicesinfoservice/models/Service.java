package io.javabrains.servicesinfoservice.models;

public class Service {
    private String serviceId;
    private String name;
    private String description;

    public Service(String serviceId, String name, String description) {
        this.serviceId = serviceId;
        this.name = name;
        this.description = description;
    }

    public String getserviceId() {
        return serviceId;
    }

    public void setserviceId(String serviceId) {
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
