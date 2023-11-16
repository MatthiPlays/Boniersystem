package com.zeindler.boniersystem.server;

import com.zeindler.boniersystem.veranstaltung.Kellner;
import com.zeindler.boniersystem.veranstaltung.Veranstaltung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Connector {

    //Connector zum Webserver
    //Am Webserver sind natürlich mehrere Veranstaltungen gespeichert, der Webserver entscheidet welche die aktuelle ist

    final private static String serverIp="10.0.0.110";//Statische Ip Adresse des Webservers
    final private static String responsePage ="messageReceiver.php";//Klasse, die am Server ankommenden Traffic verarbeitet

    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    //TODO Diesen ekligen Workaround fixen
    private static String jsonResult;

    public Connector(){

    }

    private static void sendRequestToServer(final String serverUrl) {
        executorService.execute(() -> {
            try {
                URL url = new URL(serverUrl);

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");

                //TODO: ReposnseCode checken
                int responseCode = urlConnection.getResponseCode();

                // Hier kannst du den ExecutorService schließen, nachdem die Aufgabe abgeschlossen ist
                //executorService.shutdown();
            } catch (Exception e) {
                e.printStackTrace();
                // Fehlerbehandlung bei Verbindungsstörung
            }
        });
    }
    private static String getDataFromServer(final String serverUrl){

        executorService.execute(() -> {
            try {
                URL url = new URL(serverUrl);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");

                // Lese die Antwort
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                reader.close();
                urlConnection.disconnect();

                jsonResult = stringBuilder.toString();

            } catch (Exception e) {
                e.printStackTrace();
                // Fehlerbehandlung bei Verbindungsstörung
            }
        });
        return jsonResult;
    }


    // Weitere Methoden können nun die `sendRequestToServer`-Methode verwenden

    private static String generateServerURL(){
        String serverURL = "http://"+serverIp+"/";
        return serverURL;
    }

    private static void sendMessageToServer(final String message) {
        String serverUrl = null;
        try {
            serverUrl = generateServerURL() + responsePage +"?message=" + URLEncoder.encode(message, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        sendRequestToServer(serverUrl);
    }




    //einzelne Klassen

    public static void newKellner(String name){
        //Code für neuen Kellner: NWKLN
        String message = "NWKLN_"+name+";";
        sendMessageToServer(message);

    }


    public static Veranstaltung getVeranstaltung(){
        //TODO: importieren vom Webserver
        return new Veranstaltung("FF URB");
    }


    public static Kellner[] getKellner(){
        String result = getDataFromServer(generateServerURL()+"getData.php");
        System.out.println("RESULT:" +result);
        return new Kellner[0];
    }
}
