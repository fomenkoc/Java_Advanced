package com.gmail.fomenkoc;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class App 
{
    public static void main( String[] args )
    {
    	final Logger LOG = Logger.getLogger(App.class);
    	DOMConfigurator.configure("logConfig.xml");
    	
    	LOG.trace("TRACE Logger message of project");
		LOG.debug("DEBUG Logger message of project");
		LOG.info("INFO Logger message of project");
		LOG.warn("WARN Logger message of project");
		LOG.error("ERROR Logger message of project");
		LOG.fatal("FATAL Logger message of project");
    }
}
