package org.example.sourcemanager;
//Author: Juan Dingevan

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SourceManagerImpl implements SourceManager {
    private BufferedReader reader;
    private int lineNumber;
    private boolean endOfFileReached;
    private boolean mustReadNextLine;
    private char lastChar;

    public SourceManagerImpl() {
        lineNumber = 1;
        endOfFileReached = false;
        mustReadNextLine = false;
    }

    @Override
    public void open(String filePath) throws FileNotFoundException {
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

    @Override
    public char getNextChar() throws IOException {
        if (endOfFileReached) {
            return END_OF_FILE;
        }

        if (mustReadNextLine) {
            lineNumber++;
            mustReadNextLine = false;
        }

        int c = reader.read();
        if (c == -1) {
            endOfFileReached = true;
            return END_OF_FILE;
        }

        if (c == '\n' && lastChar != '\r') {
            mustReadNextLine = true;
        }
        if (c == '\r') {
            mustReadNextLine = true;
        }

        lastChar = (char) c;

        return (char) c;
    }

    @Override
    public int getLineNumber() {
        return lineNumber;
    }
}