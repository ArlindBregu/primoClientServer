package com.example;

import java.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.*;
import java.util.*;

public class Server {

    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaModificata = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    
    public Socket attendi(){

        try {
            
            System.out.println("1 Server partito in esecuzione...");

            server = new ServerSocket(6789); //creo server sulla porta 6789
            client = server.accept(); //rimane in attesa del client
            server.close(); //chiudo il server per avere altri client
            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());

        } catch (Exception e) {
           
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server");
            System.exit(1);
        }

    }

    public void comunica(){

        System.out.println("3 benvenuto client, scrivi una frase e la trasformo in maiuscolo. Attendo...");
        stringaRicevuta = inDalClient.readLine();
        System.out.println("6 Stringa ricevuta dal client: " +stringaRicevuta);

        stringaModificata = stringaRicevuta.toUpperCase();
        System.out.println("7 invio la stringa modificata al client ...");
        outVersoClient.writeBytes(stringaModificata+'\n');

        System.out.println("9 SERVER: fine elaborazione ... buona serata");
        client.close();

    }
}
