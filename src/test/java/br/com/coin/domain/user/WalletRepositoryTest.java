package br.com.coin.domain.user;

import br.com.coin.domain.data_user.Wallet;
import br.com.coin.domain.data_user.WalletRepository;
import jakarta.persistence.EntityManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@ActiveProfiles("test")
public class WalletRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("Should get User sucessfully from DB")
    void findWalletByUserId() {
        UserRequestDTO user = new UserRequestDTO("Teste","Teste","test@gmail.com","1234567","12345678900","81995008911",new Date(2000-01-01),"user");
        User createdUser = this.createUser(user);

        // Busca a Wallet pelo userId
        Wallet wallet = walletRepository.findWalletByUserId(createdUser.getId());;

        assertNotNull(createdUser);
        assertNotNull(wallet, "A Wallet deveria ter sido criada para o usuário");
        assertEquals(createdUser.getId(), wallet.getUserId(), "O userId da Wallet deve corresponder ao ID do usuário");

    }




    private User createUser(UserRequestDTO data){
        User newUser = new User(data);
        em.persist(newUser);
        em.flush();
        if(newUser.getId() != null){
            Wallet newWallet = new Wallet(newUser.getId());
            em.persist(newWallet);
            return newUser;
        }
       return null;
    }
}
