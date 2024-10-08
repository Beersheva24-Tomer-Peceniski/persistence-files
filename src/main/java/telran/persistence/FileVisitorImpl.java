package telran.persistence;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorImpl implements FileVisitor<Path> {
    private Path starPath;
    private String symbol;

    public FileVisitorImpl(Path startPath, String symbol) {
        this.starPath = startPath;
        this.symbol = symbol;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path file, IOException arg1) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes arg1) throws IOException {
        printInOrder(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes arg1) throws IOException {
        printInOrder(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException arg1) throws IOException {
        return FileVisitResult.SKIP_SIBLINGS;
    }

    private void printInOrder(Path path) {
        String pathName = path.getFileName().toString();
        String pathString = path.toString();
        pathString = pathString.replace(starPath.toString(), "");
        long count = pathString.chars().filter(ch -> ch == '\\').count();
        String repeated = symbol.repeat((int) count);
        System.out.printf("%s%s %n", repeated, pathName);
    }
}
