package priv.sell.service.admin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import priv.sell.service.admin.bean.Person;

@Service
public class PersonService {

	public List<Person> listPerson() {
		// 这里就不访问数据库了
		List<Person> list = new ArrayList<>(10);
		Random random = new Random();
		for (int i = 1; i < 10; i++) {
			Person person = new Person();
			int index = random.nextInt(1000);
			person.setAddress(String.format("林园街道%s号", index));
			person.setBirthdate(new Date());
			index = random.nextInt(1000);
			person.setDisplay(String.format("学号：%s", index));
			person.setId(i);
			person.setName(String.format("测试账号%s", i));
			person.setPhone("1234431423");
			person.setRemark("1234431423");
			list.add(person);
		}
		return list;
	}

}