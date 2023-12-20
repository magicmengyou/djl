package www.model.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileUtil {

    public static List<File> listFiles(File dir) {
        List<File> files = new ArrayList<>();
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.isFile()) {
                // 判断文件名后缀是否为常见的办公文件后缀名
                if (isOfficeFile(file.getName())) {
                    files.add(file);
                }
            } else if (file.isDirectory()) {
                files.addAll(listFiles(file));
            }
        }
        return files;
    }

    private static boolean isOfficeFile(String fileName) {
        // 常见的办公文件后缀名
        String[] officeFileSuffixes = {".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx", ".pdf", ".txt", ".jpg", ".png", ".gif", ".mp3", ".mp4", ".avi", ".wmv", ".mov", ".rar", ".zip", ".7z", ".iso"};
        for (String officeFileSuffix : officeFileSuffixes) {
            if (fileName.endsWith(officeFileSuffix)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        List<File> files = listFiles(new File("../My_OaProject/web/file/myfile/"));
        List<File> files = listFiles(new File("./web/file/myfile"));
        for (File file : files) {
            //相对路径
            System.out.println(file.getPath());
//            System.out.println(file.);
        }
        System.out.println(files);
    }
//        List<File> files = listFiles(new File("../My_OaProject/web/"));
//        for (File file : files) {
//            System.out.println(file.getName());
//        }
//    }
}