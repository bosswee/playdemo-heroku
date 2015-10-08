package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.api.mvc.*;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("hello, world"));
    }


    public static Result login(){
        return ok(login.render("请输入..."));
    }

    public static Result loginPost(){
        DynamicForm requestData = Form.form().bindFromRequest();
        String username = requestData.get("username");
        String password = requestData.get("password");

        ObjectNode result = Json.newObject();
        if(username.equals("wee") && password.equals("123456"))
        {
            result.put("result","登陆成功");
            return ok(result);
        }
        else
        {
            result.put("result","错误，重新登陆");
            return ok(result);
        }

    }
}
