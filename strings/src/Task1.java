/**
 * Created by Dmitriy on 13.01.2020.
 */
class WaterSource {
    private String s;
    WaterSource() {
        System.out.println("WaterSource()");
        s = "сконструирован";
    }

    public String toString() {
        return s;
    }
}

public class Task1 {
    private String valve1, valve2, valve3, valve4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("valve1 = "); sb.append(valve1); sb.append(" ");
        sb.append("valve2 = "); sb.append(valve2); sb.append(" ");
        sb.append("valve3 = "); sb.append(valve3); sb.append(" ");
        sb.append("valve4 = "); sb.append(valve4); sb.append("\n");
        sb.append("i = ");      sb.append(i);      sb.append(" ");
        sb.append("f = ");      sb.append(f);      sb.append(" ");
        sb.append("source = ");      sb.append(source);
        return sb.toString();
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        System.out.println(task1);
    }
}
