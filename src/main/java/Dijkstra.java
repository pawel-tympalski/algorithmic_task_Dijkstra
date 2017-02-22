

import java.util.*;



public class Dijkstra {
    public static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        
    	int[] dist = new int[adj.length];
    	int infinite = 1000*(adj.length - 1) + 1;
    	int over = infinite + 10;
    	
        for(int i=0;i<adj.length;i++){
        	dist[i]= infinite;
        }
        
        dist[s] = 0;
        
        TreeSet<Pair> set = new TreeSet<Pair>(new Comparator<Object>(){

			public int compare(Object a, Object b) {
			
				if( (((Pair)a).getDistance() > ((Pair)b).getDistance()) && (((Pair)a).getNodeNumber() != ((Pair)b).getNodeNumber())  ){
					return 1;
				}
				else if( ((Pair)a).getDistance() < ((Pair)b).getDistance() && (((Pair)a).getNodeNumber() != ((Pair)b).getNodeNumber()) ){
					return -1;
				}
				else if(((Pair)a).getDistance() == ((Pair)b).getDistance() && (((Pair)a).getNodeNumber() < ((Pair)b).getNodeNumber())) {
					return -1;
				}
				else if(((Pair)a).getDistance() == ((Pair)b).getDistance() && (((Pair)a).getNodeNumber() > ((Pair)b).getNodeNumber())) {
					return 1;
				}
				
				else
					return 0;
			
			}
        });
        
        Pair pair = null;
        for(int i=0;i<adj.length;i++){
        	pair = new Pair(i, dist[i]);
        	set.add(pair);
        }
        
        pair = set.first();
        
        while(pair.getDistance() < over){
        	
        	int nodeNumber = pair.getNodeNumber();
        	List<Integer> list = adj[nodeNumber];
        	
        	for(int i=0; i<list.size();i++){
        		
        		int value = list.get(i);
        		int distance = dist[value];
        		if(dist[value] == infinite){
        			if(dist[value] > dist[nodeNumber] + cost[nodeNumber].get(0)){
        				dist[value] = dist[nodeNumber] + cost[nodeNumber].remove(0);
        				Pair p = new Pair(value,dist[value]);
        				set.remove(new Pair(value,distance));
        				set.add(p);
        			}
        		}
        		else if(dist[value] > dist[nodeNumber] + cost[nodeNumber].get(0)){
        			dist[value] = dist[nodeNumber] + cost[nodeNumber].remove(0);
        			Pair p = new Pair(value,dist[value]);
    				set.remove(new Pair(value,distance));
    				set.add(p);
        			
        		}
        		else{
        			cost[nodeNumber].remove(0);
        		}
        		
        	}
        	
        	int node = pair.getNodeNumber();
        	set.remove(pair);
        	pair = new Pair(node,over);
        	
        	set.add(pair);
        	
        	pair = set.first();
        }
        
        if(dist[t]==infinite){
        	return -1;
        }
        else{
        	return dist[t];
        }
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n < 1 || n > 1000){
        	n = scanner.nextInt();
        }
        int m = scanner.nextInt();
        while(m < 0 || m > 100000){
        	m = scanner.nextInt();
        }
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            
            do{
                x = scanner.nextInt();
                while(x < 1 || x > 1000){
                	x = scanner.nextInt();
                }
                y = scanner.nextInt();
                while(y < 1 || y > 1000){
                	y = scanner.nextInt();
                }	
              }
             while(x == y);
            
            w = scanner.nextInt();
            while(w < 1 || w > 1000){
            	w = scanner.nextInt();
            }
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        
        while(x < 0 || x > 999 ){
       	 x = scanner.nextInt() - 1;
        }
        int y = scanner.nextInt() - 1;
        while(y < 0 || y > 999 ){
       	 	y = scanner.nextInt() - 1;
        }
        System.out.println(distance(adj, cost, x, y));
    }
    
    static class Pair{
		
		int nodeNumber;
		int distance;
		public Pair(int nodeNumber, int distance) {
			super();
			this.nodeNumber = nodeNumber;
			this.distance = distance;
		}
		public int getNodeNumber() {
			return nodeNumber;
		}
		public void setNodeNumber(int nodeNumber) {
			this.nodeNumber = nodeNumber;
		}
		public int getDistance() {
			return distance;
		}
		public void setDistance(int distance) {
			this.distance = distance;
		}
		
		
	}
}
