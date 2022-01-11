package src.http;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class JavaHttpClient implements  HttpAdapter{
    @Override
    public void post(String url, Map<String, Object> dados) {
        try {
            URL urlDaApi = new URL(url);
            URLConnection urlConnection= urlDaApi.openConnection();
            urlConnection.connect();
        }catch (Exception e){
            throw new RuntimeException("Erro ao enviar requisicao hhtp",e);
        }
    }
}
