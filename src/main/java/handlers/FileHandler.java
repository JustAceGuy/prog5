package handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import elements.Route;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Handler for file IO
 */
public class FileHandler {
    static private String saveLocation = "save";
    static {
        String tmp = System.getenv("PROG_5_SAVE");
        //OutputHandler.message(tmp);
        if (tmp!=null) {saveLocation = tmp;}
        else {OutputHandler.message("Could not get save location from environment. Using 'save' as default");}
    }

    /**
     * Saves current collection to a file
     */
    public static void save(HashSet<Route> routes) {
        XmlMapper xm = new XmlMapper();
        xm = XmlMapper.builder()
                .findAndAddModules()
                .build();
        xm.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            File f = new File(saveLocation);
            if (f.exists()) { f.delete(); }
            File parent = f.getParentFile();
            if (parent != null) {parent.mkdirs();}
            f.createNewFile();
            StringBuilder out = new StringBuilder();
            for (Route r: routes) {
                out.append(xm.writeValueAsString(r));
                out.append("\n");
            }
            PrintWriter pw = new PrintWriter(f);
            pw.print(out);
            pw.close();
            OutputHandler.message("Successfully saved!");
        } catch (JsonProcessingException e) {
            OutputHandler.message("uhh bad file somehow");
        } catch (FileNotFoundException e) {
            OutputHandler.message("save file not found"); //how.
        } catch (IOException e) {
            OutputHandler.message("IO fail");
        }
    }

    /**
     * Loads a current collection from the save file
     */
    public static void load() {
        Scanner sc;
        HashSet<Route> out = new HashSet<>();
        XmlMapper xm = new XmlMapper();
        //xm.registerModule(new JavaTimeModule());
        xm = XmlMapper.builder()
                .findAndAddModules()
                .build();
        xm.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            sc = new Scanner(new File(saveLocation));
        } catch (FileNotFoundException e) {
            OutputHandler.message("No save file found");
            return;
        }

        Route.isLoading = true;

        Long maxId = 0L;

        try {
            while (sc.hasNext()) {
                Route r = xm.readValue(sc.nextLine(), Route.class);
                if (r.validate()) {
                    out.add(r);
                    Long tmpId = r.getId();
                    maxId = (tmpId > maxId) ? tmpId : maxId;
                } else {
                    OutputHandler.message("Invalid route '" + r + "' ignored");
                }

            }
            CollectionHandler.setRoutes(out);
            Route.updateInstanceCounter(maxId+1);
            OutputHandler.message("Successfully loaded!");
            if (out.isEmpty()) {OutputHandler.message("Warning: save file was empty.");}
        } catch (JsonProcessingException e) {
                OutputHandler.message(e.getMessage());
                OutputHandler.message("Save file corrupt!");
        } finally { Route.isLoading = false; }



    }

}
