package com.example.week5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DBCreds {
    public static String findUser() throws IOException {
        Path filePath = Path.of("C:/OneDrive - Georgian College/Desktop/Java/Creds/user.txt");
        return Files.readString(filePath);
    }

    public static String findPass() throws IOException {
        Path filePath = Path.of("C:/OneDrive - Georgian College/Desktop/Java/Creds/pass.txt");
        return Files.readString(filePath);
    }
}