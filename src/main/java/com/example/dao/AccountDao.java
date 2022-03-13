package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// @Mapper
// public interface AccountDao {
//     @Select("select * from account where id = #{id}")
//     public Account getById(Integer id);
// }



// mybatis-plus
@Mapper
public interface AccountDao extends BaseMapper<Account> {

}