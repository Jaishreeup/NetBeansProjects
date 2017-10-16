package com.journaldev.servlet.session;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

class sessionlistener implements HttpSessionListener
{
   @Override
   public void sessionDestroyed(HttpSessionEvent se)
   {
       System.out.println("session expired");
   }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}