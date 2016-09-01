package com.github.docker.monitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.docker.monitor.service.CaMonitorService;

@Service
public class CaMonitorServiceImpl  implements CaMonitorService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	//String url = "http://9.111.141.61:4040/api/topology/containers";
	String ip = "9.111.141.61";
	String port = "8080";
	
	
	String events = "/api/v1.3/events";
	String sub = "/api/v1.1/subcontainers/docker";
	
	String containers = "/api/v1.0/containers";
	String docker = "/api/v1.2/docker/";
	String machine = "/api/v2.0/machine";
	
	private StringBuilder getHead(){
		StringBuilder head = new StringBuilder("http://");
		return head;
	}
	
	
	@Override
	public String containerInfo(String cid) {
		StringBuilder cUrl =getHead().append(ip).append(":").append(port);
		cUrl.append(docker).append(cid);
		return restTemplate.getForObject(cUrl.toString(), String.class);
	}
	
	@Override
	public String subcontainers(String id) {
		StringBuilder cUrl =getHead().append(ip).append(":").append(port);
		cUrl.append(sub).append("/").append(id);
		return restTemplate.getForObject(cUrl.toString(), String.class);
	}
	@Override
	public String subcontainers() {
		StringBuilder cUrl =getHead().append(ip).append(":").append(port);
		cUrl.append(sub);
		String forObject = restTemplate.getForObject(cUrl.toString(), String.class);
		JSONArray array = (JSONArray) JSONArray.parse(forObject);
		for (Object object : array) {
			if(object instanceof JSONObject) {
				object = (JSONObject) object;
				((JSONObject) object).fluentRemove("spec");
				((JSONObject) object).fluentRemove("stats");
			}
		}
		return array.toJSONString();
	}
	
	@Override
	public String containers() {
		StringBuilder cUrl =getHead().append(ip).append(":").append(port);
		cUrl.append(containers);
		return restTemplate.getForObject(cUrl.toString(),String.class);
	}
	
	@Override
	public String docker() {
		StringBuilder cUrl =getHead().append(ip).append(":").append(port);
		return restTemplate.getForObject(cUrl.append(docker).toString(), String.class);
	}
	
	@Override
	public String machine() {
		StringBuilder cUrl =getHead().append(ip).append(":").append(port);
		cUrl.append(machine);
		String string = restTemplate.getForObject(cUrl.toString(), String.class);
		JSONObject j = (JSONObject) JSONObject.parse(string);
		j.fluentRemove("disk_map");
		j.fluentRemove("topology");
		return j.toJSONString(); 
	}


	

	
}
