/*
 * Copyright (c) 2022.
 * author : Manas Verma
 * All rights reserved.
 */

package com.test.chat.client;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args){
        // Create connection between client and server.
        try(Socket socket = new Socket("127.0.0.1", 2222)) {
            //Server is sending some message, we have to read it.
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                String readMessage = dataInputStream.readUTF();
                //print the message received from Server.
                System.out.println(readMessage);
                //send message to Server.
                String writeMessage = bufferedReader.readLine();
                dataOutputStream.writeUTF(writeMessage);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
