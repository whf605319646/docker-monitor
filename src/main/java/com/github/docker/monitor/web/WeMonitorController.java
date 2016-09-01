package com.github.docker.monitor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.docker.monitor.service.WeMonitorService;

@RestController
@RequestMapping("/wemonitor")
public class WeMonitorController {
	
	@Autowired
	private WeMonitorService weMonitorService;
	
	@RequestMapping(value="/hosts",method=RequestMethod.GET)
	public String hosts() {
		String hosts = weMonitorService.hosts();
		return hosts;
	}

	@RequestMapping(value="/containers",method=RequestMethod.GET)
	public String containers() {
		String containers = weMonitorService.containers();
		return containers;
	}
}
