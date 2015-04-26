import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.home.cron.CronJobParser;
import com.home.cron.CronLogParser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class CronTest {
	
	@Autowired
	CronJobParser cronJobParser;
	
	@Autowired
	CronLogParser cronLogParser;

//	@Test
	public void test() {
		System.out.println(cronJobParser.getCronJob("#comment ", "00 09-18 * * 1-5 /home/ramesh/bin/check-db-status", 1));
		System.out.println(cronJobParser.getCronJob("#comment ", "30 08 10 06 * /home/ramesh/full-backup", 1));
		System.out.println(cronJobParser.getCronJob("#comment ", "00 11,16 * * * /home/ramesh/bin/incremental-backup", 1));
		System.out.println(cronJobParser.getCronJob("#comment ", "00 09-18 * * * /home/ramesh/bin/check-db-status", 1));
		System.out.println(cronJobParser.getCronJob("#comment ", "*/10 * * * * /home/ramesh/check-disk-space", 1));
		System.out.println(cronJobParser.getCronJob("#comment ", "@monthly /home/sathiya/monthly-backup", 1));
		System.out.println(cronJobParser.getCronJob("#comment ", "@yearly /home/ramesh/centos/bin/annual-maintenance", 1));
	}
	
	@Test
	public void testFile() throws FileNotFoundException {
		File file = new File("cron.txt");
		System.out.println(cronJobParser.parse(new FileInputStream(file), 1));
	}
	
//	@Test
	public void testTwoCrons() throws FileNotFoundException {
		System.out.println(cronJobParser.isEqual("40 * * * * /usr/bin/php test.php >> file.txt", "40 * * * * /usr/bin/php test1.php >> file.txt"));
		System.out.println(cronJobParser.isEqual("40 * * * * /usr/bin/php test.php >> file.txt", "   40 * * * * /usr/bin/php test.php >> file.txt"));
	}
	
//	@Test
	public void testCronLog() throws FileNotFoundException {
		File file = new File("cron_log.txt");
		System.out.println(cronLogParser.getCronLogs(new FileInputStream(file), 1));
	}
	
	@Test
	public void testCronTask() throws FileNotFoundException {
		new ClassPathXmlApplicationContext("spring-context.xml");
	}

}
