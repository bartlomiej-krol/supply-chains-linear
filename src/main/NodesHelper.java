package main;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class NodesHelper {

	
	public static List<Equation> getBrokerEq(List<Trip> trips, Node node){
		int id = node.id;
		List<Trip> add = new ArrayList<>();
		List<Trip> sub = new ArrayList<>();
		List<Equation> equations = new ArrayList<>();
		System.out.println("B: "+ id);
		
		for (Trip t : trips){
			if(t.from == id)
				add.add(t);
                        else if(t.to == id)
				sub.add(t);
		}
		equations.add(new Equation(add, sub, Equation.Sign.EQUAL, 0.0));

		add = new ArrayList<>();
		sub = new ArrayList<>();

		for (Trip t : trips){
			if(t.to == id)
				add.add(t);
		}
		equations.add(new Equation(add, sub, Equation.Sign.LESSEQ, node.value));

		return equations;
	}
	
	
	public static Equation getProviderEq(List<Trip> trips, Node node){
		int id = node.id;
		List<Trip> add = new ArrayList<>();
		List<Trip> sub = new ArrayList<>();
		System.out.println("P: "+ id);
		
		
		for (Trip t : trips){
			if(t.from == id)
				add.add(t);
                        else if(t.to == id)
				sub.add(t);
		}
		return new Equation(add, sub, Equation.Sign.LESSEQ, node.value);
	}
	
	public static Equation getReceiverEq(List<Trip> trips, Node node){
		int id = node.id;
		List<Trip> add = new ArrayList<>();
		List<Trip> sub = new ArrayList<>();
		System.out.println("R: "+ id + " -- " + trips.size());
		
		for (Trip t : trips){
                        System.out.println(t);
			if(t.to == id)
				add.add(t);
                        else if(t.from == id)
				sub.add(t);
		}
		return new Equation(add, sub, Equation.Sign.MOREEQ, node.value);
	}

	static String resolveIndexes(String stringVal) {
		String[] letters = stringVal.split("");
		StringBuilder sb = new StringBuilder();
		for (String letter: letters) {
			if(StringUtils.isNumeric(letter))
				sb.append(Integer.parseInt(letter)+1);
			else
				sb.append(letter);
		}
		return sb.toString();
	}
	
}
