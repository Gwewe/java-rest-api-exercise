package com.cbfacademy.restapiexercise.ious;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class IOU {
    private final UUID id;
    private final String borrower;
    private final String lender;
    private BigDecimal amount;
    private Instant dateTime;


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
        
    
    public String getLender() {
        return lender;
        //name of lender

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
