package com.example.basic;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.entity.Major;
import com.example.basic.repository.MajorRepository;

@SpringBootTest
class BasicApplicationTests {
	@Autowired
	MajorRepository majorRepository;

	@Test
	void ServiceCenter레파지토리테스트() {
		Major major = new Major();
		major.setName("아무거나");
		major.setEbtbDate(new Date());
		major.setMax_prsn(30);
		majorRepository.save(major);
	}

	@Test
	void Major엔티티테스트() {
		System.out.println("테스트");
	}

}
