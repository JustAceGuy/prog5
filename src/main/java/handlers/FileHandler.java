package handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import elements.Route;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;


public class FileHandler {
    static String saveLocation = "save";
    static {
        String tmp = System.getenv("PROG_5_SAVE");
        //System.out.println(tmp);
        if (tmp!=null) {saveLocation = tmp;}
        else {System.out.println("Could not get save location from environment. Using 'save' as default");}
    }

    /**
     * Saves current collection to a file
     */
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
            System.out.println("Successfully saved!");
        } catch (JsonProcessingException e) {
            System.out.println("uhh bad file somehow");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads a current collection from the save file
     */
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

        Long maxId = 0L;

        try {
            while (sc.hasNext()) {
                Route r = xm.readValue(sc.nextLine(), Route.class);
                out.add(r);
                Long tmpId = r.getId();
                maxId = (tmpId > maxId) ? tmpId : maxId;
            }
        } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
        } finally { Route.isLoading = false; }
        CollectionHandler.setRoutes(out);
        Route.updateInstanceCounter(maxId+1);
        System.out.println("Successfully loaded!");
        if (out.isEmpty()) {System.out.println("Warning: save file was empty.");}


    }

}
