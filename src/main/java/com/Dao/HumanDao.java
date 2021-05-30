package com.Dao;

import com.Entity.HumanPoistion;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HumanDao {
    public HumanPoistion selectpoistion();
}
