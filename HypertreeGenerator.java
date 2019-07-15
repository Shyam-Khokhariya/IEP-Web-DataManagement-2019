import java.io.*;
import java.util.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

class HypertreeGenerator {
	public static void main(String arg[]) throws Exception
	{
		Scanner s12 = new Scanner(System.in);
		System.out.print("Enter File Name:");
		String a12=s12.next();
		System.out.println("\n1.Prime\n2.Head\n3.Tail\n4.Simple Tree\n5.Exit");
		System.out.print("Enter the operation to perform on Tree:");
		int ch=Integer.parseInt(s12.next());
		while(ch!=5)
		{

		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		Scanner sc = new Scanner(new File(a12));

		StringBuilder file = new StringBuilder();

		while (sc.hasNextLine())  {
			file.append(sc.nextLine());
		}

		ByteArrayInputStream input =  new ByteArrayInputStream(file.toString().replaceAll(">\\s*<", "><").getBytes("UTF-8"));
		
		Document document = builder.parse(input);

		Element root = document.getDocumentElement();

		//System.out.println("-----------------------------");

		
			Hypertree tree = new Hypertree(root, 0);
		
			if(ch==1)
			{
				tree.prime();
			}	
				
			else if(ch==2)
			{
				System.out.println("Enter Number of Heads :");
				int n12=Integer.parseInt(s12.next());
				tree.head(n12);
			}	

			else if(ch==3)
			{
				System.out.println("Enter Number of Tails :");
				int n12=Integer.parseInt(s12.next());
				tree.tail(n12);
			}


			else if(ch==4)
			{
				System.out.println("Enter Number of simple Trees :");
				int n12=Integer.parseInt(s12.next());
				tree.simpleTree(n12);
			}

			else
				System.out.println("Invalid Choice...");


			tree.print();
			sc.close();	//System.out.println("\n-----------------------------");

			System.out.println("\n\n1.Prime\n2.Head\n3.Tail\n4.Simple Tree\n5.Exit");
			System.out.print("Enter the operation to perform on Tree:");
			ch=Integer.parseInt(s12.next());
		}
		
		// if (args.length > 1) {
		// 	String operation = args[1];
		// 	int param = 1;
		// 	if (args.length == 3) {
		// 		param = Integer.parseInt(args[2]);
		// 	}

		// 	if (operation.equals("prime")) tree.prime();
		// 	if (operation.equals("head")) tree.head(param);
		// 	if (operation.equals("tail")) tree.tail(param);
		// 	if (operation.equals("simpleTree")) tree.simpleTree(param);
		// }


	}
}