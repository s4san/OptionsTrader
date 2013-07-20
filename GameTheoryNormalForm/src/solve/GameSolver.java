package solve;

import java.util.Map;

public class GameSolver {

		public GameSolver( GameConstructor person1, GameConstructor person2 ){
			this.person1 = person1;
			this.person2 = person2;
		}
		
		public String getPureStrategyEquilibria(){
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("{");
			
			int maxPerson1 = Integer.MIN_VALUE;
			String keyP1 = ""; 
			for( Map.Entry<String, Integer> entry : person1.getStrategyMap().entrySet() ){
				if( entry.getValue() > maxPerson1 ){
					maxPerson1 = entry.getValue();
					keyP1 = entry.getKey();
				}
			}
			
			int maxPerson2 = Integer.MIN_VALUE;
			String keyP2 = "";
			for( Map.Entry<String, Integer> entry : person2.getStrategyMap().entrySet() ){
				if( entry.getValue() > maxPerson2 ){
					maxPerson2 = entry.getValue();
					keyP2 = entry.getKey();
				}
			}
			
			sb.append(keyP1);
			sb.append(",");
			sb.append(keyP2);
			sb.append("}");
			
			return sb.toString();
		}
		
		public String getStrictlyDominatedStrategies(){
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("{");
			
			int minPerson1 = Integer.MAX_VALUE;
			String keyP1 = ""; 
			for( Map.Entry<String, Integer> entry : person1.getStrategyMap().entrySet() ){
				if( entry.getValue() < minPerson1 ){
					minPerson1 = entry.getValue();
					keyP1 = entry.getKey();
				}
			}
			
			int minPerson2 = Integer.MAX_VALUE;
			String keyP2 = ""; 
			for( Map.Entry<String, Integer> entry : person2.getStrategyMap().entrySet() ){
				if( entry.getValue() < minPerson2 ){
					minPerson2 = entry.getValue();
					keyP2 = entry.getKey();
				}
			}
			
			sb.append(keyP1);
			sb.append(",");
			sb.append(keyP2);
			sb.append("}");
			
			return sb.toString();
		}
		
		@Override
		public String toString( ){
			StringBuilder sb = new StringBuilder();
			sb.append("Long");
			sb.append("    ");
			sb.append("Short");
			sb.append(System.getProperty("line.separator"));
			sb.append("-------------");
			sb.append(System.getProperty("line.separator"));
			sb.append("      ");
			for( Map.Entry<String,Integer> entryColumn : person2.getStrategyMap().entrySet() ){
				sb.append(entryColumn.getKey());
				sb.append(" | ");
			}
			
			sb.append(System.getProperty("line.separator"));
			
			for( Map.Entry<String, Integer> entryRow : person1.getStrategyMap().entrySet() ){
				sb.append(entryRow.getKey());
				sb.append("  ");
				for( Map.Entry<String,Integer> entryColumn : person2.getStrategyMap().entrySet() ){
					sb.append(entryRow.getValue());
					sb.append(",");
					sb.append(entryColumn.getValue());
					sb.append(" ");
				}
				sb.append(System.getProperty("line.separator"));
			}
			
			return sb.toString();
		}
		
		private GameConstructor person1;
		private GameConstructor person2;
}
