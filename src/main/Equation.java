package main;

import java.util.List;

import static main.NodesHelper.resolveIndexes;

public class Equation {

	List<Trip> add;
	List<Trip> sub;
	Sign sign;
	double val;
	
	
	
	
	public Equation(List<Trip> add, List<Trip> sub, Sign sign,double val) {
		super();
		this.add = add;
		this.sub = sub;
		this.sign = sign;
		this.val = val;
	}

	public String getStringVal(){
		StringBuilder sb = new StringBuilder();
                System.out.println(add.size() + " | " + sub.size());
		for(Trip t : add)
			sb.append((sb.length() > 0 ? " + " : "") + resolveIndexes(t.name));
		for(Trip t : sub)
			sb.append((sb.length() > 0 ? " - " : "") + resolveIndexes(t.name));
		sb.append(" " + sign.txt);
		sb.append(" " + val);
		return sb.toString();
	}


	public enum Sign{
		LESSEQ("<="),
		MOREEQ(">="),
		EQUAL("=");
		
		private Sign(String txt) {
			this.txt = txt;
		}

		final String txt;
		
		
	}
}
