package ru.otus.spring.homework.serivce.utils;


import java.io.*;
import java.util.Scanner;

public class InputOutputWrapperImpl implements InputOutputWrapper {

    private final PrintStream printStream;
    private final Scanner scanner;

    public InputOutputWrapperImpl(PrintStream printStream, InputStream inputStream) {
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
