package com.der.Dijkstra;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Test;


public class AppTest {
    
	@Test
	public void firstTest(){
		//String input = "4 4 1 2 1 4 1 2 2 3 2 1 3 5 3 1";
		//String input = "1 0 1 1";
		//String input = "5 9 1 2 4 1 3 2 2 3 2 3 2 1 2 4 2 3 5 4 5 4 1 2 5 3 3 4 4 1 5";
		String input = "3 3 1 2 7 1 3 5 2 3 2 3 2";
		//String input="4 3 1 2 1 2 3 2 1 3 5 4 3";
		//String input ="4 3 1 2 1 2 3 2 1 3 5 3 4";
		
		//StringBuilder sb = new StringBuilder();
		//sb.append("1000 ");
		//sb.append("999 ");
		
		//for(int i = 1; i <= 999; i++){
			//int j = i;
			//sb.append(i + " ");
			//++j;
			//sb.append(j + " ");
			
			//sb.append(1000 + " ");
		//}
		
		//sb.append("1 ");
		//sb.append("1000");
		
		//String input = sb.toString();
		
		Scanner scanner = new Scanner(input).useDelimiter(" ");
		
		
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
        int output = Dijkstra.distance(adj, cost, x, y);
        
        assertEquals(3,output);
	}
	
	@Test
	public void secondTest(){
		String input = "5 9 1 2 4 1 3 2 2 3 2 3 2 1 2 4 2 3 5 4 5 4 1 2 5 3 3 4 4 1 5";
		Scanner scanner = new Scanner(input).useDelimiter(" ");
		
		
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        
        int output = Dijkstra.distance(adj, cost, x, y);
        
        assertEquals(6,output);
	}
	
	@Test
	public void thirdTest(){
		String input = "3 3 1 2 7 1 3 5 2 3 2 3 2";
		Scanner scanner = new Scanner(input).useDelimiter(" ");
		
		
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        
        int output = Dijkstra.distance(adj, cost, x, y);
        
        assertEquals(-1,output);
	}
	
	@Test
	public void massiveDAta(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("1000 ");
		sb.append("999 ");
		
		for(int i = 1; i <= 999; i++){
			int j = i;
			sb.append(i + " ");
			++j;
			sb.append(j + " ");
			
			sb.append(1000 + " ");
		}
		
		sb.append("1 ");
		sb.append("1000");
		
		String input = sb.toString();
		
		
		
		
		
		
		
		Scanner scanner = new Scanner(input).useDelimiter(" ");
		
		
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        
        int output = Dijkstra.distance(adj, cost, x, y);
        
        assertEquals(999000,output);
	}
}
