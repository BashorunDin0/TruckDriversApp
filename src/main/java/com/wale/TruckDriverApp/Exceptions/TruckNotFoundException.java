package com.wale.TruckDriverApp.Exceptions;

public class TruckNotFoundException extends RuntimeException{
    public TruckNotFoundException(String message){
        super(message);
    }
}
