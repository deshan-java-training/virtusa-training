package com.java;

import java.util.ArrayList;
import java.util.List;

public class AppObject {

    private String appName;
    private int appId;

    public AppObject(String appName, int appId) {
        this.appName = appName;
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public static List<AppObject> addToList(List<AppObject> li, String name, int num){
li.add(new AppObject(name, num));
return li;
    }
    public static void printList(List<AppObject> li){
for(AppObject app : li){
    System.out.println("ID: "+app.getAppId()+" Name: "+app.appName);
}
    }

}
