package org.gfg;


import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(new Person(1, "Robin", "robin@gmail.com")));
    }
}
