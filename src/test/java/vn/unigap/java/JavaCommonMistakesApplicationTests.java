package vn.unigap.java;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class JavaCommonMistakesApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void tooManyObjectCreation() {
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < 100000000; i++) {
			Integer x = 1;
//			l.add(x);
		}
	}

}
