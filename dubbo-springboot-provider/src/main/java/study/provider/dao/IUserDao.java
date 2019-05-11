package study.provider.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import study.pojo.User;
/**
 * 这里有一个超级大坑：对于Dubbo这种项目，通常会将 pojo/service/provider/consumer分布在不同的项目中，
 * 此时如果使用 mapper.xml 配置文件的形式来进行 Dao 的具体实现，会报错，提示找不到 pojo 类，目前还没有找到理想的解决方案
 * 所以在这里完全使用注解代替。
 */
public interface IUserDao {
	@Insert(value = "insert into tbl_user (name, age) values (#{name}, #{age})")
	int insert(User user);
	
	@Select("select * from tbl_user")
	List<User> selectAll();

	@Select("select * from tbl_user where id=#{id}")
	User selectById(Integer id);

	@Update("update tbl_user set name=#{name}, age=#{age} where id=#{id}")
	int update(User user);

	@Delete("delete from tbl_user where id=#{id}")
	int deleteById(Integer id);
}
