/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcp_socket;

import java.util.*; 
class CRC
{
public static void main(String[] args)
{
int[] data; int[] div; int[] divisor; int[] rem;
int[] crc;
int data_bits,divisor_bits,tot_bits; Scanner s = new Scanner(System.in);
//Sender Side
System.out.println("Enter Number of Data Bits:");
data_bits= s.nextInt(); data= new int[data_bits];
System.out.println("Enter The Data Bits : "); for(int i=0;i<data_bits;i++)
data[i] = s.nextInt(); System.out.println("Enter The Number of Bits of Divisor");
divisor_bits= s.nextInt(); divisor = new int[divisor_bits];
System.out.println("Enter The Divisor Bits : "); for(int i=0; i<divisor_bits ; i++)
divisor[i] = s.nextInt(); System.out.println("Data Bits Are :"); for(int i=0; i<data_bits ; i++)
System.out.print(data[i] + " "); System.out.println("\nDivisor Bits Are :"); for(int i=0; i<divisor_bits; i++)
System.out.print(divisor[i] + " "); tot_bits = data_bits+divisor_bits-1; div = new int[tot_bits];
rem = new int[tot_bits]; crc = new int[tot_bits];
for(int i=0;i<data.length;i++) 
div[i] = data[i];
System.out.println(" \n Dividend after appending 0's are");
for(int i=0;i<div.length;i++) 
System.out.print(div[i]+" ");
System.out.print("\n"); 
for(int j=0;j<div.length ;j++)
rem[j] = div[j];
rem = divide(div,divisor,rem);
for(int i=0;i<div.length;i++) crc[i] = (div[i] ^ rem[i]);
System.out.println("CRC CODE is :"); for(int i=0;i<crc.length;i++)
System.out.print(crc[i] + " ");
//Reciver Side
System.out.println("\nEnter The CRC CODE :"); for(int i=0;i<crc.length;i++)
crc[i] = s.nextInt(); System.out.println("CRC BITS ARE:"); for(int i =0; i<crc.length ; i++)
System.out.print(crc[i] + " "); for(int j=0; j<crc.length; j++)
rem[j] = crc[j];
rem = divide(crc,divisor,rem); for(int i=0;i<rem.length; i++)
{
if(rem[i]!=0)
{
System.out.println("\nError in the Code recievd!");
break;
}
if(i==rem.length-1) System.out.print("\nNo Error in the Code recived!");
}
}
static int[] divide(int div[], int divisor[], int rem[])
{
int cur=0; while(true)
{
for(int i=0; i<divisor.length;i++) rem[cur+i] = (rem[cur+i] ^ divisor[i] );
while(rem[cur] == 0 && cur!=rem.length-1) cur++;
if((rem.length-cur)<divisor.length) break;
}
return rem;
}
}
