package SMTP;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

//import Cliente.JavaMailApp;



public class Interface extends JFrame{
	private JPanel painelPrincipal;
	
	String mensagem;
	
	private JButton btenviar, btcancelar;
	
	private JLabel destinatario, destobrig, jlmensagem, jlassunto;
	
	private JTextField txtdest3, txtdest1, txtdest2, txtassunto;
	
	private JTextArea txamensagem;
	
	int cont = 0;
	boolean cp, au, ds;
	
	public Interface() {
		inicializa();
	}
	
	
	private void inicializa() {
		definePainel();
		
		labels();
		
		TextFields();
		
		Botoes();
	
	}


	private void Botoes() {
		btenviar = new JButton("Enviar");
		btenviar.setBounds(10, 520, 100, 30);
		painelPrincipal.add(btenviar);
		btenviar.setVisible(true);
		btenviar.setBackground(new Color(70,130,180));
		btenviar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
					//ObrigatoriedadeDestinatario();
				 Properties props = new Properties();
				    props.put("mail.smtp.host", "smtp.gmail.com");
				    props.put("mail.smtp.socketFactory.port", "25");
				    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
				    props.put("mail.smtp.auth", "true");
				    props.put("mail.smtp.port", "25");
				    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
				    props.put("mail.smtp.starttls.enable", "true");
				
				 Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			           protected PasswordAuthentication getPasswordAuthentication() {
			                 return new PasswordAuthentication("markosvinial@gmail.com","tblptiezeexgltmu");
			           }
			      });
			    session.setDebug(true);
				 try {
				      Message message = new MimeMessage(session);
				      message.setFrom(new InternetAddress("markosvinial@gmail.com"));
				      Address[] toUser = InternetAddress.parse(txtdest1.getText());
				      message.setRecipients(Message.RecipientType.TO, toUser);
				      message.setSubject(txtassunto.getText());
				     
				      message.setText(txamensagem.getText());
				      Transport.send(message);
						txtdest1.setText("");
						txtassunto.setText("");
						txamensagem.setText("");
				      
				     }
				    
				    catch (Exception e) {
				    	System.out.println("Entrei no catch e dei erro\n" + e);
				    }
					
				
			}

		});
		
		btcancelar = new JButton("Cancelar");
		btcancelar.setBounds(140, 520, 100, 30);
		painelPrincipal.add(btcancelar);
		btcancelar.setVisible(true);
		btcancelar.setBackground(new Color(70,130,180));
		btcancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtdest1.setText("");
				txtassunto.setText("");
				txamensagem.setText("");
					
				
			}

		});
	}


	private void TextFields() {
		txtdest1 = new JTextField();
		txtdest1.setBounds(10, 35, 300, 20);
		painelPrincipal.add(txtdest1);
		txtdest1.setVisible(true);
		txtdest1.setHorizontalAlignment(txtdest1.LEFT);
		txtdest1.setEnabled(true);
			

		
		txtassunto = new JTextField();
		txtassunto.setBounds(10, 90, 550, 80);
		painelPrincipal.add(txtassunto);
		txtassunto.setBackground(Color.WHITE);
		txtassunto.setVisible(true);
		txtassunto.setHorizontalAlignment(txtassunto.LEFT);
		txtassunto.setEnabled(true);
		
		txamensagem = new JTextArea();
		txamensagem.setBounds(10, 210, 550, 300);
		painelPrincipal.add(txamensagem);
		txamensagem.setBackground(Color.WHITE);
		txamensagem.setVisible(true);
		txamensagem.setEnabled(true);
		txamensagem.setLineWrap(true);
		txamensagem.setRows(5);
		Border border = BorderFactory.createLineBorder(Color.black);
		txamensagem.setBorder(border);
		
		
	}


	private void labels() {
		destinatario = new JLabel("Enviar para:");
		destinatario.setBounds(10, 10, 200, 20);
		painelPrincipal.add(destinatario);
		destinatario.setFont(new Font("Arial", Font.BOLD, 14));
		destinatario.setVisible(true);
		
		destobrig = new JLabel("* Obrigatório ao menos um destinatário");
		destobrig.setBounds(320, 60, 500, 20);
		painelPrincipal.add(destobrig);
		destobrig.setBackground(Color.RED);
		destobrig.setFont(new Font("Arial", Font.BOLD, 10));
		destobrig.setVisible(false);
		
		jlassunto = new JLabel("Assunto:");
		jlassunto.setBounds(10, 70, 200, 20);
		painelPrincipal.add(jlassunto);
		//jlresultAU.setBackground(Color.WHITE);
		jlassunto.setFont(new Font("Arial", Font.BOLD, 14));
		jlassunto.setVisible(true);
		
		jlmensagem = new JLabel("Mensagem:");
		jlmensagem.setBounds(10, 180, 200, 20);
		painelPrincipal.add(jlmensagem);
		jlmensagem.setBackground(Color.WHITE);
		jlmensagem.setFont(new Font("Arial", Font.BOLD, 14));
		jlmensagem.setVisible(true);
	}
	
	

	private void definePainel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(350, 0, 600, 600);
		setTitle("Envio de e-mail");
		painelPrincipal = new JPanel();
		painelPrincipal.setLayout(null);
		add(painelPrincipal);
		setVisible(true);
	}

	private void ObrigatoriedadeDestinatario() {
		if(!txtdest1.getText().isEmpty()) {
			cont++;
		}
		if(!txtdest2.getText().isEmpty()) {
			cont++;
		}
		if(!txtdest3.getText().isEmpty()) {
			cont++;
		}
		if(cont == 0) {
			destobrig.setVisible(true);

		}else {
			destobrig.setVisible(false);

		}
		cont = 0;
	}
	






	public static void main(String[] args) {
		new Interface();
	}
}