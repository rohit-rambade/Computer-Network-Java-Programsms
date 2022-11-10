/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcp_socket;

import java.net.*;
import java.io.*;
class Client
{
public static void main(String[] args) throws
Exception
{
int ch=0,a,b,c;
Socket s = new Socket("localhost",1024);
System.out.println("Connection Successful");
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
PrintStream ps=new PrintStream(s.getOutputStream());
System.out.println("Please Enter Number 1:");
a = Integer.parseInt(br.readLine());
System.out.println("Please Enter Number 2:");
b = Integer.parseInt(br.readLine());
System.out.println("Please Enter The Operation to Be Performed\n");
System.out.println("1.Addition \n 2.Subtraction \n 3.Multiplication \n 4.Divison \n 5.Modulo \n 0.Exit"); 
ch = Integer.parseInt(br.readLine());
ps.println(ch);
ps.println(a);
ps.println(b);
BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
c=Integer.parseInt(br1.readLine());
System.out.println("Answer: "+c);
s.close();
}
}