package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {


    /** The port. */
    final int port = 8080;

    /** The address. */
    String address = "localhost";

    /** The socket. */
    Socket socket;


    public Cliente() {
        try {
            socket = new Socket(this.address,this.port);
            System.out.println("Hola desde el cliente");
            //creamos el flujo de datos por el que se enviara un mensaje
            DataInputStream entradaDatos = new DataInputStream(socket.getInputStream());
            DataOutputStream mensaje = new DataOutputStream(socket.getOutputStream());

            //enviamos el mensaje
            mensaje.writeUTF("H123");
            System.out.println("Cerrando conexión...Cliente");

            //leer mensaje
            String msg = entradaDatos.readUTF();
            System.out.println(msg);

            //cerramos la conexión
            entradaDatos.close();
            socket.close();
        } catch (UnknownHostException e) {
            //IP failed
            System.out.println("Cannot find ip address");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cannot find server port");
        }


    }


}