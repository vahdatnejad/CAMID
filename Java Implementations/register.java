/*
 *  Copyright 2012 Hamed Vahdat-Nejad- University of Isfahan
 *  Register Method implements context provider registration function 
 *  in the Heavy-weight middleware layer
 */
import java.sql.*;
import java.lang.*;

public static void register(string domain, string entity, string context, ip accessPoint)
{
    int updateQuery=0;
    Statement statement=null;
    //Declare object of Statement interface that is used for executing SQL statements
    ResultSet result=null;
    //Declare a result set that is exploited as a table for output data

    //Insert the characterization of the context provider to the associated Domain table
    string query="INSERT INTO domain.getString()"
    + "(Domain_id, Entity_Name, Context, Access_Point) VALUES "+""
    + " (domain.getString(), entity.getString(), context.getString(), accessPoint)";
    updateQuery=statement.executeUpdate(query);
    result.close();
    statement.close();
}