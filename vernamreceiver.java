import java.io.*;
import java.net.*;

class Receiver {
    static String dec(String c,String k){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<c.length();i++){
            sb.append((char)(c.charAt(i)^k.charAt(i)));
        }
        return sb.toString();
    }

    public static void main(String[] args)throws Exception{
        ServerSocket ss=new ServerSocket(14000);
        Socket s=ss.accept();

        DataInputStream in=new DataInputStream(s.getInputStream());
        String c=in.readUTF();
        String k=in.readUTF();

        System.out.println("Plain="+dec(c,k));
        s.close(); ss.close();
    }
}