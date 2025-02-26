package br.com.coin.exception;

public class UserFullException extends RuntimeException {

    public UserFullException() { super ("User não encontrado");}

    public UserFullException(String message) { super (message);}
}
