import java.lang.reflect.Field;

public class MainDemo {
    public static void main(String args[]) {
        try {
            start();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static void start() throws NoSuchFieldException, IllegalAccessException {
        ReflectionTestTask reflectionTask = getReflectionTask();
        Field field = getFieldFromReflectionTask(reflectionTask);
        setAttributeAndOutResult(field, reflectionTask);
    }

    private static ReflectionTestTask getReflectionTask() {
        return new ReflectionTestTask();
    }

    private static Field getFieldFromReflectionTask(ReflectionTestTask reflectionTask) throws NoSuchFieldException {
        return reflectionTask.getClass().getDeclaredField("MEGA_NUMBER");
    }

    private static void setAttributeAndOutResult(Field field, ReflectionTestTask reflectionTask) throws IllegalAccessException {
        field.setAccessible(true);
        field.setInt(reflectionTask, 42);
        System.out.println(reflectionTask.checkMegaNumber());
    }
}
