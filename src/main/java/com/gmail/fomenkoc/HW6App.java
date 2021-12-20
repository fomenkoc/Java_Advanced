package com.gmail.fomenkoc;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.gmail.fomenkoc.servlet.LoginServlet;

public class HW6App {

	public static void main(String[] args) {

		Logger LOG = Logger.getLogger(LoginServlet.class);
		String CONFIG = "logConfig.xml";

		DOMConfigurator.configure(CONFIG);
		
		LOG.trace("asddfasd");
		LOG.error("error message");
	}
}