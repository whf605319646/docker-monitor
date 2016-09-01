package com.github.docker.monitor.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.docker.monitor.service.CaMonitorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MonitorServiceTest {

	@Autowired
	private CaMonitorService monitorService;
	
	@Test
	public void subcontainersTest() {
		String string = monitorService.subcontainers("9b5daece95f9782b535c1af897d89c03ed41e5ae189e7968f0226099b7c4c677");
		
		System.out.println(string);
	}
	
	@Test
	public void containersTest() {
		String containers = monitorService.containers();
		
		System.out.println(containers);
	}

	@Test
	public void listTest() {
		String list = monitorService.docker();
		System.out.println(list);
	}

	@Test
	public void infoTest() {
		String info = monitorService.containerInfo("9b5daece95f9782b535c1af897d89c03ed41e5ae189e7968f0226099b7c4c677");
		System.out.println(info);
	}
	
}
