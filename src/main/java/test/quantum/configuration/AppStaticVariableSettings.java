package test.quantum.configuration;

public final class AppStaticVariableSettings {

    private AppStaticVariableSettings() {}

    private static int countGenerateEmployee = 5;

    public static void setCountGenerateEmployee(int val) {
        countGenerateEmployee = val;
    }
    public static int getCountGenerateEmployee() {
        return countGenerateEmployee;
    }

}