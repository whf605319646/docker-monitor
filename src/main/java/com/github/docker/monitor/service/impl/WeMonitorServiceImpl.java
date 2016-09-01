package com.github.docker.monitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.docker.monitor.service.WeMonitorService;
@Service
public class WeMonitorServiceImpl implements WeMonitorService{

	@Autowired
	private RestTemplate restTemplate;
	
	String containers = "http://9.111.141.61:4040/api/topology/containers";
	
	String hosts = "http://9.111.141.61:4040/api/topology/hosts";

	@Override
	public String hosts() {
		return restTemplate.getForObject(hosts, String.class);
	}

	@Override
	public String containers() {
		return restTemplate.getForObject(containers, String.class);
	}

	@Override
	public String containers(String id) {
		String url =containers+"/9b5daece95f9782b535c1af897d89c03ed41e5ae189e7968f0226099b7c4c677%3B<container>";
		return restTemplate.getForObject(url, String.class);
	}
	
	
	
	
}
