package com.cbfacademy.restapiexercise.ious;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class IOU {
    private final String borrower;
    private final String lender;
    private BigDecimal amount;
    private Instant dateTime;


    public IOU(String borrower, String lender, BigDecimal amount, Instant dateTime) {
        //constructor that should generate a new UUID, use the documentation to learn how to generate a random value.
        this.borrower = borrower;
        this.lender = lender;
        this.amount = amount;
        this.dateTime = dateTime;

    }

     
    final UUID id() {
        //unique identifier for the IOU
        return UUID.randomUUID();
    }
    
    
    String borrower() {
        return this.borrower;
        //name of the borrower.
    }
        
    
    String lender() {
        return this.lender;
        //name of lender

    }
    
    BigDecimal amount() {
        //amount covered by IOU
        return this.amount;
    }
    
    
    Instant dateTime() {
        //date and time of IOU being issued
        return this.dateTime;
    }

}
