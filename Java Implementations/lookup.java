/*
 *  Copyright 2012 Hamed Vahdat-Nejad- University of Isfahan
 *  lookup Method implements context provisioning (look up) function 
 *  in the Heavy-weight middleware layer
 */
import java.sql.*;
import java.lang.*;
public static string lookup (string domain, string entity, string context)
{
    Statement statement=null;
    //Declare object of Statement interface that is used for executing SQL statements
    ResultSet result=null;
    //Declare a result set that is exploited as a table for output data
    string query="SELECT Access_Point FROM domain.getString()"
               + "WHERE (Entity_Name == entity.getString()"
               + "&& (Context == context)";
    result=statement. executeQuery(query);
    return result.getString(1);
    result.close();
    statement.close();  
}
