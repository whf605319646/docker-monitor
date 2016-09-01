package com.github.docker.monitor.service;

public interface WeMonitorService {
	
	String hosts();
	String containers();
	String containers(String id);

}
