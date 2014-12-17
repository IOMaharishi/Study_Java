package ua.education.File;

import java.io.*;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.Deflater;

/**
 * Created by illia on 21.11.14.
 */
public class ActionWithFile {

    private static byte[] buffer = new byte[1024];


    public static boolean isExist(File file) {
        return file.exists();

    }

    public static String getName(File file) {
        return file.getName();
    }

    public static long getSize(File file) {
        return file.length();
    }


    public static void write(File file, String text) {


        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(text + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String read(File file) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("File no found");
        }

        return bufferedReader.readLine();
    }

    public static void cleanFile(File file) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("");

    }


    public static void pack(String[] filesToJar, String jarFileName) {

        try {

            FileOutputStream fileOutputStream = new FileOutputStream(new File(jarFileName));

            ZipOutputStream jos = new ZipOutputStream(new FileOutputStream(jarFileName));

// метод сжатия

            jos.setLevel(Deflater.DEFAULT_COMPRESSION);


            for (int i = 0; i < filesToJar.length; i++) {

                System.out.println(i);

                jos.putNextEntry(new ZipEntry(filesToJar[i]));

                FileInputStream in =  new FileInputStream(filesToJar[i]);

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


}

