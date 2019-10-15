package kr.co.itcen.springcontainer.soundsystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.itcen.springcontainer.config.soundsystem.SoundSystemConfig;

/**
 *  Auto Configuration - Java Config
 *  Scanning Component  ( @Component, @Named, @Autowired, @Inject )
 *                        @Service
 *                        @Controller
 *                        @Repository
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SoundSystemConfig.class})
public class SoundSystemJavaConfigTest {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	@Qualifier("highSchoolRapper3Final")
	private CompactDisc cd;

	@Autowired
	private CDPlayer cdPlayer;

	@Test
	public void testCDNull() {
		assertNotNull(cd);
	}

	@Test
	public void testCDPlayerNull() {
		assertNotNull(cdPlayer);
	}
	
	@Test
	public void testPlay() {
		cdPlayer.play();
		assertEquals("Playing 지구멸망 by 양승호", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}

}
