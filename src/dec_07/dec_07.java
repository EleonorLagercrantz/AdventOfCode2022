package dec_07;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class dec_07 {

    static File inputFile = new File("D:\\Eleonor\\Documents\\Code\\AdventOfCode\\2022\\src\\dec_07\\dec_07_input");
    static int sum = 0;
    static List<Directory> largeEnough = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //Part One
        System.out.println("Part One: " + partOne());

        //Part Two
        System.out.println("Part Two: " + partTwo());
    }

    public static int partOne() throws IOException  {
        List<String> rows = Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());

        Directory start = new Directory("/", null);

        Directory parent = start;

        for(int i = 1; i < rows.size(); i++) {
            String row = rows.get(i);
            if(row.contains("dir ")) {
                String name = row.substring(row.lastIndexOf(" ") + 1);
                parent.directories.add(new Directory(name, parent));
            }
            else if (Character.isDigit(rows.get(i).charAt(0))) {
                String[] fileParts = row.split(" ");
                String name = fileParts[1];
                int size = Integer.parseInt(fileParts[0]);
                parent.files.add(new DirFile(name, size));
            }
            else if(row.equals("$ cd ..")) {
                parent = parent.parentDirectory;
            }
            else if(row.contains("$ cd ")) {
                String name = row.substring(row.lastIndexOf(" ") + 1);
                parent = parent.directories.stream().filter(d -> name.equals(d.getName())).findAny().orElse(null);
            }
        }

        getSumOfAllDirectories(start);

        return sum;
    }


    public static int partTwo() throws IOException {
        List<String> rows = Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());

        Directory start = new Directory("/", null);

        Directory parent = start;

        for(int i = 1; i < rows.size(); i++) {
            String row = rows.get(i);
            if(row.contains("dir ")) {
                String name = row.substring(row.lastIndexOf(" ") + 1);
                parent.directories.add(new Directory(name, parent));
            }
            else if (Character.isDigit(rows.get(i).charAt(0))) {
                String[] fileParts = row.split(" ");
                String name = fileParts[1];
                int size = Integer.parseInt(fileParts[0]);
                parent.files.add(new DirFile(name, size));
            }
            else if(row.equals("$ cd ..")) {
                parent = parent.parentDirectory;
            }
            else if(row.contains("$ cd ")) {
                String name = row.substring(row.lastIndexOf(" ") + 1);
                parent = parent.directories.stream().filter(d -> name.equals(d.getName())).findAny().orElse(null);
            }
        }

        getSumOfAllDirectories(start);

        int intToDelete = 30000000 - (70000000 - start.totalSize);

        findLargeEnoughDirectories(start, intToDelete);

        largeEnough.sort(Comparator.comparing(Directory::getTotalSize));

        return largeEnough.get(0).getTotalSize();
    }

    public static void getSumOfAllDirectories(Directory d) {
        d.totalSize += getTotalSumOfFiles(d);
        if(d.getDirectories().size() > 0) {
            for (Directory directory : d.getDirectories()) {
                getSumOfAllDirectories(directory);
                d.totalSize += directory.totalSize;

            }
        }
        if (d.totalSize <= 100000) {
            sum += d.totalSize;
        }
    }

    public static int getTotalSumOfFiles(Directory directory) {
        return directory.getFiles().stream().mapToInt(DirFile::getSize).sum();
    }

    public static void findLargeEnoughDirectories(Directory d, int intToDelete) {
        if(d.totalSize > intToDelete) {
            largeEnough.add(d);
        }
        if(d.getDirectories().size() > 0) {
            for (Directory directory : d.getDirectories()) {
                findLargeEnoughDirectories(directory, intToDelete);
            }
        }

    }
}

class Directory {
    String name;
    List<Directory> directories;
    List<DirFile> files;
    Directory parentDirectory;
    int totalSize;

    public Directory(String name, Directory parent) {
        this.name = name;
        this.directories = new ArrayList<>();
        this.files = new ArrayList<>();
        this.parentDirectory = parent;
        this.totalSize = 0;
    }

    public String getName() { return name; }
    public List<Directory> getDirectories() {return directories;}
    public List<DirFile> getFiles(){return files;}
    public int getTotalSize() {return totalSize;}
}

class DirFile {
    String name;
    int size;

    public DirFile(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() { return name; }
    public int getSize() { return size; }
}


