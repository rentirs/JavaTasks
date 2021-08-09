package ru.eduprof.sdo.android.proxyChecker.threads.method2;

import java.io.FileInputStream;
import java.io.IOException;

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
                    Thread proxyChecker = new Thread(new ProxyChecker(ip, port));
                    proxyChecker.start();
                    resultIp = new StringBuilder();
                }else if(i == 9){ // Символ табуляции
                    resultIp.append(":"); // Когда встретился символ табуляции, прибавляем к строке :
                }else{
                    resultIp.append((char) i); // Сохраняем в строку любые другие смволы прочитанные из файла
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

