package ru.yaal.examples.database.hibernate.bidirectassosiation.payment;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    private Transaction transaction;
    private String description;

    public Payment() {
    }

    public Payment(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (getId() != null && obj instanceof Payment) {
            Payment other = (Payment) obj;
            return getId().equals(other.getId());
        }
        return false;
    }
}
