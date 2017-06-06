import java.io.*;
import java.net.*;

public class XorClient{
	public static void main(String[]args){
		try{
		  String key="AHGSG";
          Socket s=new Socket("localhost",6666);
          DataOutputStream dout=new DataOutputStream(s.getOutputStream());
          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
          System.out.println("enter the message");
          String message=br.readLine();
          char []enc=new char[message.length()];
          char []text=new char[message.length()];
          char []text2=new char[key.length()];
          text=message.toCharArray();
          text2=key.toCharArray();
          int j=0;
          for(int i=0;i<message.length();i++){
          	if(j==5){
          		j=0;
          	}
          	enc[i]=(char)(text[i]^text2[j]);
          	j++;
          }
          String send=String.valueOf(enc);
          dout.writeUTF(send);
          dout.flush();
          s.close();
		}
		catch(Exception e){

		}
	}
}