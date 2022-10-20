package Testwing.service.abstraction;

import Testwing.dto.RegisterDTO;
import Testwing.entity.Account;

public interface AccountService {
    Account registerAccount(RegisterDTO dto);
}
