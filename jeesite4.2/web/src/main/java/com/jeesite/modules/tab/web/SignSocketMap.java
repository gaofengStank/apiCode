package com.jeesite.modules.tab.web;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SignSocketMap {
	 private static SignSocketMap instance = new SignSocketMap(); 
	 private static  Map<String, Socket> map = new HashMap<String, Socket>();
     private SignSocketMap(){} 
     public static SignSocketMap getInstance(){  
          return instance;  
      } 
     
     public  void put(String imei,Socket socket) {
    	 map.put(imei, socket);
     }
     
     public Socket get(String imei) {
    	 return map.get(imei);
     }
}
