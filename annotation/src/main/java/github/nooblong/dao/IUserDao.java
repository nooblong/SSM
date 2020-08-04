package github.nooblong.dao;

import github.nooblong.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    @Results( id = "userMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "birthday", property = "birthday")
    }
    )
    @Select("select * from user")
    List<User> findAll();

    @ResultMap("userMap")
    @Insert("insert into user(username, birthday, sex, address) VALUES (#{username},#{birthday},#{sex},#{address})")
    void saveUser(User user);

    @ResultMap(value = "userMap")
    @Delete("delete from user where id = #{id}")
    void deleteUser(int id);
}
