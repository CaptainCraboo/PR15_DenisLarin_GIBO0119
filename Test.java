package ru.mirea.gibo01.pr15;
import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.Scanner;


public class Test {

    public static void main(String args[]) throws IOException {
        File file = new File("C:\\Users\\Денис\\Desktop\\Example.txt");
        file.createNewFile();

        //запись в файл введённой с клавиатуры информации
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст для записи в файл Example.txt");
        String txt = sc.nextLine();
        FileWriter wr = new FileWriter("C:\\Users\\Денис\\Desktop\\Example.txt");
        wr.write(txt); // write string

        wr.flush();
        wr.close();

        //вывод информации из файла в консоль
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Денис\\Desktop\\Example.txt"));
        for (String line; (line = br.readLine()) != null;) {
            System.out.print(line);
        }
        br.close();

        String filename = "Example.txt";
        String search = "ГИБО-01-19";
        String replace = "ГИБО-03-18";
        Charset charset = StandardCharsets.UTF_8;
        Path path = Paths.get(filename);
        Files.write(path,
                new String(Files.readAllBytes(path), charset).replace(search, replace)
                        .getBytes(charset));

    }
}