package ru.eduprof.sdo.android.proxyChecker.threads.method2;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

class ProxyChecker implements Runnable {
    private String ip;
    private int port;

    ProxyChecker(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Получен ответ, наш ip: " + response);
            rd.close();
            FileOutputStream fos = new FileOutputStream("./test/good_ip2.txt", true);
            byte[] buffer = (ip + ":" + port + "\n").getBytes();
            fos.write(buffer);
            fos.close();
        } catch (IOException e) {
            System.out.println("Нерабочий ip: " + ip + ":" + port);
        }
    }
}
