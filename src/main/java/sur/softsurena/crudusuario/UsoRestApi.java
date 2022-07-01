package sur.softsurena.crudusuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class UsoRestApi {

    public static String restUsuario(String url, String metodo) throws IOException {
            URL objUrl=new URL(url);

            HttpURLConnection con = (HttpURLConnection) objUrl.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod(metodo);

            StringBuilder sb = new StringBuilder();

            int HttpResult = con.getResponseCode(); 

            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"));
                String line = null;  
                while ((line = br.readLine()) != null) {  
                    sb.append(line + "\n");  
                }
                br.close();  
            } else {
                return con.getResponseMessage();
            }
            return sb.toString();
    }

    public static String postUsuario(String url, JSONObject json, String metodo) 
            throws IOException {
            URL objUrl=new URL(url);

            HttpURLConnection con = (HttpURLConnection) objUrl.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod(metodo);

            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(json.toString());
            wr.flush();

            StringBuilder sb = new StringBuilder();

            int HttpResult = con.getResponseCode(); 

            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"));
                String line = null;  
                while ((line = br.readLine()) != null) {  
                    sb.append(line + "\n");  
                }
                br.close();
            } else {
                return con.getResponseMessage();
            }
            return sb.toString();
    }
}