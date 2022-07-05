
import java.sql.*;
public class JDBCJava {
	public static void main(String[]args)throws Exception
	{
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","Root");
			Statement st=con.createStatement();
			
	ResultSet rs=st.executeQuery("select *from jdbcmovies");
		/*
			//printing Sno.,Movie name and Release year
			String data="";
			while(rs.next()) 
			{
				data=rs.getInt(1)+" : "+rs.getString(2)+" - "+rs.getInt(6);
				System.out.println(data);
			 }
			//Movie details end
		*/
		/*
			//inserting new data
			String q1="insert into jdbcmovies values(8,'Badri','Pawan Kalyan','Renu Desai'+ 'Puri Jagannadh',2000)";
			int ins=st.executeUpdate(q1);
			System.out.println(ins+ " rows affected");
			//inserting data end
			
			*/
System.out.println("The Table Contents:\n");
			while(rs.next()) {
				int Sno=rs.getInt("Sno.");
				String MoviName=rs.getString("MoviName");
				String Actor=rs.getString("Actor");
				String Actress=rs.getString("Actress");
				String Director=rs.getString("Director");
				int YearOfRelease=rs.getInt("YearOfRelease");
				System.out.println(Sno+" - "+ Actor+" - "+Actress+" - "+Director+" - " +YearOfRelease+"\n");
			}
			
				
				System.out.println("\n\nMovies based on Actor's name:");
			
				ResultSet r1=st.executeQuery("select MoviName from jdbcmovies where Actor ='Pawan Kalyan'");
				while(r1.next()) {
					String MoviName=r1.getString("MoviName");
					//String Actor=r1.getString("Actor");
					System.out.println(MoviName+",");
				}
				
		    rs.close();
			r1.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
			
	}
	

}

/*use actor or actress name to retrieve table
also print whole table using select stmt*/


