public class MyJmxObject implements MyJmxObjectMBean {
    public double getRandomNumber() {
        return Math.random();
    }
    public String toUppercase(String string) {
        return (string != null) ? string.toUpperCase() : "";
    }
}
