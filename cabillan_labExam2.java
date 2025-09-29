
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;



class Patients implements Comparable<Patients> {
    String name;
    int priority;
    String condition;
    String arr;


    public Patients(int priority, String name, String condition, String arr) {
        this.name = name;
        this.priority = priority;
        this.condition = condition;
        this.arr = arr;

    }

    @Override
    public int compareTo(Patients other) {
        if (this.priority != other.priority) {
            return Integer.compare(this.priority, other.priority);
        }
        return this.arr.compareTo(other.arr);
    }

    @Override
    public String toString() {
        return "[" + priority + "]" + name + " - " + condition + "(" + arr + ")";
    }
}


class EmQueue{
    private final PriorityQueue<Patients>queue;
    public EmQueue() {
        queue = new PriorityQueue<>();
    }

    public void arr( int priority, String name , String condition, String time) {

        Patients p = new Patients(priority, name, condition, time);

        queue.add(p);

    }

    public void treatNext() {

        if (queue.isEmpty()) {

            System.out.println(">>> No patients to treat.");

            return;

        }

        Patients next = queue.poll();

        System.out.println("\n>>> Treating patient now...");

        System.out.println("Treated: " + next.toString());

    }


    public void displayQueue() {

        System.out.println("\n=== UPDATED QUEUE ===");

        System.out.println("Patients Waiting: " + queue.size());

        List<Patients> tempList = new ArrayList<>(queue);

        Collections.sort(tempList);

        int count = 1;

        for (Patients p : tempList) {

            System.out.println(count + ". " + p.toString());

            count++;

        }

    }

}

class Main {

    public static void main(String[] args) {

        EmQueue pat = new EmQueue();

        pat.arr(1, "Pedro Cruz", "Head injury - NOW UNCONSCIOUS ⚠️", "23:52");

        pat.arr(2,"Carlos Mendoza","Compound fracture - leg", "23:50");

        pat.arr(2,"Lisa Wang",  "Severe asthma attack", "23:56");

        pat.arr(3,"Maria Santos", "Deep laceration on arm", "23:48");

        pat.arr(4,"Ana Lim", "Sprained ankle", "23:49");

        pat.displayQueue();

        pat.treatNext();

        pat.displayQueue();

    }
}
