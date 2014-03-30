package edu.wpi.cs.wpisuitetng.modules.planningpoker.controller;

import com.google.gson.Gson;

import edu.wpi.cs.wpisuitetng.modules.core.models.User;
import edu.wpi.cs.wpisuitetng.network.RequestObserver;
import edu.wpi.cs.wpisuitetng.network.models.IRequest;

public class UserRequestObserver implements RequestObserver {
    
    private EmailController controller;
    
    public UserRequestObserver(EmailController controller) {
        this.controller = controller;
    }

    @Override
    public void responseSuccess(IRequest iReq) {
        String response = iReq.getResponse().getBody();
        final Gson parser = new Gson();
        User[] users = parser.fromJson(response, User[].class);
        controller.receivedUsers(users);  
    }

    @Override
    public void responseError(IRequest iReq) {
        fail(iReq, null);
    }

    @Override
    public void fail(IRequest iReq, Exception exception) {
        controller.receivedUsers(null);
    }
    
}
