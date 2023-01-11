package com.example.sampleproject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatA {
   public static void main(String[] args) throws IOException {
       ServerSocket ss=new ServerSocket(3304);
       Socket s=ss.accept();
       DataInputStream dis=new DataInputStream(s.getInputStream());
       DataOutputStream dop=new DataOutputStream(s.getOutputStream());
//       Scanner in=new Scanner(System.in);
//       String data;
//       System.out.println("talk to server");
//       data=in.next();
//         dop.writeUTF(data);
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

       String str="",str2="";
       while(!str.equals("stop")){
           str=dis.readUTF();
           System.out.println("client says: "+str);
           str2=br.readLine();
           dop.writeUTF(str2);
           dop.flush();
       }
//       String  str=(String)dis.readUTF();
//       System.out.println("message= "+str);
       ss.close();

    }
}
