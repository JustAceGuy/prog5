package handlers;

import elements.Route;

import java.util.Arrays;
import java.util.HashSet;


/**
 * Class responsible for all changes in the collection
 */
public class CollectionHandler { //implements Comparable
    static HashSet<Route> routes = new HashSet<>();
    static java.time.LocalDateTime initTime = java.time.LocalDateTime.now();

    /**
     * Removes all elements from the collection.
     */
    public static Route[] clear() {
        Route[] r = routes.toArray(new Route[0]);
        routes.clear();
        return r;
    }

    /**
     * Outputs all elements of the collection to terminal.
     */
    public static void show() {
        for (Route r: routes) {
            OutputHandler.message(r);
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
    public static Route remove_by_id(Long id) {
        Route r = find_by_id(id);
        if (r != null) {
            routes.remove(r);
            OutputHandler.message("-- Removed route %s", r);
        }
        return r;
    }

    /**
     * Updates the {@code Route} with the specified id.
     *
     * @param id id of the object to be updated, if present
     * @return an array consisting of oldRoute and newRoute
     */
    public static Route[] update_id(Long id) {
        Route r = find_by_id(id);
        if (r == null) {
            return null;
        }
        return new Route[]{r.clone(), r.update()};
    }

    /**
     * Adds a new {@code Route} to the collection
     * if it's less than all other present elements.
     * @param newRoute Route object to attempt to add.
     */
    public static boolean add_if_min(Route newRoute) {
        for (Route r: routes) {
            if (newRoute.compareTo(r) > 0) {
                OutputHandler.message("Route wasn't added, isn't min.");
                return false;
            }
        }
        routes.add(newRoute);
        OutputHandler.message("Route added!");
        return true;
    }

    public static void add(Route... newRoutes) {
        routes.addAll(Arrays.asList(newRoutes));
    }

    /**
     * Show all Routes containing {@code pattern} in their name.
     * @param pattern pattern to search for
     */
    public static void filter_contains_name(String pattern) {
        for (Route r: routes) {
            if (r.getName().contains(pattern)) {
                OutputHandler.message(r);
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
            OutputHandler.message(r);
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
        OutputHandler.message("Уникальные значения поля Distance:\n%s", unqDist);
    }

    /**
     * Removes all Routes greater than specified Route.
     * @param newRoute Route to compare other objects with
     */
    public static Route[] remove_greater(Route newRoute) {
        HashSet<Route> toRemove = new HashSet<>();
        for (Route r: routes) {
            if (newRoute.compareTo(r) < 0) {
                toRemove.add(r);
            }
        }
        for (Route r: toRemove) {
            routes.remove(r);
            OutputHandler.message("- Route '%s' removed.", r);
        }
        return toRemove.toArray(new Route[0]);
    }

    /**
     * Prints a more detailed String representation of Route object with specified id,
     * if such exists.
     * @param id id of Route to be printed
     */
    public static void more(long id) {
        Route r = find_by_id(id);
        if (r != null) {OutputHandler.message(r.more());}
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
        OutputHandler.message("No Route with id '%s' found.", id);
        return null;
    }

    /**
     * Prints info about the collection.
     */
    public static void info() {
        OutputHandler.message(" Collection type: %s\n" +
                          " Current size: %s\n" +
                          " Initialization time: %s\n" +
                          " Coolness: 100", routes.getClass(), routes.size(), initTime);
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
