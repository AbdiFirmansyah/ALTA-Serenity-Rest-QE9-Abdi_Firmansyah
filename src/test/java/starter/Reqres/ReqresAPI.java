package starter.Reqres;

import java.io.File;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constant;


public class ReqresAPI {

    public static String GET_LIST_USER = Constant.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constant.BASE_URL+"/api/users";
    public static String PUT_UPDATE_USER = Constant.BASE_URL + "/api/users/{id}";
    public static String DELETE_USER = Constant.BASE_URL +"/api/users/{id}";
    public static String GET_SINGLE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String POST_REGISTER_SUCCESSFUL = Constant.BASE_URL+"/api/register";
    public static String GET_LIST_RESOURCE = Constant.BASE_URL+"/api/unknown";
    public static String POST_LOGIN_SUCCESSFUL = Constant.BASE_URL+"/api/login";


//    GET LIST
    @Step("Get list user")
    public void getListUser(int page){
        SerenityRest.given()
                    .pathParam("page",page);
    }
    @Step("Get invalid list users")
    public void getInvalidListUser(String page){
        SerenityRest.given()
                .pathParam("page",page);
    }


//    POST CREATE
    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }
    @Step("invalid post create user")
    public void postInvalidCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
//    PUT UPDATE
    @Step("Put update user")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
//    DELETE USER
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);

    }
    @Step("Delete invalid user")
    public void deleteInvalidUser(String id){
        SerenityRest.given().pathParam("id",id);

    }
//    POST REGISTER
    @Step("Post register user successful")
    public void postRegisterUser(File json){
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }
//    GET SINGLE
    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
//    GET RESOURCE
    @Step("Get list resource")
    public void getListResource(){
        SerenityRest.given();
    }
//    POST LOGIN
    @Step("Post invalid login")
    public void postInvalidLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post valid login")
    public void postValidLogin(File json){
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }

}
