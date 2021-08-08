package ru.eduprof.sdo.android.proxyChecker;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
/*
Записать в файл good_ip.txt рабочие ip адреса

В файле good_ip, адреса должны быть в следующем виде ip:port
 */

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("./test/ip.txt"); // Создаём поток ввода
            FileOutputStream fos = new FileOutputStream("./test/good_ip.txt");
            fos.write(("Список рабочих адресов:\n").getBytes());
            fos.close();
            FileOutputStream fos2 = new FileOutputStream("./test/good_ip.txt", true);
            int i;
            StringBuilder resultIp = new StringBuilder();
            while ((i = fis.read()) != -1) { // Читаем из файла, в конце фала вернётся -1
                if (i == 13) continue; // Символ возврата каретки
                else if (i == 10) { // Символ переноса строки
                    String[] resultIpArray = resultIp.toString().split(":"); // Разделяем ip и port по ":"
                    String ip = resultIpArray[0]; // Сохраняем ip
                    int port = Integer.parseInt(resultIpArray[1]); // Сохраняем порт, т.к. это строка, сначала преобразуем в число
                    boolean check = checkProxy(ip, port); // Вызовем метод проверки ip адреса
                    if (check) {
                        byte[] buffer = (ip + ":" + port + "\n").getBytes();
                        fos2.write(buffer);
                    }
                    resultIp = new StringBuilder();
                } else if (i == 9) { // Символ табуляции
                    resultIp.append(":"); // Когда встретился символ табуляции, прибавляем к строке ":"
                } else {
                    resultIp.append((char) i); // Сохраняем в строку любые другие символы прочитанные из файла
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean checkProxy(String ip, int port) {
        System.out.println("Пробуем подключиться через прокси - " + ip + ":" + port);
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
            return true;
            //rd.close();
        } catch (IOException e) {
            System.out.println("Нерабочий ip");
            return false;
        }
    }
}
