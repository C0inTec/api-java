package br.com.coin.exception;

public class UserNotFound extends RuntimeException {

    public UserNotFound() { super ("User não encontrado");}

    public UserNotFound(String message) { super (message);}
}
