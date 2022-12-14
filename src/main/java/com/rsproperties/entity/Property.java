package com.rsproperties.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Base64;
import java.util.Objects;

/**
 * Represents a property in the real state application
 *
 * @eburzlaff
 */
@Entity(name = "Property")
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "price")
    private String price;

    @Column(name = "description")
    private String description;

//    private int userId;

    @Column(name = "property_type")
    private String propertyType;

    @Column(name = "availability_type")
    private String availabilityType;

    @Column(name = "bedroom_number")
    private String bedroomNumber;

    @Column(name = "bathroom_number")
    private String bathroomNumber;

    @Column(name = "image")
    private byte[] image;

    @Transient
    private String base64Image;

    @ManyToOne
    private User user;

    /**
     * Instantiates a new Property.
     */
    public Property() {
    }

    /**
     * Instantiates a new Property.
     *
     * @param address          the address
     * @param price            the price
     * @param description      the description
     * @param user             the user
     * @param propertyType     the property type
     * @param availabilityType the availability type
     * @param bedroomNumber    the bedroom number
     * @param bathroomNumber   the bathroom number
     */
    public Property(String address, String price, String description, User user, String propertyType, String availabilityType, String bedroomNumber, String bathroomNumber, byte[] image) {
        this.address = address;
        this.price = price;
        this.description = description;
        this.user = user;
        this.propertyType = propertyType;
        this.availabilityType = availabilityType;
        this.bedroomNumber = bedroomNumber;
        this.bathroomNumber = bathroomNumber;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets property type.
     *
     * @return the property type
     */
    public String getPropertyType() {
        return propertyType;
    }

    /**
     * Sets property type.
     *
     * @param propertyType the property type
     */
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    /**
     * Gets availability type.
     *
     * @return the availability type
     */
    public String getAvailabilityType() {
        return availabilityType;
    }

    /**
     * Sets availability type.
     *
     * @param availabilityType the availability type
     */
    public void setAvailabilityType(String availabilityType) {
        this.availabilityType = availabilityType;
    }

    /**
     * Gets bedroom number.
     *
     * @return the bedroom number
     */
    public String getBedroomNumber() {
        return bedroomNumber;
    }

    /**
     * Sets bedroom number.
     *
     * @param bedroomNumber the bedroom number
     */
    public void setBedroomNumber(String bedroomNumber) {
        this.bedroomNumber = bedroomNumber;
    }

    /**
     * Gets bathroom number.
     *
     * @return the bathroom number
     */
    public String getBathroomNumber() {
        return bathroomNumber;
    }

    /**
     * Sets bathroom number.
     *
     * @param bathroomNumber the bathroom number
     */
    public void setBathroomNumber(String bathroomNumber) {
        this.bathroomNumber = bathroomNumber;
    }

    public byte[] getImage() {
        return this.image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getBase64Image() {
        base64Image = Base64.getEncoder().encodeToString(this.image);
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", availabilityType='" + availabilityType + '\'' +
                ", bedroomNumber=" + bedroomNumber +
                ", bathroomNumber='" + bathroomNumber + '\'' +
//                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return id == property.id && price == property.price && bedroomNumber == property.bedroomNumber && bathroomNumber == property.bathroomNumber && Objects.equals(address, property.address) && Objects.equals(description, property.description) && Objects.equals(propertyType, property.propertyType) && Objects.equals(availabilityType, property.availabilityType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, price, description, propertyType, availabilityType, bedroomNumber, bathroomNumber);
    }
}
