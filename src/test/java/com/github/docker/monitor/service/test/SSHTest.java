package com.github.docker.monitor.service.test;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SSHTest {
	public static void main(String[] args) throws JSchException {
		JSch j = new JSch();
		j.addIdentity("9.111.141.61");
		Session session = j.getSession("root", "zgx9927110");
		session.connect();
		session.openChannel("");
		
	}

}
