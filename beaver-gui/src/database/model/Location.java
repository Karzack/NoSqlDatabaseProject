package database.model;

import org.bson.types.ObjectId;

/**
 * @author Ola Dahl
 */
public class Location {
    private ObjectId id;
    private String name;
    private String currency;
    private String language;

    public Location() {}

    public Location(String name, String currency, String language) {
        this.name = name;
        this.currency = currency;
        this.language = language;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
