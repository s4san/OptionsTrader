package solve;

import java.util.HashMap;
import java.util.Map;

public class GameConstructor {

	public GameConstructor(){
		strategyMap = new HashMap< String, Integer >();
	}
	
	public void setStrategyOf( String strategy, int payOff ) {
		
		strategyMap.put(strategy, payOff );
			
	}
	
	public HashMap<String, Integer> getStrategyMap( ){
		return this.strategyMap;
	}
	
	public int getPayoffOf( String strategy ) throws NullPointerException {
		
		try{
			return strategyMap.get(strategy);
		}
		
		catch( NullPointerException npe ){
			npe.printStackTrace();
		}
		
		return -1;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		
		for( Map.Entry<String, Integer> entry : strategyMap.entrySet() ){
			sb.append(entry.getKey());
			sb.append(" ");
			sb.append(entry.getValue());
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
		
	}
	
	private HashMap< String, Integer > strategyMap; 
}
