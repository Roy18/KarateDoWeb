package com.universo7.Karatewebprofile.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class RedirectAction extends ActionSupport implements SessionAware {
    private Map<String, Object> sessionMap;

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public String execute() throws Exception {
        if(sessionMap.containsKey("username")) {
            return SUCCESS;
        } else return ERROR;
    }
}