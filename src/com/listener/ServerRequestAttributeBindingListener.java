package com.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Application Lifecycle Listener implementation class ServerRequestAttributeBindingListener
 *
 */
public class ServerRequestAttributeBindingListener implements ServletRequestAttributeListener {

    public ServerRequestAttributeBindingListener() {
        // TODO Auto-generated constructor stub
    }

    public void attributeRemoved(ServletRequestAttributeEvent arg0)  { 
    	System.out.println("Attribute Removed Listener");
    }

    public void attributeAdded(ServletRequestAttributeEvent arg0)  { 
    	System.out.println("Attributed Added Listener");
    }

    public void attributeReplaced(ServletRequestAttributeEvent arg0)  { 
    	System.out.println("Updated Attribute Listener");
    }
	
}
