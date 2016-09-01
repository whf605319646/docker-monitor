package com.github.docker.monitor.service;

public interface CaMonitorService {

	
	
	
	

	String containerInfo(String cid);
	String containers();
	String docker();
	String machine();

	String subcontainers();
	String subcontainers(String id);

	
}
