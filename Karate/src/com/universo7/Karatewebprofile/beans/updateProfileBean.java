package com.universo7.Karatewebprofile.beans;

import com.universo7.Karatewebprofile.models.Information;
import com.universo7.Karatewebprofile.models.KarateService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class updateProfileBean extends ActionSupport implements ModelDriven<Information>,SessionAware {
    private Map<String, Object> sessionMap;
    private Information information;
    private String name;
    private String lastname;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public Information getModel() {
        return information;
    }

    @Override
    public String execute() {
        KarateService service=new KarateService();
        if(sessionMap.containsKey("username")) {
            if(service.updateUser((int)sessionMap.get("id"),information.getUser().getName(),information.getUser().getLastName(),information.getUser().getPhone())) {
                information=service.findInformationByUserId((int)sessionMap.get("id"));
                return SUCCESS;
            }
        }
        return ERROR;
    }
}
