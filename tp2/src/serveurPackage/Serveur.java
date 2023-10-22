package serveurPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
public static void main(String[]args) 
	
	{
		
		try {
			int op1,op2,res=0;
            String operation;
			System.out.println("je suis un serveur");
			ServerSocket ss =new ServerSocket(1234);
			//creation un objet Socket et attend la connexion du client 
			Socket s=ss.accept();
			// Affiche un message indiquant qu'un client est connecté
			System.out.println("un client est connecté");
			// Récupère les flux d'entrée et de sortie du socket pour communiquer avec le client
			InputStream is=s.getInputStream();
			OutputStream os=s.getOutputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			op1=Integer.parseInt(br.readLine());
			op2=Integer.parseInt(br.readLine());
			operation=br.readLine();
			 
			switch(operation)
			{
			case"+":res=op1+op2;break;
			case"-":res=op1-op2;break;
			case"/":res=op1/op2;break;
			case"*":res=op1*op2;break;
			}
			PrintWriter pw=new PrintWriter(os,true);
			pw.println(res);
			System.out.println("Déconnexion Serveur");
			// Ferme le socket (déconnexion de la communication entre le serveur et le client)
			//déconnexion et Fermeture de ServerSocket
			ss.close();
			s.close();
		 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

