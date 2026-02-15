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

    public static void clear() {
        routes.clear();
    }

    public static void show() {
        System.out.println(routes);
    }
    //show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении

    public static void add() {
        routes.add(new Route());
    }
    //add {element} : добавить новый элемент в коллекцию
    // добавление должно поэтапно запонлять каждое поле.
    // логику возможно кинуть в новый класс

    public static void remove_by_id() {}
    //remove_by_id id : удалить элемент из коллекции по его id

    public static void update_id() {}
    //update id {element} : обновить значение элемента коллекции, id которого равен заданному
    // уже вторая ф-ция юзает id
    // вынести логику нахождения по id в отдельный класс?
    // если хэшсет такого не реализовывает??

    public static void add_if_min() {}
    //add_if_min {element} : добавить новый элемент в коллекцию,
    //если его значение меньше, чем у наименьшего элемента этой коллекции
    // очевидно вызывать add после проверки

    public static void filter_contains_name() {}
    //filter_contains_name name : вывести элементы,
    //значение поля name которых содержит заданную подстроку
    // ого

    public static void print_ascending() {}
    //print_ascending : вывести элементы коллекции в порядке возрастания

    public static void print_unique_distance() {}
    //print_unique_distance : вывести уникальные значения поля distance всех элементов в коллекции

    public static void remove_greater() {}
    //remove_greater {element} : удалить из коллекции все элементы, превышающие заданный
}
