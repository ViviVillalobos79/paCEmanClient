package Sockets;


import Data.Commandos;
import Data.CrearFantasma;
import Data.CrearFruta;
import Data.CrearPill;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import Sprites.Player;

import java.io.*;
import java.net.Socket;

public class Cliente extends Thread{


    /**
     * port.
     */
    final int PORT = 8080;

    /**
     * ip.
     */
    String address = "192.168.50.222";

    /**
     * Constante del socket
     */
    Socket socket;

    /**
     * Variables
     */
    BufferedReader entrada;

    String mensajeRecibido;

    JSONObject jsonObject;

    Player player;
    Integer contador = 0;


    public Cliente(Player player) {
        this.player = player;
    }
    public void run() {
        while (true){
            try {
                this.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            recibirMensaje();

        }

    }

    void recibirMensaje(){
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
            Object obj= JSONValue.parse(mensajeRecibido);
            jsonObject = (JSONObject) obj;
            //Long vidas = (Long) jsonObject.get("vidas");
            //System.out.println(vidas);
            parseJson();
            //spawn();

        }
        catch(Exception e){
            System.out.println("Esperando servidor");}
    }
    public void spawn(){
        Commandos crearGhost = new CrearFantasma(player, getGhostColor("Clyde"), "Clyde");
        crearGhost.ejecutar();
    }

    private Integer getGhostColor(String name){
        if(name.equals("Clyde")){
            return 1;
        }
        if(name.equals("Blinky")){
            return 2;
        }
        if(name.equals("Pinky")){
            return 3;
        }
        else {
            return 4;
        }
    }

    public void parseJson(){
        String fantasma = (String) jsonObject.get("fantasma");
        if(fantasma != null){
            Commandos crearGhost = new CrearFantasma(player, getGhostColor(fantasma), fantasma);
            crearGhost.ejecutar();
        }

        Long fruta = (Long) jsonObject.get("fPuntos");
        if(fruta != null){
            Integer f = fruta.intValue();
            Commandos crearFruta = new CrearFruta(player,f);
            crearFruta.ejecutar();
        }


        Long xPill = (Long) jsonObject.get("xPill");
        Long yPill = (Long) jsonObject.get("yPill");
        //Commandos crearPill = new CrearPill(player,xPill,yPill);
        //crearPill.ejecutar();
        if(xPill != null && yPill != null){
            Integer x = xPill.intValue();
            Integer y = yPill.intValue();
            Commandos crearPill = new CrearPill(player,x,y);
            crearPill.ejecutar();
        }

    }


}


