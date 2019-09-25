package org.baito.forge.jsonified;

import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Spider {

    private Path path;

    static Path configPath;

    public Spider() {
        path = configPath;
    }

    public Spider(String path) {
        this.path = path.charAt(0) == '\\' ? Paths.get(configPath + path) : Paths.get(configPath + "\\" + path);
    }

    public Spider in(String direc) {
        path = path.resolve(direc);
        return this;
    }

    public Spider out() {
        if (path.getParent().startsWith(configPath)) {
            path = path.getParent();
        }
        return this;
    }

    public String[] list() {
        return path.toFile().list();
    }

    public String[] listFiles() {
        List<String> list = new ArrayList<>();
        for (File i : path.toFile().listFiles()) {
            list.add(i.getName());
        }
        return list.toArray(new String[0]);
    }

    public JSONObject get(String file) {
        return parse(readFile(path.resolve(file).toFile()));
    }

    public String toString() {
        return path.toString();
    }

    public boolean exists(String check) {
        for (String i : path.toFile().list()) {
            if (i.equals(check)) return true;
        }
        return false;
    }

    public Spider create(String name, boolean overwrite, String content) {
        try {
            if (!path.resolve(name).toFile().exists()) {
                path.resolve(name).toFile().createNewFile();
                PrintWriter pw = new PrintWriter(path.resolve(name).toFile());
                pw.print(content);
                pw.close();
            } else if (path.resolve(name).toFile().exists() && overwrite) {
                PrintWriter pw = new PrintWriter(path.resolve(name).toFile());
                pw.print(content);
                pw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Spider urlCreate(String name, boolean overwrite, String link) {
        try {
            if (!path.resolve(name).toFile().exists() || (path.resolve(name).toFile().exists() && overwrite)) {
                URL url = new URL(link);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(url.openStream()));
                StringBuilder sb = new StringBuilder();
                if (path.resolve(name).toFile().exists()) {
                    path.resolve(name).toFile().delete();
                }
                String n;
                while ((n = in.readLine()) != null) sb.append(n);
                in.close();
                path.resolve(name).toFile().createNewFile();
                PrintWriter pw = new PrintWriter(path.resolve(name).toFile());
                pw.println(sb.toString());
                pw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public static JSONObject parse(String s) {
        return new JSONObject(s);
    }

    public static String readFile(File f) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(ls);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
