package io.sivatest.mybatis.springbootmybatis.mappers;

import io.sivatest.mybatis.springbootmybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper {

    String findAll = "SELECT * FROM users";


    @Select(findAll)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "email", column = "email_address")
    })
    List<User> findAll();

    @Insert("Insert into users(id,first_name,last_name,email_address) values (#{firstName},#{lastName},#{email})")
    void insert (User user);

    @Update("Update users set first_name = #{firstName},last_name= #{lastName},email_address= #{email} WHERE id = #{id}")
    void update (User user);

    @Delete("Delete from users WHERE id = #{id}")
    void delete (int id);




}
