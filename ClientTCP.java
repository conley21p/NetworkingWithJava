/**
   A Java program for Client using Sockets
   Conpile: javac ClientTCP.java
   Run: java ClientTCP
*/
import java.net.*;
import java.io.*;

class ClientTCP {
  public static void main (String argv[]) throws Exception
  {
    String sentence;
    String returnSentence;

    /* Create the User input stream */
    BufferedReader inFromUser =
    new BufferedReader(new InputStreamReader(System.in));

    /* Create client socket, and connect it to the Server */
    Socket clientSocket =  new Socket ("127.0.0.1",8080);
    System.out.println("Connected.");

    /* Create the output data stream attached to the Socket */
    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

    sentence = inFromUser.readLine(); // read user input from terminal

    /* Write (Send) line out to the Server */
    outToServer.writeBytes(sentence + '\n');
    System.out.println("Message sent.");


    /* 1 - Create input stream attached to socket to get incomming return message from server */
	BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    /* 2 - Read the line from Server */
	returnSentence = inFromServer.readLine();
       
    /* 3 - Print returned message from server */
	System.out.println("Message from Server: " + returnSentence);

    clientSocket.close();
    System.out.println("Connection closed\n ");
  }


}
