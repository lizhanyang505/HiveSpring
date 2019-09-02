package com.ecarx.springhive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Controller
@RequestMapping("/hive")
public class HiveController {
    private static final String URLHIVE="jdbc:hive2://10.43.75.88:10000";
    private Connection connection=null;

    public Connection getConnection(){
        if(connection == null){
            synchronized (HiveController.class){
                if(null == connection){
                    try {
                        Class.forName("org.apache.hive.jdbc.HiveDriver");
                       connection= DriverManager.getConnection(URLHIVE,"lizhanyang","lizhanyang");
                    } catch (SQLException e){
                        e.printStackTrace();

                    }catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }


}
