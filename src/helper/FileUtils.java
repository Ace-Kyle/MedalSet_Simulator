package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Utility class for file operations
 */
public class FileUtils {

    /**
     * Ensures that a directory exists, creating it if necessary
     * @param directoryPath Path to check/create
     * @return true if directory exists or was created successfully
     */
    public static boolean ensureDirectoryExists(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            return directory.mkdirs();
        }
        return directory.isDirectory();
    }

    /**
     * Checks if a file exists
     * @param filePath Path to check
     * @return true if file exists
     */
    public static boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }

    /**
     * Copies a file from the resources directory to a target location
     * @param resourcePath Path in resources directory
     * @param targetPath Target file path
     * @throws IOException If file cannot be copied
     */
    public static void copyResourceToFile(String resourcePath, String targetPath) throws IOException {
        // Get the resource as an input stream
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        try (FileInputStream inputStream = new FileInputStream(new File(classLoader.getResource(resourcePath).getFile()))) {
            // Create the target directory if it doesn't exist
            File targetFile = new File(targetPath);
            File parentDir = targetFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            // Copy the resource to the target file
            try (FileOutputStream outputStream = new FileOutputStream(targetFile)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
            }
        }
    }

    /**
     * Backs up a file before modifying it
     * @param filePath Path to the file to back up
     * @throws IOException If backup operation fails
     */
    public static void backupFile(String filePath) throws IOException {
        if (fileExists(filePath)) {
            Path source = Paths.get(filePath);
            Path backup = Paths.get(filePath + ".bak");
            Files.copy(source, backup, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}