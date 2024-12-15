package br.com.coin.domain.user;

import java.util.Date;

public record UpdateUser(Long id, String first_name, String last_name , String email, String password, String phone) {

}
