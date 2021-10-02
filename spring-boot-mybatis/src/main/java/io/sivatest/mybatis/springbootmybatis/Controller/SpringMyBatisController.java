package io.sivatest.mybatis.springbootmybatis.Controller;

import io.sivatest.mybatis.springbootmybatis.mappers.UserMapper;
import io.sivatest.mybatis.springbootmybatis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class SpringMyBatisController {
    private final UserMapper userMapper;

    public SpringMyBatisController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping(value = "/users", produces =MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        return userMapper.findAll();
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> create(@RequestBody User user) {
        log.debug("User received from request Body "+ user.getEmail());
        userMapper.insert(user);
        return userMapper.findAll();
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> update(@RequestBody User user) {
        log.debug("User received from request Body "+ user.getEmail());
        userMapper.update(user);
        return userMapper.findAll();
    }

    @DeleteMapping(value = "/delete/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> delete(@PathVariable int id) {
        log.debug("User received from Path variable "+ id);
        userMapper.delete(id);
        return userMapper.findAll();
    }

}
