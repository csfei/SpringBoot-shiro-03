package com.cuisf.service;

import com.cuisf.entity.Account;

public interface AccountService {

    public Account findByUsername(String username);
}
