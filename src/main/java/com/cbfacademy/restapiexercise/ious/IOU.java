package com.cbfacademy.restapiexercise.ious;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ious")

public class IOU {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID id;
    private String borrower;
    private String lender;
    private BigDecimal amount;
    private Instant dateTime;

    //default constructor
    // public IOU() {
    //     this(null, null, BigDecimal.ZERO, Instant.now());
    //   }
    


    public IOU(UUID id, String borrower, String lender, BigDecimal amount, Instant dateTime) {
        this.id = id;
        this.borrower = borrower;
        this.lender = lender;
        this.amount = amount;
        this.dateTime = dateTime;
    }
    
    public UUID getId() {
        //unique identifier for the IOU
        return id;
    }
    
    
    public String getBorrower() {
        return borrower;
        //name of the borrower.
    }

    public void setBorrower(String borrower){
        this.borrower = borrower;
    }
        
    
    public String getLender() {
        return lender;
        //name of lender

    }

    public void setLender( String lender){
        this.lender = lender;
    }
    
    public BigDecimal getAmount() {
        //amount covered by IOU
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    
    public Instant getdateTime() {
        //date and time of IOU being issued
        return dateTime;
    }

    public void setDateTime(Instant dateTime){
        this.dateTime = dateTime;
    }

}
