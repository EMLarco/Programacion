package com.mycompany.evaluacion_poo;

import java.io.Closeable;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Interfaces
interface CustomCloseable extends Closeable {
    void customClose();
}

interface CustomAutoCloseable extends AutoCloseable {
    void customClose();
}

interface CustomStringIterator extends Iterator<String> {
    int countWords();
}

interface CustomReadable extends Readable {
    String readLine() throws IOException;
}

interface CustomAppendable extends Appendable {
    void appendLine(String line);
}

// Clases
class CustomScanner implements CustomCloseable, CustomStringIterator {
    private Scanner scanner;

    public CustomScanner(String input) {
        this.scanner = new Scanner(input);
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the iterator.");
        }
        return scanner.next();
    }

    @Override
    public int countWords() {
        int count = 0;
        while (hasNext()) {
            next();
            count++;
        }
        return count;
    }

    @Override
    public void customClose() {
        scanner.close();
    }

    @Override
    public void close() {
        customClose();
    }
}

public class Main {
    public static void main(String[] args) {
        try (CustomScanner scanner = new CustomScanner("Hello World")) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                System.out.println("Word: " + word);
            }
            int wordCount = scanner.countWords();
            System.out.println("Total words: " + wordCount);
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException occurred: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException occurred: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException occurred: " + e.getMessage());
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException occurred: " + e.getMessage());
        }
    }
}