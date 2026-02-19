package handlers;

import elements.Route;

import java.util.Arrays;
import java.util.HashSet;

//todo:
//save : сохранить коллекцию в файл


public class CollectionHandler { //implements Comparable
    static HashSet<Route> routes = new HashSet<>();
    static java.time.LocalDateTime initTime = java.time.LocalDateTime.now();

    public static void clear() {
        routes.clear();
    }

    public static void show() {
        for (Route r: routes) {
            System.out.println(r);
        }
    }

    public static void add() {
        routes.add(new Route());
    }

    public static void remove_by_id(Long id) {
        Route r = find_by_id(id);
        if (r != null) { routes.remove(r);
        System.out.printf("Removed route %s\n", r);
        }
    }

    public static void update_id(Long id) {
        Route r = find_by_id(id);
        if (r == null) {return;}
        r.update();
    }

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
    //add_if_min {element} : добавить новый элемент в коллекцию,
    //если его значение меньше, чем у наименьшего элемента этой коллекции
    // очевидно вызывать add после проверки

    public static void filter_contains_name(String pattern) {
        for (Route r: routes) {
            if (r.getName().contains(pattern)) {
                System.out.println(r);
            }
        }
    }


    public static void print_ascending() {
        Route[] sorted_routes = routes.toArray(new Route[routes.size()]);
        Arrays.sort(sorted_routes);
        for (Route r: sorted_routes) {
            System.out.println(r);
        }
    }
    //print_ascending : вывести элементы коллекции в порядке возрастания

    public static void print_unique_distance() {
        HashSet<Long> unqDist = new HashSet<>();
        for (Route r: routes) {
            unqDist.add(r.getDistance());
        }
        System.out.printf("Уникальные значения поля Distance:\n%s\nx", unqDist);
    }


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
    //remove_greater {element} : удалить из коллекции все элементы, превышающие заданный

    public static void more(long id) {
        Route r = find_by_id(id);
        if (r != null) {System.out.println(r.more());}
    }

    private static Route find_by_id(Long id) {
        for (Route r: routes) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        System.out.printf("No Route with id '%s' found.\n", id);
        return null;
    }

    public static void info() {
        System.out.printf(" Collection type: %s\n" +
                          " Current size: %s\n" +
                          " Initialization time: %s\n" +
                          " Coolness: 100\n", routes.getClass(), routes.size(), initTime);
    }

    public static HashSet<Route> getRoutes() {
        return routes;
    }

    public static void setRoutes(HashSet<Route> r) {
        routes = r;
    }
}
