package com.universo7.Karatewebprofile.actions;

import com.universo7.Karatewebprofile.models.Information;
import com.universo7.Karatewebprofile.models.KarateService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class SelfProfileAction extends ActionSupport implements ModelDriven<Information>,SessionAware {
    private Map<String, Object> sessionMap;
    private Information information;

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public Information getModel() {
        return information;
    }

    @Override
    public String execute() throws Exception {
        KarateService service = new KarateService();
        if (sessionMap.containsKey("username")) {
            information=service.findInformationByUserId((int)sessionMap.get("id"));
            return SUCCESS;
        }
        return ERROR;
    }
}
