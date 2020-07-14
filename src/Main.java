import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Иванов", "Петров", "Сидоров");
        List<People> peoples = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            peoples.add(new People(names.get(
                    new Random().nextInt(names.size())),
                    new Random().nextInt(100),
                    Sex.randomSex()));
        }
        long startTime = System.nanoTime();

        long militaryMan = peoples.parallelStream()
                .filter(x -> x.getSex() == Sex.MAN)
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() < 27)
                .count();
        System.out.println(militaryMan);

        Double averageMenAge = peoples.parallelStream()
                .filter(x -> x.getSex() == Sex.MAN)
                .mapToInt(x -> x.getAge())
                .average()
                .getAsDouble();
        System.out.println(averageMenAge);

        long manWorker = peoples.parallelStream()
                .filter(x -> x.getSex() == Sex.MAN)
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() < 65)
                .count();

        long womanWorker = peoples.parallelStream()
                .filter(x -> x.getSex() == Sex.WOMEN)
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() < 60)
                .count();

        System.out.println(manWorker + womanWorker);

        long stopTime = System.nanoTime();
        double processTime = (double) (stopTime - startTime) / 1_000_000_000.0;
        System.out.println("Process time: " + processTime + " s");
    }
}
