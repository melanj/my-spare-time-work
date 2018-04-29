import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.security.KeyStore;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class HTTPSServer {
 private int port = 9999;
 private boolean isServerDone = false;

 public static void main(String[] args) {
  int allowedKeyLength = 0;

  try {
   allowedKeyLength = Cipher.getMaxAllowedKeyLength("AES");
  } catch (Exception e) {
   e.printStackTrace();
  }

  System.out.println("The allowed key length for AES is: " + allowedKeyLength);
  HTTPSServer server = new HTTPSServer();
  server.run();
 }

 HTTPSServer() {}

 HTTPSServer(int port) {
  this.port = port;
 }

 // Create the and initialize the SSLContext
 private SSLContext createSSLContext() {
  try {
   KeyStore keyStore = KeyStore.getInstance("JKS");
   keyStore.load(new FileInputStream("twister_server.jks"), "d1m6qwit".toCharArray());

   KeyStore trustStore = KeyStore.getInstance("JKS");
   trustStore.load(new FileInputStream("twister.jks"), "d1m6qwit".toCharArray());

   // Create key manager
   KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
   keyManagerFactory.init(keyStore, "d1m6qwit".toCharArray());
   KeyManager[] km = keyManagerFactory.getKeyManagers();

   // Create trust manager
   TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
   trustManagerFactory.init(trustStore);
   TrustManager[] tm = trustManagerFactory.getTrustManagers();

   // Initialize SSLContext
   SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
   sslContext.init(km, tm, null);

   return sslContext;
  } catch (Exception ex) {
   ex.printStackTrace();
  }

  return null;
 }

 // Start to run the server
 public void run() {
  SSLContext sslContext = this.createSSLContext();

  Predicate < String > cipherFilter = Pattern.compile("^TLS_ECDHE_.*[^(SHA)]$").asPredicate();
  try {
   // Create server socket factory
   SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

   // Create server socket
   SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(this.port);
   sslServerSocket.setEnabledProtocols(new String[] {
    "TLSv1.2"
   });
   sslServerSocket.setEnabledCipherSuites(Arrays.asList(sslServerSocket.getEnabledCipherSuites()).stream()
    .filter(cipherFilter).toArray(String[]::new));
  // sslServerSocket.setNeedClientAuth(true);

   System.out.println("SSL server started");
   while (!isServerDone) {
    SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

    // Start the server thread
    new ServerThread(sslSocket).start();
   }
  } catch (Exception ex) {
   ex.printStackTrace();
  }
 }

 // Thread handling the socket from client
 static class ServerThread extends Thread {
  private SSLSocket sslSocket = null;

  ServerThread(SSLSocket sslSocket) {
   this.sslSocket = sslSocket;
  }

  public void run() {

   try {
    // Start handshake
    sslSocket.startHandshake();

    // Get session after the connection is established
    SSLSession sslSession = sslSocket.getSession();

    System.out.println("SSLSession :");
    System.out.println("\tProtocol : " + sslSession.getProtocol());
    System.out.println("\tCipher suite : " + sslSession.getCipherSuite());
    System.out.println("\tPeerPrincipal : " + sslSession.getPeerPrincipal().getName());

    // Start handling application content
    InputStream inputStream = sslSocket.getInputStream();
    OutputStream outputStream = sslSocket.getOutputStream();

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));

    String line = null;
    while ((line = bufferedReader.readLine()) != null) {
     System.out.println("Input : " + line);

     if (line.trim().isEmpty()) {
      break;
     }
    }

    // Write data
    printWriter.print("HTTP/1.1 200\r\n");
    printWriter.print("\r\n");
    printWriter.println("Protocol : " + sslSession.getProtocol());
    printWriter.println("Cipher suite : " + sslSession.getCipherSuite());
    printWriter.flush();

    sslSocket.close();
   } catch (Exception ex) {
    ex.printStackTrace();
   }
  }
 }
}
 
