package kr.co.itcen.springcontainer.videosystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 *  Explicit(명시적) Configuration - XML Config
 *  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/videosystem/VideoSystemConfig.xml"})
public class VideoSystemXmlConfigTest {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	DigitalVideoDisc dvd1;
	
	@Test
	public void testDVD1Null() {
		assertNotNull(dvd1);
	}
}
