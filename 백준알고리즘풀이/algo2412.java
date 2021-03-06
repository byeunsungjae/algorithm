package algo;
/*
  메모리 초과
  hashmap을 key=좌표(point) value=현재까지의 최소 거리
  현재좌표에서 3사분면 빼고 1,2,4사분면만 탐색함
 */
import java.util.*;
import java.awt.*;
import java.io.*;
public class algo2412  {
	static int n;
	static int h;
	static int min=Integer.MAX_VALUE-1;
	static HashMap map=new HashMap();
	static Queue q=new LinkedList();
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		if(min==Integer.MAX_VALUE-1)System.out.println(-1);
		else System.out.println(min);
	}
	
	static void input() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str[]=br.readLine().split(" ");
		n=Integer.parseInt(str[0]);h=Integer.parseInt(str[1]);
		map.put(new Point(0,0), 0);
		for(int i=0;i<n;i++) {
			str=br.readLine().split(" ");
			int tempx=Integer.parseInt(str[0]);
			int tempy=Integer.parseInt(str[1]);
			map.put(new Point(tempx,tempy),Integer.MAX_VALUE-1);
		}
	}
	
	static void bfs() {
		q.add(new Point(0,0));
		
		while(!q.isEmpty()) {
			Point p=(Point)q.poll();
			int nowcount=(int)map.get(p);
			
			if(p.y==h) {
				min=Math.min(nowcount, min);
				continue;
			}
			for(int i=-2;i<=2;i++) {
				for(int j=-2;j<=2;j++) {
					if((i<=0&&j<=0))continue;
					int x=p.x+i; int y=p.y+j;
					if(x>=0&&y>=0&&map.containsKey(new Point(x,y))) {
						int cnt=(int)map.get(new Point(x,y));
						if(cnt>=nowcount+1) {
							map.put(new Point(x,y),nowcount+1);
							q.add(new Point(x,y));
						}
					}
				}
			}
		}
	}
}

//Set set=map.keySet();
//Iterator iterator=set.iterator();
//		while(iterator.hasNext()){
//
//			  Point key = (Point)iterator.next();
//
//			  System.out.println(key);
//
//			}
