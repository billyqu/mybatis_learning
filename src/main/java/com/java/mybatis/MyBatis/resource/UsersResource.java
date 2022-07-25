package com.java.mybatis.MyBatis.resource;

import com.java.mybatis.MyBatis.model.Users;
import com.java.mybatis.MyBatis.mapper.UsersMapper;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {
    private UsersMapper usersMapper;

    public UsersResource(UsersMapper usersMapper){
        this.usersMapper = usersMapper;
    }

    @GetMapping("/all")
    public List<Users> getAll(){
        return usersMapper.findAll();
    }

    @GetMapping("/update")
    private List<Users> update(){
        Users users = new Users();
        users.setName("John");
        users.setSalary(1000L);
        usersMapper.insert(users);
        return usersMapper.findAll();
    }

    @GetMapping("/updateUsers")
    private List<Users> updateUsers(){
        Users users = new Users();
        users.setName("John");
        users.setSalary(7000L);
        usersMapper.update(users);
        return usersMapper.findAll();
    }

    @GetMapping("/delete")
    private List<Users> delete(){
        Users users = new Users();
        users.setName("John");
        usersMapper.delete(users);
        return usersMapper.findAll();
    }
}
