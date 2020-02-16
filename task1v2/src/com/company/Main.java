package com.company;

import java.util.*;
public class Main
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        String p="",c="",k="",l="abcdefghijklmnopqrstuvwxyz";

        //int m=in.nextInt();

        System.out.print("give the plane text\n");
        p=in.nextLine();

        System.out.print("give the key\n");
        k=in.nextLine();
        int ky=k.length();
        int pln=p.length();
        String 	y =k;
        int m = pln%ky;

        printf("asf");


        for( int i=1; i<pln/ky ; i++)
        {
            //if(i>=ky)
            //i=0;
            k=k+y;

            //x.charAt((x.indexOf(K.charAt(j)) + x.indexOf(p1.charAt(j)))%27);
        }
        k=k+k.substring(0,m);
        //System.out.println(k);
        for (int j=0; j<pln; j++ ){
            c=c + l.charAt((l.indexOf(k.charAt(j)) + l.indexOf(p.charAt(j)))%26);
        }
        c=c.toUpperCase();
        System.out.println("Encrypted cipher text: "+c);
        // Decryption
        c = c.toLowerCase();
        String pl = "";
        for (int r=0; r<pln; r++ ){
            pl=pl + l.charAt(((l.indexOf(c.charAt(r)) - l.indexOf(k.charAt(r))) +26 )%26);
        }
        System.out.println("Decrypted cipher text: "+p);
    }
}