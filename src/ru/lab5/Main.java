package ru.lab5;

/*Дана папка с файлами и вложенными папками Directory_for_lab6, содержащая презентации, задания на лаб. работы и вопросы к лекциям по курсу Java.

1. Напишите код, перемещающий все

презентации в папку «Lectures»,
вопросы – в папку «Questions»,
задания на лаб. работы – в папку «Assignments».

В папке Directory_for_lab6 должно быть всего 3 папки, в каждой соответствующие файлы. По желанию, папки можно назвать по-другому.

2. Напишите код (не используя коллекции), создающий файл Info.txt, который содержит список расширений файлов, например:

Расширения файлов в папке Directory_for_lab6:

pptx

doc

docx

Код (п.2) должен корректно работать при добавлении в папку файлов других расширений.*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        Задаём базовый путь
        String basePath = "C:\\Users\\belou\\IdeaProjects\\Labs_Java\\src\\ru\\lab5\\Directory_for_lab6\\";


        try {
//            Удаляем если существуют папки и файл
            Files.deleteIfExists(Paths.get(basePath + "Info.txt"));
            Files.deleteIfExists(Paths.get(basePath + "Lecture"));
            Files.deleteIfExists(Paths.get(basePath + "Questions"));
            Files.deleteIfExists(Paths.get(basePath + "Assignments"));

//           Создаём папки для последующего перемещения туда
            Files.createDirectory(Paths.get(basePath + "Lecture"));
            Files.createDirectory(Paths.get(basePath + "Questions"));
            Files.createDirectory(Paths.get(basePath + "Assignments"));
        } catch (IOException e) {
            e.printStackTrace(); // вывод ошибок
        }

        try {
//            Собираем все файлы
            List<Path> files = Files.walk(Paths.get(basePath))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());

//            Собранные файлы раскладываем в папки
            for (Path x : files) {
                if (x.getFileName().toString().contains("Lecture")) {
                    Files.move(x, Paths.get(basePath + "Lecture\\" + x.getFileName()));
                } else if (x.getFileName().toString().contains("Lab")){
                    Files.move(x, Paths.get(basePath + "Assignments\\" + x.getFileName()));
                } else if (x.getFileName().toString().contains("Questions")){
                    Files.move(x, Paths.get(basePath + "Questions\\" + x.getFileName()));
                }
            }

//           Создаём файл для записи расширений
            Path file = Files.createFile(Paths.get(basePath + "Info.txt"));

//           Записываем расширения
            Files.write(file, Files.walk(Paths.get(basePath))
                    .filter(Files::isRegularFile)
                    .map(x -> x.getFileName().toString()
                            .substring(x.getFileName().toString().lastIndexOf('.'))).distinct().toList());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
