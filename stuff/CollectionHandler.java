package stuff;

import java.util.HashSet;

//done
//help : вывести справку по доступным командам
//exit : завершить программу (без сохранения в файл)


//todo:
//clear : очистить коллекцию
//save : сохранить коллекцию в файл
//execute_script file_name : считать и исполнить скрипт из указанного файла.
//В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
//info : вывести в стандартный поток вывода информацию о коллекции
//(тип, дата инициализации, количество элементов и т.д.)
//history : вывести последние 15 команд (без их аргументов)
// probably should be some static Command/Invoker magic or some shit


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
    //show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении

    public static void add() {
        routes.add(new Route());
    }
    //add {element} : добавить новый элемент в коллекцию
    // добавление должно поэтапно запонлять каждое поле.
    // логику возможно кинуть в новый класс

    public static void remove_by_id(Long id) {
        Route r = find_by_id(id);
        if (r != null) { routes.remove(r);
        System.out.printf("Removed route %s\n", r);
        }
    }
    //remove_by_id id : удалить элемент из коллекции по его id

    public static void update_id(Long id) {
        Route r = find_by_id(id);
        if (r == null) {return;}
        r.update();
    }
    //update id {element} : обновить значение элемента коллекции, id которого равен заданному
    // уже вторая ф-ция юзает id
    // вынести логику нахождения по id в отдельный класс?
    // если хэшсет такого не реализовывает??

    public static void add_if_min() {}
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


    public static void print_ascending() {}
    //print_ascending : вывести элементы коллекции в порядке возрастания

    public static void print_unique_distance() {
        HashSet<Long> unqDist = new HashSet<>();
        for (Route r: routes) {
            unqDist.add(r.getDistance());
        }
        System.out.printf("Уникальные значения поля Distance:\n%s\nx", unqDist);
    }


    public static void remove_greater() {}
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
}
