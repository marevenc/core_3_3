import java.util.*;

public enum Sex {
    MAN,
    WOMEN;

    private static final List<Sex> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Sex randomSex()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}