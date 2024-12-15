package br.com.coin.domain.user;


import java.util.Date;

public record UserResponseDTO(Long id, String first_name, String last_name , String email, String password, String cpf, String phone, Date date_of_birthday) {

    public UserResponseDTO(User user){
        this(user.getId(),user.getFirst_name(), user.getLast_name(), user.getEmail(), user.getPassword(),user.getCpf(), user.getPhone(), user.getDate_of_birthday() );
    }
}
