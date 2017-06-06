import java.net.*;
import java.io.*;

public class XorServer{
   public static void main(String []args){
   	try{
   	  String key="AHGSG";
      ServerSocket ss=new ServerSocket(6666);
      Socket s=ss.accept();
      DataInputStream din=new DataInputStream(s.getInputStream());
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      String input=din.readUTF();
      char []enc=new char[input.length()];
      enc=input.toCharArray();
      char []dec=new char[input.length()];
      char []text=new char[key.length()];
      text=key.toCharArray();
      int j=0;
      for(int i=0;i<input.length();i++){
      	if(j==5){
      		j=0;
      	}
      	dec[i]=(char)(enc[i]^text[j]);
      	j++;
      }
      String display=String.valueOf(dec);
      System.out.println(display);
      ss.close();

   	}
   	catch(Exception e){

   	}
   }
}