package ru.otus.spring.homework.serivce.utils;

import ru.otus.spring.homework.serivce.utils.exceptions.ReadUserInformationException;

import java.io.*;
import java.util.Scanner;

public class InteractWithUserServiceImpl implements InteractWithUserService {

    private final PrintStream printStream;
    private final Scanner scanner;

    public InteractWithUserServiceImpl(PrintStream printStream, InputStream inputStream) {
        this.printStream = printStream;
        this.scanner = new Scanner(inputStream);

    }

    @Override
    public void writeTo(String info) {
        printStream.println(info);
    }

    @Override
    public String readFrom() {
        return scanner.nextLine();
    }
}
