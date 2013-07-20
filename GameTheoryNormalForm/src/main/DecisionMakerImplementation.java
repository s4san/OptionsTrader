package main;

import solve.GameConstructor;
import solve.GameSolver;

public class DecisionMakerImplementation {
	
	public static void main( String[] args ){
		
		GameConstructor longStrategy = new GameConstructor();
		GameConstructor shortStrategy = new GameConstructor();
		
		GameSolver gs = new GameSolver( longStrategy, shortStrategy );
		
		longStrategy.setStrategyOf("day", 25);
		longStrategy.setStrategyOf("week", 50);
		
		shortStrategy.setStrategyOf("day", 10);
		shortStrategy.setStrategyOf("week", -50);
		
		System.out.println(longStrategy);
		System.out.println(shortStrategy);
		System.out.println(gs);
		System.out.println("Pure Strategy Equilibiria: {Long, Short}: " + gs.getPureStrategyEquilibria() );
		System.out.println("Strictly Dominated Strategies: {Long, Short}: " + gs.getStrictlyDominatedStrategies());
	}

}
