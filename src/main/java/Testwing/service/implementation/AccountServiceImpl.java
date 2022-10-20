package Testwing.service.implementation;

import Testwing.ApplicationUserDetails;
import Testwing.dto.RegisterDTO;
import Testwing.entity.Account;
import Testwing.repository.AccountRepository;
import Testwing.service.abstraction.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> accOptional = repository.findById(username);
        System.out.println(username);
        System.out.println("sout 1 "+accOptional.get().getUsername());
        Account account = accOptional.get();
        System.out.println("coba sout " +account.getUsername());
        return new ApplicationUserDetails(account);
    }

    @Override
    public Account registerAccount(RegisterDTO dto) {

        String hashPass = passwordEncoder.encode(dto.getPassword());
        Account account = new Account(
                dto.getUsername(),
                dto.getEmail(),
                hashPass
        );
        repository.save(account);
        return account;
    }
}
