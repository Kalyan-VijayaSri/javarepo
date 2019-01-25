import java.io.*;
import java.lang.String;
public class Employee
{
	public static void main(String args[ ]) throws IOException 
	{
		String fname = "CR24.txt";
		String infofile = "CR24.inf";
		String htmfile = "CR24.htm";
			int n = args.length;
			
			if (n == 2) {
				if (args[0].equals("-b"))
					fname = args[1];
				else if (args[0].equals("-l"))
					infofile = args[1];
				else if (args[0].equals("-o"))
					htmfile = args[1];
			}
			else if (n == 4) {
				if (args[0].equals("-b")) {
					fname = args[1];
					if (args[2].equals("-l"))
						infofile = args[3];
					else if (args[2].equals("-o"))
						htmfile = args[3];
				}
				else if (args[0].equals("-l")) {
					infofile = args[1];
					if (args[2].equals("-b"))
						fname = args[3];
					else if (args[2].equals("-o"))
						htmfile = args[3];
				}
				else if (args[0].equals("-o")) {
					htmfile = args[1];
					if (args[2].equals("-b"))
                                                fname = args[3];
                                        else if (args[2].equals("-l"))
                                                infofile = args[3];
				}
			}
			else if (n == 6) {
				if (args[0].equals("-b")) {
					fname = args[1];
					if (args[2].equals("-l")) {
						infofile = args[3];
						if (args[4].equals("-o")) 
							htmfile = args[5];
					}
					else if (args[2].equals("-o")) {
						htmfile = args[3];
						if (args[4].equals("-l"))
							infofile = args[5];
					}
				}
				else if(args[0].equals("-l")) {
					infofile = args[1];
					if (args[2].equals("-b")) {
						fname = args[3];
						if (args[4].equals("-o"))
							htmfile = args[5];
					}
					else if (args[2].equals("-o")) {
						htmfile = args[3];
						if (args[4].equals("-b"))
							fname = args[5];
					}
				}
				else if(args[0].equals("-o")) {
					htmfile = args[1];
					if (args[2].equals("-b")) {
						fname = args[3];
						if (args[4].equals("-l"))
							infofile = args[5];
					}
					else if (args[2].equals("-l")) {
						infofile = args[3];
						if (args[4].equals("-b"))
							fname = args[5];
					}
				}
			}
		BufferedReader br = new BufferedReader(new FileReader(fname));  //To read input from text file.
		BufferedReader brw = new BufferedReader(new FileReader(infofile));
		BufferedWriter wr = new BufferedWriter(new FileWriter(htmfile)); //Reading output in html file.
		String s;
		String s1;
		String s2;
		s=br.readLine();
		s1=brw.readLine();
		s2=brw.readLine();
		int c;
		s = s.replace(" ","");     // Using replace predefined Funtion to remove spaces.
		String str[] =  s.split(","); // Using split predefined Function to remove comma.
		int max[] = new int[(str.length)-3];
		int min[] = new int[(str.length)-3];
		String topper[] = new String[(str.length)-3];
		String lagger[] = new String[(str.length)-3];
		for (int i = 3; i < str.length; i++)
		{
			max[i-3] = Integer.parseInt(str[i]);
			min[i-3] = Integer.parseInt(str[i]);
			topper[i-3] = str[1];
			lagger[i-3] = str[1];

		}
		wr.write("\n<html>");
		wr.write("\n<title>Employee details:</title>");
		wr.write("\n<body style=\"background-color: white;\">");
		wr.write("\n<marquee \"wid='40%'; dir='left'; height='20%'\";><p style = \"background-color:Tomato;\"><i><font size='15';>Employee Details</font size></b></i></p></marquee>");
		String str1[] = s1.split(",");
		String str2[] = s2.split(",");
		int count[] = new int[(str.length)-3];
		while (s!=null)
		{
			s = s.replace(" ","");
			String arr[] = s.split(",");
			int total=0;
			wr.write("\n<h1><b>Emp#:"+ arr[0]+"</b></h1>");
			wr.write("\n<h2><b>Ename:"+ arr[1]+"</b></h2>");
			wr.write("\n<b>Email :</b><a href=\"[a-z].globaledgesoft.com\":"+ arr[2]+">"+arr[2]+"</a><br><br>");
			wr.write("\n<table style = \"color:Black;  width :100%; \" border ='1' >");
			wr.write("\n<tr \" bgcolor = White \" >");
			for (int i = 3; i < arr.length; i++)
			{
				wr.write("\n<th \"bgcolor = #00FFFF \">m"+(i-2)+"</th>");
			}
				wr.write("\n<th>Total</th>");
				wr.write("\n</tr>");
				wr.write("\n<tr \" bgcolor = Cyan \">");
			for (int i = 3; i < arr.length; i++)
			{ 
				int per;
				int val=Integer.parseInt(arr[i]);
				int tot=Integer.parseInt(str2[i]);
				per = (val*100)/tot;
					/*if(val>100 && val <0)
					{
						wr.write("\n Invalid Input");
						count[i]++;		
						continue;
					} */
					if(per<50) {
		wr.write("\n<td style= \" background-color:Red; color:white\"; >"+arr[i]+"</td>");					
					}
					else if((per>=50) && (per<60)) {
		wr.write("\n<td style= \" background-color:Orange; color:black\"; >"+arr[i]+"</td>");
					}
					else if((per>=60) && (per<65)) {
		wr.write("\n<td style= \" background-color:Yellow; color:black\"; >"+arr[i]+"</td>");
					}
					else if(per>=65) {
		wr.write("\n<td style= \" background-color:Green; color:white\"; >"+arr[i]+"</td>");
					}
					
			//	wr.write("\n<td >"+arr[i]+"</td>");
				total+=val;
				if(max[i-3]==val) 
				{
					if((topper[i-3].equals(arr[1]))!=true)
						topper[i-3]+=","+arr[1];
					
				}
				if(min[i-3]==val)
				{
					if((lagger[i-3].equals(arr[1]))!=true)
						lagger[i-3]+=","+arr[1];
				}
				if (max[i-3] < val) 
				{
					max[i-3] = val;
					topper[i-3] = arr[1];
				}
				if (min[i-3] > val)
				{
					min[i-3] = val;
					lagger[i-3] = arr[1];
				}
			}
				wr.write("\n<th>Total:"+ total+"</th>"); //printing total
				wr.write("\n</tr></table></br>");
			s = br.readLine();
		}
				wr.write("\n<table style = \"background-color:powder-blue; color:Black; width:100%;\" border = '10';>");
				wr.write("\n<tr>");
				wr.write("<th>DETAILS</th>");
			for(int i = 3; i < str.length; i++)
			{
				wr.write("\n<th>m"+(i-2)+" </th>");
			}
				wr.write("\n</tr><tr><th>MIN SCORE</th>");
			for(int i = 0; i < min.length; i++)
			{
				wr.write("\n<td>"+min[i]+"</td>");
			}                   
				wr.write("\n</tr><tr><th>MAX SCORE</th>");
			for(int i = 0; i < max.length; i++)
			{
				wr.write("\n<td>"+max[i]+"</td>");	
			}
				wr.write("\n</tr><tr><th>TOPPER</th>");
			for(int i = 0;i<topper.length;i++)
			{
				wr.write("\n<td \" bgcolor = green\"; >"+topper[i]+"</td>");
			}
				wr.write("\n</tr><tr><th>LAGGER</th>");
			for(int i = 0;i<lagger.length; i++)
			{
				wr.write("\n<td \" bgcolor = Brown\";>"+lagger[i]+"</td>");
			}
				wr.write("\n</tr></table></body></html>");
		
		br.close();
		wr.close();
	}
}
