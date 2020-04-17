package com.edu.audit.authority.dao;

import com.edu.audit.authority.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SysUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectAllUser();

    SysUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser getUserByUsername(String username);

    SysUser login(String username, String password);

    List<String> getRolesByName(String username);

    List<String> getPermissionsByRoleName(List<String> roleNames);
}