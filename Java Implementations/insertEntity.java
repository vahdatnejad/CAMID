/*
 *  Copyright 2012 Hamed Vahdat-Nejad- University of Isfahan
 *  Insert Entity Method implements Insert Entity function 
 *  in the Heavy-weight middleware layer
 */
import java.sql.*;
import java.lang.*;
public static int insertEntity (string name, string domain, 
                                string [] similar_Name, char ch)
{
    int updateQuery=0;
    ResultSet result=null;
    //Declare a result set that is exploited as a table for output data
    ResultSet id=null;
    
// To see if the entity has  previously existed in the specified domain
    string query1="SELECT Entity_Name FROM Domain"
                + "WHERE Entity_Name=name.getString()";
    Statement statement=null;
//Declare object of Statement interface that is used for executing SQL statements.

    result=statement.executeQuery(query1);
    if (result != null)   //The entity previously exists in the specified domain
        return -1;
    else if (ch='N')     //The user is not sure to insert the entity
    {
        string query2="SELECT Domain_id FROM Domain";
        result=null;
        result=statement.executeQuery(query2);
        
        //To see if similar entities exist in other domains
        int index=0;
        while (result.next())
        {
            string query3="SELECT Domain_id FROM result.getString(1)"
                        + "WHERE Entity_Name=name";
            id=null;
            id=statement.executeQuery(query3);
            if (id != null)
            {
                similar_Name[index]=id.getString(1);
                index++;
            }

        }   
        if (index > 0)   //There are similar entities in other domain
            return 0;   /*Entity Insertion has not performed
             * due to similar entity names in other domains */   
    }
    if (ch='Y')    // The user is sure to insert the entity
    {
        string query4="INSERT INTO Domain (Domain_id, Entity_Name)"
                    + "VALUES "+" (domain, name)";
        updateQuery=statement.executeUpdate(query4);
        return 1;   //Entity Insertion was performed
    }
}