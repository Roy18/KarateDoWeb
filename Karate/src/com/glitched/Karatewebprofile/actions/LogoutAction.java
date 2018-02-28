package com.glitched.Karatewebprofile.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LogoutAction extends ActionSupport implements SessionAware {
    private Map<String, Object> sessionMap;

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String execute() throws Exception {
        if (sessionMap.containsKey("username")) {
            sessionMap.remove("username");
            sessionMap.remove("id");
            sessionMap.remove("userType");
        }
        return SUCCESS;
    }
}
