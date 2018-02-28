package com.universo7.Karatewebprofile.beans;

import com.universo7.Karatewebprofile.models.KarateService;
import com.universo7.Karatewebprofile.models.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class UserBean extends ActionSupport implements ModelDriven<User> {
    private User user= new User();

    @Override
    public User getModel()
    {
        return user;
    }

    @Override
    public String execute() {
        KarateService service=new KarateService();
        if(service.createUser(user)) {
            if(service.createInformation("",0,0,user.getUsername())) {
                return SUCCESS;
            }
        }
        return INPUT;
    }
}