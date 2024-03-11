package shoeshop.Ecommerce.Model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Products")
public class Shoe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String SKU;

    @Column
    private String name;

    @Column
    private String brandName;

    @Column
    private String mainImage;

    @ElementCollection
    private List<String> sizes;

    @Column
    private String stockStatus;

    @Column
    private String colour;

    @Column(length = 1000)
    private String description;

    @Embedded
    private Price price;   // this is a sub of shoe class and the subclass is designed in the bottom//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }
    @ElementCollection(fetch = FetchType.EAGER)
    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Embeddable
                public static class Price {
                    @Column
                    private BigDecimal amount;

                    @Column
                    private String currency;

                    // Getters and setters for amount and currency

                    public BigDecimal getAmount() {
                        return amount;
                    }

                    public void setAmount(BigDecimal amount) {
                        this.amount = amount;
                    }

                    public String getCurrency() {
                        return currency;
                    }

                    public void setCurrency(String currency) {
                        this.currency = currency;
                    }
                }

}

  
