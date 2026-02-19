package handlers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import elements.Route;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;


public class FileHandler {
    static String saveLocation = "save";
    public static void save(HashSet<Route> routes) {
        XmlMapper xm = new XmlMapper();
        try {
            File f = new File(saveLocation);
            if (f.exists()) { f.delete(); }
            f.createNewFile();
            String out = "";
            for (Route r: routes) {
                out += xm.writeValueAsString(r);
                out += "\n";
            }
            PrintWriter pw = new PrintWriter(f);
            pw.print(out);
            pw.close();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void load() {
        Scanner sc;
        HashSet<Route> out = new HashSet<>();
        XmlMapper xm = new XmlMapper();

        try {
            sc = new Scanner(new File(saveLocation));
        } catch (FileNotFoundException e) {
            System.out.println("No save file found");
            return;
        }

        Route.isLoading = true;

        try {
            while (sc.hasNext()) {
                Route r = xm.readValue(sc.nextLine(), Route.class);
                out.add(r);
            }
        } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
        } finally { Route.isLoading = false; }
        CollectionHandler.setRoutes(out);
        System.out.println("Successfully loaded!");
        if (out.isEmpty()) {System.out.println("Warning: save file was empty.");}


    }

}
