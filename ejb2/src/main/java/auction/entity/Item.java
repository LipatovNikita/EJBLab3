package auction.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    private Long id;
    private String name;
    private int count;
    private int price;
    private boolean isClosed;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long idItem) {
        this.id = idItem;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String nameItem) {
        this.name = nameItem;
    }

    @Column(name = "count", nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int countItem) {
        this.count = countItem;
    }

    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int priceItem) {
        this.price = priceItem;
    }

    @Column(name = "is_closed")
    @Type(type = "boolean")
    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean close) {
        this.isClosed = close;
    }
}