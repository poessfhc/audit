package com.edu.audit;

import com.edu.audit.authority.dao.SysMenuMapper;
import com.edu.audit.authority.dao.SysRoleMapper;
import com.edu.audit.authority.domain.SysRoleMenu;
import com.edu.audit.authority.domain.SysUserRole;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class AuditApplicationTests {
//    @Autowired
//    JavaMailSenderImpl javaMailSender;
//    @Autowired
//    SysMenuMapper sysMenuMapper;
//    @Autowired
//    SysRoleMapper sysRoleMapper;
//
//    @Test
//    void contextLoads() {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("527687529@qq.com");
//        message.setTo("350660213@qq.com");
//        message.setSubject("测试");
//        message.setText("邮箱测试");
//        javaMailSender.send(message);
//    }
//
//    @Test
//    void addTest() {
//        SysUserRole sysUserRole = new SysUserRole();
//        sysUserRole.setRoleId("b");
//        sysUserRole.setUserId("a");
//        SysRoleMenu sysRoleMenu = new SysRoleMenu();
//        sysRoleMenu.setRoleId("a");AS
//        sysRoleMenu.setMenuId("b");
//        sysRoleMapper.addRole(sysUserRole);
//        sysMenuMapper.addMenu(sysRoleMenu);
//    }
//
//    @Test
//    void deleteTest(){
//        SysUserRole sysUserRole = new SysUserRole();
//        sysUserRole.setRoleId("b");
//        sysUserRole.setUserId("a");
//        SysRoleMenu sysRoleMenu = new SysRoleMenu();
//        sysRoleMenu.setRoleId("a");
//        sysRoleMenu.setMenuId("b");
//        sysRoleMapper.deleteRole(sysUserRole);
//        sysMenuMapper.deleteMenu(sysRoleMenu);
//    }

}
