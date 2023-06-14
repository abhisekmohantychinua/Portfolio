package dev.abhisek.portfolio.exception;

public class NOExplicitMapping extends RuntimeException{
    public NOExplicitMapping(){
        super("No explicit mapping for this page");
    }
}
