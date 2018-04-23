package prebe_servidor;

import java.io.*;
import java.net.*;
import java.util.*;

public class Prebe_servidor extends javax.swing.JFrame 
{
   public ArrayList clienteOutputStreams;
   public ArrayList<String> usuarios;

public class ControCliente implements Runnable	
   {
       BufferedReader leer;
       Socket sock;
       PrintWriter cliente;

       public ControCliente(Socket clienteSocket, PrintWriter usuario) 
       {
            cliente = usuario;
            try 
            {
                sock = clienteSocket;
                InputStreamReader leyendo = new InputStreamReader(sock.getInputStream());
                leer = new BufferedReader(leyendo);
            }
            catch (Exception ex) 
            {
                caja.append("Oh maigad, un error inesperado :o ... \n");
            }

       }

       @Override
       public void run() 
       {
            String message, connect = "Connect", disconnect = "Disconnect", chat = "Chat" ;
            String[] data;

            try 
            {
                while ((message = leer.readLine()) != null) 
                {
                    caja.append("Received: " + message + "\n");
                    data = message.split(":");
                    
                    for (String token:data) 
                    {
                        caja.append(token + "\n");
                    }

                    if (data[2].equals(connect)) 
                    {
                        distribuirMensaje((data[0] + ":" + data[1] + ":" + chat));
                        agregarUsuario(data[0]);
                    } 
                    else if (data[2].equals(disconnect)) 
                    {
                        distribuirMensaje((data[0] + ":has disconnected." + ":" + chat));
                        quitarUsuario(data[0]);
                    } 
                    else if (data[2].equals(chat)) 
                    {
                        distribuirMensaje(message);
                    } 
                    else 
                    {
                        caja.append("No Conditions were met. \n");
                    }
                } 
             } 
             catch (Exception ex) 
             {
                caja.append("Lost a connection. \n");
                ex.printStackTrace();
                clienteOutputStreams.remove(cliente);
             } 
	}  
    }

    public Prebe_servidor() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton_inicio = new javax.swing.JButton();
        boton_usuariosc = new javax.swing.JButton();
        boton_finalizar = new javax.swing.JButton();
        boton_limparv = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        caja = new javax.swing.JTextArea();
        titulo_servidor = new javax.swing.JLabel();
        LogoPrebeChat = new javax.swing.JLabel();
        fondo1 = new javax.swing.JLabel();
        fondo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat - Server's frame");
        setName("server"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boton_inicio.setText("Iniciar");
        boton_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_inicioActionPerformed(evt);
            }
        });
        getContentPane().add(boton_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 130, -1));

        boton_usuariosc.setText("Usuario en linea");
        boton_usuariosc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_usuarioscActionPerformed(evt);
            }
        });
        getContentPane().add(boton_usuariosc, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 160, -1));

        boton_finalizar.setText("Finalizar");
        boton_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_finalizarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_finalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 130, -1));

        boton_limparv.setText("Limpiar ventana");
        boton_limparv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_limparvActionPerformed(evt);
            }
        });
        getContentPane().add(boton_limparv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 380, -1));

        caja.setColumns(20);
        caja.setRows(5);
        jScrollPane1.setViewportView(caja);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 380, 560));

        titulo_servidor.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        titulo_servidor.setText("Servidor");
        getContentPane().add(titulo_servidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        LogoPrebeChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/prebelogo-xs-1.png"))); // NOI18N
        getContentPane().add(LogoPrebeChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        getContentPane().add(fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        fondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        getContentPane().add(fondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 400, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_finalizarActionPerformed
        try 
        {
            Thread.sleep(5000);
        } 
        catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        
        distribuirMensaje("¿Estado del Servidor? Se detuvo y todos los usuarios se desconectaron, mi capitán.\n:Chat");
        caja.append("Servidor detenido \n");
        
        caja.setText("");
    }//GEN-LAST:event_boton_finalizarActionPerformed

    private void boton_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_inicioActionPerformed
        Thread iniciar = new Thread(new InicioServidor());
        iniciar.start();
        
        caja.append("Servidor Iniciado.\n");
    }//GEN-LAST:event_boton_inicioActionPerformed

    private void boton_usuarioscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_usuarioscActionPerformed
        caja.append("\n Usuarios en linea : \n");
        for (String current_user : usuarios)
        {
            caja.append(current_user);
            caja.append("\n");
        }    
        
    }//GEN-LAST:event_boton_usuarioscActionPerformed

    private void boton_limparvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_limparvActionPerformed
        caja.setText("");
    }//GEN-LAST:event_boton_limparvActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() {
                new Prebe_servidor().setVisible(true);
            }
        });
    }
    
    public class InicioServidor implements Runnable 
    {
        @Override
        public void run() 
        {
            clienteOutputStreams = new ArrayList();
            usuarios = new ArrayList();  

            try 
            {
                ServerSocket serverSock = new ServerSocket(9999);

                while (true) 
                {
				Socket clientSock = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
				clienteOutputStreams.add(writer);

				Thread listener = new Thread(new ControCliente(clientSock, writer));
				listener.start();
				caja.append("Hay una nueva conección. \n");
                }
            }
            catch (Exception ex)
            {
                caja.append("Error al hacer la conexion. \n");
            }
        }
    }
    
    public void agregarUsuario (String dato) 
    {
        String mensaje, agregar = "Conectado", hecho = "¡listo!", nombre = dato;
        caja.append("Antes " + nombre + " agregado. \n");
        usuarios.add(nombre);
        caja.append("Después " + nombre + " agregado. \n");
        String[] tempList = new String[(usuarios.size())];
        usuarios.toArray(tempList);

        for (String token:tempList) 
        {
            mensaje = (token + agregar);
            distribuirMensaje(mensaje);
        }
        distribuirMensaje(hecho);
    }
    
    public void quitarUsuario (String dato) 
    {
        String mensaje, add = "Conectado", hecho = "¡listo!", nombre = dato;
        usuarios.remove(nombre);
        String[] tempList = new String[(usuarios.size())];
        usuarios.toArray(tempList);

        for (String token:tempList) 
        {
            mensaje = (token + add);
            distribuirMensaje(mensaje);
        }
        distribuirMensaje(hecho);
    }
    
    public void distribuirMensaje(String mensaje) 
    {
	Iterator it = clienteOutputStreams.iterator();

        while (it.hasNext()) 
        {
            try 
            {
                PrintWriter writer = (PrintWriter) it.next();
		writer.println(mensaje);
		caja.append("Enviando: " + mensaje + "\n");
                writer.flush();
                caja.setCaretPosition(caja.getDocument().getLength());

            } 
            catch (Exception ex) 
            {
		caja.append("Error al distribuir el mensaje. \n");
            }
        } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoPrebeChat;
    private javax.swing.JButton boton_finalizar;
    private javax.swing.JButton boton_inicio;
    private javax.swing.JButton boton_limparv;
    private javax.swing.JButton boton_usuariosc;
    private javax.swing.JTextArea caja;
    private javax.swing.JLabel fondo1;
    private javax.swing.JLabel fondo2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel titulo_servidor;
    // End of variables declaration//GEN-END:variables
}
