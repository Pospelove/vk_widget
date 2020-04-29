﻿/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samurayrus.vk_widget_servers;

import com.vk.api.sdk.client.ClientResponse;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author maxim
 */
public class NewConVk {
    
    public static JSONObject getExample() throws IOException
    {
            ArrayList<ServerObj> people = DataForTest.getServerData();
            
            Collections.sort(people,ServerObj.COMPARE_BY_COUNT); //Сортировка игроки/офф-неофф
            
        people.forEach(System.out::println);
    
        return code(people);
    }
    
    
        public static String newCon() throws IOException
    {
        TransportClient tC = HttpTransportClient.getInstance(); 
        VkApiClient vkC = new VkApiClient(tC);
        
//        HttpTransportClient ht = new HttpTransportClient();
//        ClientResponse cr = ht.get("");
//        cr.getContent();
        
        GroupActor arc = new GroupActor(группа, "Ключ доступа");
        
        System.out.println();
        try {
            return vkC.appWidgets().update(arc, "return "+getExample()+";").type("table").executeAsString();
        } catch (ClientException ex) {
           return "ClientException";
        }
    }
        

            
    private static JSONObject code(ArrayList<ServerObj> arayContext)
    {

            JSONObject jo =  new JSONObject();
            JSONArray ja = new JSONArray();
            JSONObject jo2 = new JSONObject();
            JSONObject jo3 = new JSONObject();
            JSONObject jj1 = new JSONObject();
            JSONObject jj2 = new JSONObject();
            JSONObject jj3 = new JSONObject();

            jo2.put("title", "Всего серверов: ");
            jo2.put("title_counter",arayContext.size());
            jo2.put("title_url",Любая вк ссылка);
            jo2.put("more","Посмотреть ВСЕ");
            jo2.put("more_url",Любая вк ссылка);

            jo3.put("text", "Сервера: ");
            ja.add(jo3);

            jj1.put("text", "Игроки/Слоты");
            jj1.put("align", "center");
            ja.add(jj1);
            
            jj2.put("text", "Рейтинг:");
            jj2.put("align", "center");
            ja.add(jj2);
           
            jj3.put("text", "Official");
            jj3.put("align", "left");
            ja.add(jj3);
            
            JSONObject[] jo4 = new JSONObject[arayContext.size()];
            JSONObject[] jo5 = new JSONObject[arayContext.size()];
            JSONObject[] jo55 = new JSONObject[arayContext.size()];
            JSONObject[] jo54 = new JSONObject[arayContext.size()];
            
            JSONArray[] ja2 = new JSONArray[arayContext.size()+1];
            JSONArray ja6 = new JSONArray();
            JSONArray ja7 = new JSONArray();
            
            System.out.println(arayContext.size());
           // for(String[] al: arayContext) хз не пашет
           int length = arayContext.size();
           if(length>10) {length=10; System.out.println("More than 10 servers. Its good!");}
           
           for(int i = 0; i<length; i++)
            {
            jo4[i] = new JSONObject();  
            jo5[i] = new JSONObject(); 
            jo55[i] = new JSONObject(); 
            jo54[i] = new JSONObject(); 
            
            
            jo4[i].put("text",arayContext.get(i).getServerName()); //Имя сервера
            jo4[i].put("icon_id", arayContext.get(i).getIcon());  //Надо поискать как иконки вставлять
            jo4[i].put("url", arayContext.get(i).getLinq());  //Ссылка на группу?
            
            jo5[i].put("text", arayContext.get(i).getPlayers()+"/"+arayContext.get(i).getSlots()); //players/slots 
            
            jo55[i].put("text", arayContext.get(i).getRaiting()); //Рейтинг 
            
            if(arayContext.get(i).getOfficial()==1)
               jo54[i].put("text", "✅"); //Галочка
            else
               jo54[i].put("text", " "); //не галочка 

            
              ja2[i] = new JSONArray();
            ja2[i].add(jo4[i]);
            ja2[i].add(jo5[i]); 
            ja2[i].add(jo55[i]); 
            ja2[i].add(jo54[i]); 
               System.out.println(ja2[i].toJSONString()); 
               ja7.add(ja2[i]);


            System.out.println(jo4[i].toJSONString());

            }
 
            jo2.put("head", ja);
            jo2.put("body", ja7);
            
            
        //System.out.println(jo2.toString());
        return jo2;
    }
}