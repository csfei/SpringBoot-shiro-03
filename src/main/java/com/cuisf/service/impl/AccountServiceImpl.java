package com.cuisf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cuisf.entity.Account;
import com.cuisf.mapper.AccountMapper;
import com.cuisf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account findByUsername(String username) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        return accountMapper.selectOne(queryWrapper);
    }
}
