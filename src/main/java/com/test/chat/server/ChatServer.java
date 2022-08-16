/*
 * Copyright (c) 2022.
 * author : Manas Verma
 * All rights reserved.
 */

package com.test.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    Using Socket Programming.
 */
public class ChatServer {
    public static void main(String[] args){
        //Create Server.
        try(ServerSocket serverSocket = new ServerSocket(2222)) {
            //start the server.
            Socket socket = serverSocket.accept();
            //send some data.
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                //user input to be sent to Client.
                String writeMessage = bufferedReader.readLine();
                dataOutputStream.writeUTF(writeMessage);
                String readMessage = dataInputStream.readUTF();
                System.out.println(readMessage);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
