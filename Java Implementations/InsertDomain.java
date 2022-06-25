/*
 *  Copyright 2012 Hamed Vahdat-Nejad- University of Isfahan
 *  Insert Domain Method implements Insert Domain function 
 *  in the Heavy-weight middleware layer
 */
import java.sql.*;
import java.lang.*;

public static string insertDomain(string name)
{
    // To see if domain name is previously available 
string query1="SELECT Domain_id FROM Domain "
            + "WHERE Domain_Name=name.getString()";
int updateQuery=0;
ResultSet id= null;
//Declare a result set that is exploited as a table for output data
Statement statement=null;
//Declare object of Statement interface that is used for executing SQL statements.

id=statement.executeQuery(query1);
if (id!=null)
    return null //Domain name is previously available and registered.
else
{
    // Insert a New tuple to the Domain table
    string query2= "INSERT INTO Domain"
                 + "(Domain_Name) VALUES "+" (name)";
    updateQuery=statement.executeUpdate(query2);
    
    // retrieve Domain-id
    string query3="SELECT Domain_id FROM Domain"
                + "WHERE Domain_Name=name.getString()";
    id=statement.execute/query(query3);
    
    //Create a new table for this domain
    String query4="CREATE TABLE"
                + "id.getString(1)(ID INTEGER NOT "+" NULL AUTO_INCREMENT"
                + ", Entity_Name VARCHAR(30), Context VARCHAR(30), Access_Point ip,"
                + "Primary Key(ID))";
    updateQuery=statement.executeUpdate(query4);
    return id.getString(1);
}
}
