import java.util.*;
public class Min {

	public static void main(String[] args) {
		int problemIndex=0;
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		while(true)
		{
			boolean lines[][];
			
			int n=Integer.parseInt(input);
			int linesNum=Integer.parseInt(in.nextLine());
			lines=new boolean[n+1][n*2];
			while(linesNum--!=0)
			{
				String str[]=in.nextLine().split(" ");
				if(str.length==0)
					return;
				if(str[0].equals("H"))
				{
					lines[Integer.parseInt(str[2])][Integer.parseInt(str[1])*2-1]=true;
				}
				else if (str[0].equals("V"))
				{
					lines[Integer.parseInt(str[1])][Integer.parseInt(str[2])*2]=true;
				}
			}
			int result[]=new int[4];
			for(int i=1;i<=n;i++)
			{
				for(int j =1;j<=n;j+=2)
				{
					if(lines[i][j])
					{
						for(int size=1;size<=n-i&&size<n-(j-1)/2;size++)
						{
							boolean ok=true;
							//顶行横
							for(int k =i+1;k<size+i;k++)
							{
								if(!lines[k][j])
								{
									ok=false;
									break;
								}
							}
							if(!ok)
								continue;
							//底行横
							for(int k =i;k<size+i;k++)
							{
								if(!lines[k][2*size+j])
								{
									ok=false;
									break;
								}
							}
							if(!ok)
								continue;
							//左行竖
							for(int k =j+1;k<=(j+1)+(size-1)*2;k+=2)
							{
								if(!lines[i][k])
								{
									ok=false;
									break;
								}
							}
							if(!ok)
								continue;
							//右行竖
							for(int k =j+1;k<=(j+1)+(size-1)*2;k+=2)
							{
								if(!lines[i+size][k])
								{
									ok=false;
									break;
								}
							}
							if(!ok)
								continue;
							result[size]++;
						}
						
					}
				}
				
			}
			problemIndex++;
			if(problemIndex!=1)
			{
				System.out.println();
				System.out.println("**********************************");
				System.out.println();
			}
			System.out.println("Problem #"+problemIndex);
			System.out.println();
			boolean none=true;
			for(int i =1;i<result.length;i++)
			{
				if(result[i]!=0)
				{
					none=false;
					System.out.println(result[i]+" square (s) of size "+i);
				}
			}
			if(none)
			{
				System.out.println("No completed squares can be found.");
			}
			input=in.nextLine();
			if(input.equals(""))
				return;
		}
		
	}

}
