package br.com.coin.domain.user;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    EntityManager em;

    @Test
    @DisplayName("Should get User sucessfully from DB")
    void findByEmail() {
        String email = "test@gmail.com";
        UserRequestDTO user = new UserRequestDTO("Teste","Teste",email,"1234567","12345678900","81995008911",new Date(2000-01-01),"user");
        this.createUser(user);

        UserDetails resultadoUser = this.userRepository.findByEmail(email);

        assertThat(resultadoUser).isNotNull();

    }
    @Test
    @DisplayName("Shouldn't get User whe not exists from DB")
    void findByEmail2() {
        String email = "test@gmail.com";
        UserDetails resultadoUser = this.userRepository.findByEmail(email);
        assertThat(resultadoUser).isNull();

    }

    private User createUser(UserRequestDTO data){
        User newUser = new User(data);
        em.persist(newUser);
        return newUser;
    }
}