package github.nooblong.dao;

import github.nooblong.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username, birthday, sex, address) VALUES (#{username},#{birthday},#{sex},#{address})")
    void saveUser(User user);

    @Delete("delete from user where id = #{id}")
    void deleteUser(int id);
}
