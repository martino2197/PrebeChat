package prebe_cliente;

import java.net.*;
import java.io.*;
import java.util.*;

public class Prebe_cliente extends javax.swing.JFrame 
{
    public String usuario, IP = "localhost";
    public ArrayList<String> usuarios = new ArrayList();
    public int puerto = 9999;
    public Boolean conectado = false;
    
    public Socket sock;
    public BufferedReader leer;
    public PrintWriter escribir;
    
   //////////////////////////////////////////////////Los metodos Rey//////////////////////////////////////////////////////////// 
    public void ListenThread() 
    {
         Thread IncomingReader = new Thread(new IncomingReader());
         IncomingReader.start();
    }
    
    public void agregaUsu(String data) 
    {
         usuarios.add(data);
    }
        
    public void eliminaUsu(String data) 
    {
         ta_chat.append(data + " ya se elimino a este principe.\n");
    }
       
    public void escribeUsu() 
    {
         String[] tempList = new String[(usuarios.size())];
         usuarios.toArray(tempList);
         for (String token:tempList) 
         {
             //users.append(token + "\n");
         }
    }
    
    public void adios() 
    {
        String bye = (usuario + ": Bye bye Rey");
        try
        {
            escribir.println(bye); 
            escribir.flush(); 
        } catch (Exception e) 
        {
            ta_chat.append("ah numa que sad, no se mando nada.\n");
        }
    }
    
    public void Desconectado() 
    {
        try 
        {
            ta_chat.append("Desconectado.\n");
            sock.close();
        } catch(Exception ex) {
            ta_chat.append("Fallo al desconectar. \n");
        }
        conectado = false;
        tf_nombre.setEditable(true);

    }
    
    public Prebe_cliente() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
//////////////////////////////////Aqui terminan los metodos Principe///////////////////////////////////////////////////////////////    
    public class IncomingReader implements Runnable
    {
        @Override
        public void run() 
        {
            String[] datos;
            String flujo, hecho = "hecho", conectar = "Conectar", desconectar = "Desconectar", chat = "Chat";

            try 
            {
                while ((flujo = leer.readLine()) != null) 
                {
                     datos = flujo.split(":");

                     if (datos[2].equals(chat)) 
                     {
                        ta_chat.append(datos[0] + ": " + datos[1] + "\n");
                        ta_chat.setCaretPosition(ta_chat.getDocument().getLength());
                     } 
                     else if (datos[2].equals(conectar))
                     {
                        ta_chat.removeAll();
                        agregaUsu(datos[0]);
                     } 
                     else if (datos[2].equals(desconectar)) 
                     {
                         eliminaUsu(datos[0]);
                     } 
                     else if (datos[2].equals(hecho)) 
                     {
                        //users.setText("");
                        escribeUsu();
                        usuarios.clear();
                     }
                }
           }catch(Exception ex) { }
        }
    }

    //--------------------------//
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_name = new javax.swing.JLabel();
        lb_address = new javax.swing.JLabel();
        tf_IP = new javax.swing.JTextField();
        lb_port = new javax.swing.JLabel();
        tf_puerto = new javax.swing.JTextField();
        lb_username = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        b_conectar = new javax.swing.JButton();
        b_desconectar = new javax.swing.JButton();
        tf_mensaje = new javax.swing.JTextField();
        b_enviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_chat = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        lb_name.setText("TechWorld3g");
        lb_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat - Client's frame");
        setName("client"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_address.setText("Direccion IP");
        getContentPane().add(lb_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 30));

        tf_IP.setText("192.168.0.");
        tf_IP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_IPActionPerformed(evt);
            }
        });
        getContentPane().add(tf_IP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 110, -1));

        lb_port.setText("Puerto");
        getContentPane().add(lb_port, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, 30));

        tf_puerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_puertoActionPerformed(evt);
            }
        });
        getContentPane().add(tf_puerto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 50, -1));

        lb_username.setText("Usuario");
        getContentPane().add(lb_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 60, -1));

        tf_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(tf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 150, -1));

        b_conectar.setText("Conectate Rey");
        b_conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_conectarActionPerformed(evt);
            }
        });
        getContentPane().add(b_conectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 180, -1));

        b_desconectar.setText("Desconectate Principe");
        b_desconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_desconectarActionPerformed(evt);
            }
        });
        getContentPane().add(b_desconectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 180, -1));
        getContentPane().add(tf_mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 260, 31));

        b_enviar.setText("Enviar");
        b_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_enviarActionPerformed(evt);
            }
        });
        getContentPane().add(b_enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 660, 111, 31));

        ta_chat.setColumns(20);
        ta_chat.setRows(5);
        jScrollPane1.setViewportView(ta_chat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 380, 500));

        jLabel2.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel2.setText("Cliente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/prebelogo-xs-1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 490));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 400, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_IPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_IPActionPerformed
       
    }//GEN-LAST:event_tf_IPActionPerformed

    private void tf_puertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_puertoActionPerformed
   
    }//GEN-LAST:event_tf_puertoActionPerformed

    private void tf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombreActionPerformed
    
    }//GEN-LAST:event_tf_nombreActionPerformed

    private void b_conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_conectarActionPerformed
        if (conectado == false) 
        {
            usuario = tf_nombre.getText();
            IP=tf_IP.getText();
            puerto=Integer.parseInt(tf_puerto.getText());
            tf_nombre.setEditable(false);

            try 
            {
                sock = new Socket(IP, puerto);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                leer = new BufferedReader(streamreader);
                escribir = new PrintWriter(sock.getOutputStream());
                escribir.println(usuario + ":has connected.:Connect");
                escribir.flush(); 
                conectado = true; 
            } 
            catch (Exception ex) 
            {
                ta_chat.append("No se puede conectar. Intente de nuevo. \n");
                tf_nombre.setEditable(true);
            }
            
            ListenThread();
            
        } else if (conectado == true) 
        {
            ta_chat.append("Ya se encuentra conectado. \n");
        }
    }//GEN-LAST:event_b_conectarActionPerformed

    private void b_desconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_desconectarActionPerformed
        adios();
        Desconectado();
    }//GEN-LAST:event_b_desconectarActionPerformed

    private void b_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_enviarActionPerformed
        String nothing = "";
        if ((tf_mensaje.getText()).equals(nothing)) {
            tf_mensaje.setText("");
            tf_mensaje.requestFocus();
        } else {
            try {
               escribir.println(usuario + ":" + tf_mensaje.getText() + ":" + "Chat");
               escribir.flush(); // flushes the buffer
            } catch (Exception ex) {
                ta_chat.append("El mensaje no fue enviado. \n");
            }
            tf_mensaje.setText("");
            tf_mensaje.requestFocus();
        }

        tf_mensaje.setText("");
        tf_mensaje.requestFocus();
    }//GEN-LAST:event_b_enviarActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new Prebe_cliente().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_conectar;
    private javax.swing.JButton b_desconectar;
    private javax.swing.JButton b_enviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_address;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_port;
    private javax.swing.JLabel lb_username;
    private javax.swing.JTextArea ta_chat;
    private javax.swing.JTextField tf_IP;
    private javax.swing.JTextField tf_mensaje;
    private javax.swing.JTextField tf_nombre;
    private javax.swing.JTextField tf_puerto;
    // End of variables declaration//GEN-END:variables
}
