package kr.co.itcen.springcontainer.videosystem;

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
	Avengers dvd1;

	@Autowired
	@Qualifier("ironMan")
	DigitalVideoDisc dvd2;
	
	@Autowired
	@Qualifier("avengersInfinityWar")
	DigitalVideoDisc dvd3;
	
	
	@Autowired
	@Qualifier("player1")
	DVDPlayer player1;

	@Autowired
	@Qualifier("player2")
	DVDPlayer player2;

	@Autowired
	@Qualifier("player3")
	DVDPlayer player3;

	
	
	@Test
	public void testDVD1Null() {
		assertNotNull(dvd1);
	}
	@Test
	public void testDVD2Null() {
		assertNotNull(dvd2);
	}
	@Test
	public void testDVD3Null() {
		assertNotNull(dvd3);
	}
	
	
	
	@Test
	public void testPlayer1Null() {
		assertNotNull(player1);
	}
	@Test
	public void testPlay1() {
		player1.play();
		assertEquals("Playing Movie MARVEL's Iron Man", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}

	@Test
	public void testPlayer2Null() {
		assertNotNull(player2);
	}
	@Test
	public void testPlay2() {
		player2.play();
		assertEquals("Playing Movie MARVEL's Iron Man", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}

	@Test
	public void testPlayer3Null() {
		assertNotNull(player3);
	}
	@Test
	public void testPlay3() {
		player3.play();
		assertEquals("Playing Movie MARVEL's Iron Man", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}
	
}
