package handlers;

import elements.Route;

import java.util.Arrays;
import java.util.HashSet;

//todo:
//save : сохранить коллекцию в файл

/**
 * Class responsible for all changes in the collection
 */
public class CollectionHandler { //implements Comparable
    static HashSet<Route> routes = new HashSet<>();
    static java.time.LocalDateTime initTime = java.time.LocalDateTime.now();

    /**
     * Removes all elements from the collection.
     */
    public static void clear() {
        routes.clear();
    }

    /**
     * Outputs all elements of the collection to terminal.
     */
    public static void show() {
        for (Route r: routes) {
            System.out.println(r);
        }
    }

    /**
     * Creates a new {@code Route} object and stores it in the collection.
     */
    public static void add() {
        routes.add(new Route());
    }

    /**
     * Removes a {@code Route} with the specified id from the collection.
     * @param id id of the object to be removed, if present
     */
    public static void remove_by_id(Long id) {
        Route r = find_by_id(id);
        if (r != null) {
            routes.remove(r);
            System.out.printf("Removed route %s\n", r);
        }
    }

    /**
     * Updates the {@code Route} with the specified id.
     * @param id id of the object to be updated, if present
     */
    public static void update_id(Long id) {
        Route r = find_by_id(id);
        if (r == null) {return;}
        r.update();
    }

    /**
     * Adds a new {@code Route} to the collection
     * if it's less than all other present elements.
     * @param newRoute Route object to attempt to add.
     */
    public static void add_if_min(Route newRoute) {
        for (Route r: routes) {
            if (newRoute.compareTo(r) > 0) {
                System.out.println("Route wasn't added, isn't min.");
                return;
            }
        }
        routes.add(newRoute);
        System.out.println("Route added!");
    }

    /**
     * Show all Routes containing {@code pattern} in their name.
     * @param pattern pattern to search for
     */
    public static void filter_contains_name(String pattern) {
        for (Route r: routes) {
            if (r.getName().contains(pattern)) {
                System.out.println(r);
            }
        }
    }

    /**
     * Prints all Routes from collection in ascending order
     */
    public static void print_ascending() {
        Route[] sorted_routes = routes.toArray(new Route[routes.size()]);
        Arrays.sort(sorted_routes);
        for (Route r: sorted_routes) {
            System.out.println(r);
        }
    }

    /**
     * Prints a set of all {@code Route.distance} values
     */
    public static void print_unique_distance() {
        HashSet<Long> unqDist = new HashSet<>();
        for (Route r: routes) {
            unqDist.add(r.getDistance());
        }
        System.out.printf("Уникальные значения поля Distance:\n%s\n", unqDist);
    }

    /**
     * Removes all Routes greater than specified Route.
     * @param newRoute Route to compare other objects with
     */
    public static void remove_greater(Route newRoute) {
        HashSet<Route> toRemove = new HashSet<>();
        for (Route r: routes) {
            if (newRoute.compareTo(r) < 0) {
                toRemove.add(r);

            }
        }
        for (Route r: toRemove) {
            routes.remove(r);
            System.out.printf("Route '%s' removed.\n", r);
        }
        toRemove.clear();
    }

    /**
     * Prints a more detailed String representation of Route object with specified id,
     * if such exists.
     * @param id id of Route to be printed
     */
    public static void more(long id) {
        Route r = find_by_id(id);
        if (r != null) {System.out.println(r.more());}
    }

    /**
     * Find a route with a specified id, if such exists.
     * @param id id of Route to attempt to find
     * @return Route with specified id or {@code null}, if such doesn't exist
     */
    private static Route find_by_id(Long id) {
        for (Route r: routes) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        System.out.printf("No Route with id '%s' found.\n", id);
        return null;
    }

    /**
     * Prints info about the collection.
     */
    public static void info() {
        System.out.printf(" Collection type: %s\n" +
                          " Current size: %s\n" +
                          " Initialization time: %s\n" +
                          " Coolness: 100\n", routes.getClass(), routes.size(), initTime);
    }

    /**
     * @return the collection
     */
    public static HashSet<Route> getRoutes() {
        return routes;
    }

    /**
     * Replace the collection with a new one.
     * @param r new collection
     */
    public static void setRoutes(HashSet<Route> r) {
        routes = r;
    }
}
