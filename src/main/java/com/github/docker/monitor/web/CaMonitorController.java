package com.github.docker.monitor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.docker.monitor.service.CaMonitorService;
/*
 * 调用cadvisor rest api 
 */
@RestController
@RequestMapping("/dockermonitor")
public class CaMonitorController {

	@Autowired
	private CaMonitorService monitorService;

	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public String list(Model model) {
		String list = monitorService.docker();
		return list;
	}

	@RequestMapping(value = "/api/{cid}/info", method = RequestMethod.GET)
	public String info(@PathVariable("cid") String cid, Model model) {
		String info = monitorService.containerInfo(cid);
		return info;
	}
	
	@RequestMapping(value="/subcontainers",method = RequestMethod.GET)
	public String subcontainers() {
		String subcontainers = monitorService.subcontainers();
		return subcontainers;
	}
	/**
	 * 
	 * @return docker所有容器的stats汇总
	 */
	@RequestMapping(value="containers",method=RequestMethod.GET)
	public String containers() {
		String containers = monitorService.containers();
		return containers;
	}

	@RequestMapping(value="/docker",method = RequestMethod.GET)
	public String docker() {
		String docker = monitorService.docker();
		return docker;
	}
	@RequestMapping(value = "/machine", method = RequestMethod.GET)
	public String machine() {
		String machine = monitorService.machine();
		return machine;
	}
}
