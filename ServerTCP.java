/**
   A Java program for Server using Sockets
   Conpile: javac ServerTCP.java
   Run: java ServerTCP
*/
import java.io.*;
import java.net.*;

class ServerTCP {
  public static void main (String argv[]) throws Exception {
    String clientSentence;
    String returnSentence;

    /* Creating a welcomming socket*/
    ServerSocket welcomeSocket = new ServerSocket(8080);
    System.out.println("TCP server waiting ...");
    /* Wait on welcomming socket for contact from the client.*/
    while (true) {
      Socket connectionSocket = welcomeSocket.accept();

      /* Create input stream attached to socket */
      BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

      /* Read in the line from Socket */
      clientSentence = inFromClient.readLine();
       System.out.println("Message from Client: " + clientSentence);

      /* 1 - Create a return message, can simple transform sentence toUpperCase */
	returnSentence = clientSentence.toUpperCase() + "\n";
      /* 2 - Create output stream, attched to socket */
    DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
      /* 3 -  Write the line out to Socket */
	outToClient.writeBytes(returnSentence);
    } // end of while, wait for another Client
  }
}
