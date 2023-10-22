package clientPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
        try {
        	int op1,op2,res;
            String operation;

            // Crée un socket client pour se connecter au serveur sur le localhost et le port 1234
            Socket s = new Socket("localhost",1234);
            // Affiche un message indiquant que le client est connecté au serveur
            System.out.println("Je suis connecté au serveur");
         // Récupère les flux d'entrée et de sortie du socket pour communiquer avec le serveur
            InputStream is=s.getInputStream();
            OutputStream os = s.getOutputStream();
            Scanner scan=new Scanner(System.in);
            System.out.println("donner le premier nombre");
            op1=scan.nextInt();
            System.out.println("donner le deuxieme nombre");
            op2=scan.nextInt();
            do {
            	System.out.println("donner une operation(+,-,/,%)");
                operation=scan.nextLine();
            }
            while(!operation.equals("+") &&!operation.equals("-") &&!operation.equals("*") &&!operation.equals("/"));
            PrintWriter pw=new PrintWriter(os,true);
            //printwriter hiyya li bch tekteb bl carac bl carac
            //os bch tnajm tekteb beha bl octet bl octet w true tab3eth kol haja tlamadha
            pw.println(op1);
            pw.println(op2);
            pw.println(operation);
            InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			res=Integer.parseInt(br.readLine());
			System.out.println(op1+" "+operation+" "+op2+" = "+res);
            // Affiche un message de déconnexion du client
            System.out.println("Déconnexion client");
            
            // Ferme le socket du client (déconnexion)
            s.close();

        } catch (IOException e) {
            // En cas d'erreur d'entrée/sortie
            e.printStackTrace();
        }
    }

}
