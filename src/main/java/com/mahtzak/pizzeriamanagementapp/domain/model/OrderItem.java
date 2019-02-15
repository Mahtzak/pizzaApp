package com.mahtzak.pizzeriamanagementapp.domain.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    @ManyToMany
    @JoinTable(name="orderitem_extras",
            joinColumns = @JoinColumn(name = "orderitem_id"),
            inverseJoinColumns = @JoinColumn(name = "extras_id"))
    private List<Extras> extrases = new LinkedList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Extras> getExtrases() {
        return extrases;
    }

    public void setExtrases(List<Extras> extrases) {
        this.extrases = extrases;
    }
}
