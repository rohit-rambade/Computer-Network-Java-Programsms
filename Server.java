
package com.mycompany.tcp_socket;


import java.net.*;
import java.io.*;
class Server
{
  public static void main (String[]args) throws Exception
  {
    int choice, a, b, c = 0;
    ServerSocket ss = new ServerSocket (1024);
    Socket s = ss.accept ();
      System.out.println ("Connection Successful");
    BufferedReader br = new BufferedReader (new InputStreamReader (s.getInputStream ()));
      choice = Integer.parseInt (br.readLine ());
      a = Integer.parseInt (br.readLine ());
      System.out.printf("Received number 1 is %d \n",a);
      b = Integer.parseInt (br.readLine ());
       System.out.printf("Received number 2 is %d \n",b);
      System.out.println ("Connection Successful");
    switch (choice)
      {
      case 1:
	c = a + b;
	break;
	case 2:c = a - b;
	break;
	case 3:c = a * b;
	break;
	case 4:c = a / b;
	break;
	case 5:c = (a % b);
	break;
      }
    PrintStream pr = new PrintStream (s.getOutputStream ());
      pr.println(c);
      ss.close ();
      s.close ();
  }
}
