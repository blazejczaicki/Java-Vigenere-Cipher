/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.serwer;
import java.net.*;
import java.io.*;
/**
 * @version 1.0
 * @author Błażej Czaicki
 */
public class TCPServer implements Closeable {
    final private int PORT = 2077;
    private ServerSocket serverSocket;
    TCPServer() throws IOException{
        serverSocket=new ServerSocket(PORT);
    }
    
    @Override
    public void close() throws IOException{
        if(serverSocket != null)
            serverSocket.close();
    }
}
