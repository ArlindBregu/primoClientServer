package com.example;


public class App 
{
    public static void main( String[] args )
    {
        Client cliente = new Client();
        Server server = new Server()
        cliente.connetti();
        cliente.comunica();
        server.attendi();
        server.comunica();
    }
}
