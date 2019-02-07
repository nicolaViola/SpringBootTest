package my;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import contacts.Application;
import contacts.MyCof;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MyCof.class)
@TestPropertySource
class MyTest {
	
	@Value("${debug}")
    private String debug;

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
