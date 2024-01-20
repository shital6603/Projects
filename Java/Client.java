import java.net.*;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import java.awt.Font;
import java.io.*;

public class Client extends JFrame{
    Socket socket;

    BufferedReader br;
    PrintWriter out;

    //Declare components
    private JLabel heading =new JLabel("Client Area");
    private JTextArea messageArea=new JTextArea();
    private JTextField messageInput =new JTextField();
    private Font font=new Font("Roboto", Font.PLAIN,20);
    public Client()  {
        try {
            /* System.out.println("Sending request  to server !!!");
            socket = new Socket("127.0.0.1", 7777);
            System.out.println("Connection done!!");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());*/
            createGUI();
           
           // startReading();
            //startWriting(); 
        } catch (Exception e) {

        }
    }
    public void createGUI(){
        this.setTitle("Client Messanger[END] ");
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //coding for components
        heading.setFont(font);
        messageArea.setFont(font);
        messageInput.setFont(font);
        heading.setIcon(new ImageIcon("img.png"));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        //frame ka layout set karenge
        this.setLayout(new BorderLayout());

        //adding the components to frame
        this.add(heading,BorderLayout.NORTH);
        this.add(messageArea,BorderLayout.CENTER);
        this.add(messageInput,BorderLayout.SOUTH);
    }
    public void startReading() {
        // thread - read karte rahega data
        Runnable r1 = () -> {
            System.out.println("Reader started !!!");
            try {
                while (true) {

                    String msg = br.readLine();
                    if (msg.equals("exit")) {
                        System.out.println("Server terminated chat");
                        socket.close();
                        break;
                    }
                    System.out.println("Server :" + msg);

                }
            } catch (Exception e) {
                System.out.println("Connection is closed !!!");
            }
            
        };
        new Thread(r1).start();
    }
    
    public void startWriting() {
        // thread - write karte rahega data
        Runnable r2 = () -> {
            System.out.println("Writer started....");
            try {
                while (!socket.isClosed()) {

                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String content = br.readLine();
                    out.println(content);
                    out.flush();
                    
                    if (content.equals("exit")) {
                        socket.close();
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Connection is closed !!!");
            }
        };
        new Thread(r2).start();
    }

    public static void main(String[] args) {
        System.out.println("This is client !!");
        new Client();
    }
}
