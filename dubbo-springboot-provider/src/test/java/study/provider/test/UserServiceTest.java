package study.provider.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import study.provider.ProviderApp;
import study.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ProviderApp.class })
public class UserServiceTest {
	@Autowired
	private IUserService userService;

	@Test
	public void test() {
		System.out.println(userService + " - " + userService.getClass());
		userService.getAllUsers().forEach(u -> System.out.println(u));
	}
	
}
