/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stephen;

/**
 *
 * @author AICS-CEBU
 */
import java.util.Scanner;
import java.sql.*;
public class Stephen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("Input ID:");
        int id = in.nextInt();
        System.out.println("Input First Name:");
        String fname = in.next();
        System.out.println("Input Last Name:");
        String lname = in.next();
        System.out.println("Input Rank:");
        int rank = in.nextInt();
        System.out.println("Input Position:");
        String pos = in.next();
        System.out.println("Input Department:");
        String dep = in.next();
        float salary;
        if(rank == 1)
        {
            salary = 25000;
        }
        else if(rank == 2)
        {
            salary = 15000;
        }
        else  if(rank == 3)
        {
            salary = 12000;
        }
        else 
        {
            salary = 0;
        }
        
        insert(id, fname, lname, rank, pos, dep, salary);
       
    }
    
    static void insert( int id, String fname,String lname, int rank, String pos, String dep, float salary){
        try{
           Class.forName("com.mysql.jdbc.Driver");
           try (Connection con = DriverManager.getConnection(
           "jdbc:mysql://localhost/stephen","root", "")){
           Statement st = con.createStatement();
          
           String sql = "insert into employee values (" + id + ",'" + fname + "','" +
           lname + "'," + rank + ",'" + pos + "','" + dep + "'," + salary + ")";
           
           System.out.println(sql);
           st.executeUpdate(sql);
           con.close();
       }
       }catch(Exception e){System.out.print(e);}
    }
    
}
