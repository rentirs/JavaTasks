package ru.eduprof.sdo.android.proxyChecker.threads.method3;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("./test/ip.txt"); // Создаём поток ввода
            int i;
            StringBuilder resultIp = new StringBuilder();
            while ((i=fis.read())!=-1){ // Читаем из файла, в конце фала вернётся -1
                if(i == 13) continue; // Символ возврата каретки
                else if(i == 10){ // Символ переноса строки
                    String[] resultIpArray = resultIp.toString().split(":"); // Разделяем ip и port по :
                    String ip = resultIpArray[0]; // Сохраняем ip
                    int port = Integer.parseInt(resultIpArray[1]); // Сохраняем порт, т.к. это строка, сначала преобразуем в число
                    Thread proxyChecker = new Thread(() -> {
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
                    });
                    proxyChecker.start();
                    resultIp = new StringBuilder();
                }else if(i == 9){ // Символ табуляции
                    resultIp.append(":"); // Когда встретился символ табуляции, прибавляем к строке :
                }else{
                    resultIp.append((char) i); // Сохраняем в строку любые другие символы прочитанные из файла
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}