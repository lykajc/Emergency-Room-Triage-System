package cabillan;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


class Patients{
	private String name;
	private String condition;
	private String arr;
	private int priority;

	public Patients(int priority, String name, String condition, String arr) {
		this.priority = priority;
		this.name = name;
		this.condition = condition;
		this.arr = arr;
	}

	public int compareTo(Patients other) {
		if (this.priority != other.priority) {
			return Integer.compare(this.priority, other.priority);
		}
		return this.arr.compareTo(other.arr);
	}

	public String toString() {
		return "["+ priority +"]" + name + " - " + condition + "(" + arr + ")";
	}
}

class EmQueue{
	private PriorityQueue<Patients>queue;
	public EmQueue() {
		queue = new PriorityQueue<>();
	}

	public void arr(String name, int priority, String condition, String time) {

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



	public class cabillan_labExam2 {

		PriorityQueue<String> pat = new PriorityQueue<>();
		private static final Scanner scan = new Scanner(System.in);	
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

		pat.arr("Pedro Cruz", 1, "Head injury - NOW UNCONSCIOUS ⚠️", "23:52");

		pat.arr("Carlos Mendoza", 2, "Compound fracture - leg", "23:50");

		pat.arr("Lisa Wang", 2, "Severe asthma attack", "23:56");

		pat.arr("Maria Santos", 3, "Deep laceration on arm", "23:48");

		pat.arr("Ana Lim", 4, "Sprained ankle", "23:49");

		pat.displayQueue();

		pat.treatNext();

		pat.displayQueue();

	}
}

