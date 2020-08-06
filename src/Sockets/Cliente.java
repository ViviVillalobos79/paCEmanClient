package Sockets;


import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.net.Socket;
import java.io.*;

public class Cliente {


    /**
     * port.
     */
    final int PORT = 8080;

    /**
     * ip.
     */
    String address = "localhost";

    /**
     * Constante del socket
     */
    Socket socket;

    /**
     * Variables
     */
    BufferedReader entrada;

    String mensajeRecibido;


    public Cliente() throws IOException {
        try
        {
            //Se crea el socket para la conexion
            Socket s = new Socket(address,PORT);

            //salida de datos al servidor
            OutputStream os = s.getOutputStream();

            //Entrada de datos, lectura de mensajes del servidor
            entrada = new BufferedReader(new InputStreamReader(
                    s.getInputStream()));
            String mensajeRecibido = entrada.readLine();
            System.out.println(mensajeRecibido);

            //Envio de respuesta al server
            PrintWriter pw = new PrintWriter(os);
            pw.println("hola mundo desde el Cliente\n");

            //Cierre de conexiones
            pw.flush();
            pw.close();
            s.close();

            //Parse del json recibido desde el server server
            Object obj=JSONValue.parse(mensajeRecibido);
            JSONObject jsonObject = (JSONObject) obj;
            Long vidas = (Long) jsonObject.get("vidas");
            System.out.println(vidas);

        }
        catch(Exception e){
            System.out.println(e);}
    }


}


