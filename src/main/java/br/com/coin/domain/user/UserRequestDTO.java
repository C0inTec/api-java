package br.com.coin.domain.user;



import java.util.Date;

public record UserRequestDTO(String first_name, String last_name , String email, String password, String cpf, String phone, Date date_of_birthday) {
}
