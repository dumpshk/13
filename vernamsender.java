import java.io.*;
import java.net.*;

class Sender {
    static String enc(String p,String k){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<p.length();i++){
            sb.append((char)(p.charAt(i)^k.charAt(i)));
        }
        return sb.toString();
    }

    public static void main(String[] args)throws Exception{
        Socket s=new Socket("localhost",14000);
        DataOutputStream out=new DataOutputStream(s.getOutputStream());

        String p="HELLO";
        String k="XMCKL";

        String c=enc(p,k);
        System.out.println("Cipher="+c);

        out.writeUTF(c);
        out.writeUTF(k);
        s.close();
    }
}