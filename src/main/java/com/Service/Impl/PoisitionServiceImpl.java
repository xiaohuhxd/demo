package com.Service.Impl;


import com.Dao.HumanDao;

import com.Entity.HumanPoistion;
import com.Service.PoistionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PoisitionServiceImpl implements PoistionService {
    @Autowired
    HumanDao humanDao;
    @Override
    public HumanPoistion selectpoistion() {
        return humanDao.selectpoistion();
    }
}
