import java.lang.reflect.Field;

public class Main {
    public static void main(String args[]) {
        try {
            start();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static void start() throws NoSuchFieldException, IllegalAccessException {
        ReflectionTest reflectionTask = getReflectionTask();
        Field field = getFieldFromReflectionTask(reflectionTask);
        setAttributeAndOutResult(field, reflectionTask);
    }

    private static ReflectionTest getReflectionTask() {
        return new ReflectionTest();
    }

    private static Field getFieldFromReflectionTask(ReflectionTest reflectionTask) throws NoSuchFieldException {
        return reflectionTask.getClass().getDeclaredField("MEGA_NUMBER");
    }

    private static void setAttributeAndOutResult(Field field, ReflectionTest reflectionTask) throws IllegalAccessException {
        field.setAccessible(true);
        field.setInt(reflectionTask, 42);
        System.out.println(reflectionTask.checkMegaNumber());
    }
}
