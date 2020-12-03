package ru.otus.spring.homework1.serivce.utils;

import ru.otus.spring.homework1.serivce.utils.exceptions.ReadUserInformationException;

import java.io.*;

public class InteractWithUserServiceImpl implements InteractWithUserService {

    private final PrintStream printStream;
    private final InputStream inputStream;

    public InteractWithUserServiceImpl(PrintStream printStream, InputStream inputStream) {
        this.printStream = printStream;
        this.inputStream = inputStream;

    }

    @Override
    public void writeTo(String info) {
        printStream.println(info);
    }

    @Override
    public String readFrom() {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(inputStream));
        String informationFromUser = "";
        try {
            informationFromUser = reader.readLine();
        } catch (IOException e) {
            throw new ReadUserInformationException(e);
        }
        return informationFromUser;
    }
}
