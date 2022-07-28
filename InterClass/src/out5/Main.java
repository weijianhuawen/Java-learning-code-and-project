package out5;

import java.util.Arrays;
import java.util.Comparator;

class Preson {
    public String name;
    public Integer id;
    public Preson(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Preson{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
class PersonComparator implements Comparator<Preson> {
    @Override
    public int compare(Preson o1, Preson o2) {
        return o1.name.compareTo(o2.name);
    }
}
public class Main {
    public static void main(String[] args) {
        Preson preson1 = new Preson("aboluo", 24);
        Preson preson2 = new Preson("zhousi", 25);
        Preson preson3 = new Preson("syyfjy", 2);
        Preson[] presons = {preson1, preson2, preson3};
        Arrays.parallelSort(presons, new PersonComparator());
        System.out.println(Arrays.toString(presons));
    }
}
