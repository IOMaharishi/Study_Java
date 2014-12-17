package ua.education.File;

import java.io.*;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.Deflater;

class Pack {


    private static void pack(String[] filesToJar,

                            String jarFileName, byte[] buffer) {

        try {

            JarOutputStream jos =

                    new JarOutputStream(

                            new FileOutputStream(jarFileName));

// метод сжатия

            if(new File(jarFileName).exists()){
                System.out.println("This jar already exist, it will be rewrite");
            }

            jos.setLevel(Deflater.DEFAULT_COMPRESSION);

            for (int i = 0; i < filesToJar.length; i++) {

                System.out.println(i);

                jos.putNextEntry(new JarEntry(filesToJar[i]));

                FileInputStream in =

                        new FileInputStream(filesToJar[i]);

                int len;

                while ((len = in.read(buffer)) > 0)

                    jos.write(buffer, 0, len);

                jos.closeEntry();

                in.close();

            }

            jos.close();

        } catch (IllegalArgumentException e) {

            e.printStackTrace();

            System.err.println("Некорректный аргумент");

        } catch (FileNotFoundException e) {

            e.printStackTrace();

            System.err.println("Файл не найден");

        } catch (IOException e) {

            e.printStackTrace();

            System.err.println("Ошибка доступа");

        }

    }

    public static void main(String[] args) {

        System.out.println("Создание jar-архива");

// массив файлов для сжатия

        String[] filesToJar = new String[2];

        filesToJar[0] = "FileLibrary.iml";

        filesToJar[1] = "text.txt";

        byte[] buffer = new byte[1024];

// имя полученного архива

        String jarFileName = "example.jar";

        pack(filesToJar, jarFileName, buffer);

    }

}