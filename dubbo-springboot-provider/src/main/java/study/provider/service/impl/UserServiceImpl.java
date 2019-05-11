package study.provider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;

import study.pojo.User;
import study.provider.dao.IUserDao;
import study.service.IUserService;

@Transactional
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public void addUser(User user) {
		userDao.insert(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		userDao.deleteById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.selectAll();
	}

	@Override
	public User getUserById(Integer id) {
		return userDao.selectById(id);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}
	
}
