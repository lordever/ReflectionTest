public class ReflectionTestTask {
    private int MEGA_NUMBER = 24;

    private int getMegaNumber() {
        return MEGA_NUMBER;
    }

    public boolean checkMegaNumber() {
        return 42 == getMegaNumber();
    }
}

