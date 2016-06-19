package com.islam.levels;

import java.sql.*;

public class Driver {
    public int[] sqlTiles = new int[551];
    public int Levels =5;

    public Driver() {

        System.out.println("get to driver ");

        int i = 0, x = 0;


        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamesql", "root","");
            Statement myStmt = myConn.createStatement();
            CallableStatement cStmt = myConn.prepareCall("{CALL chooselvl(?)}");
            cStmt.setInt(1, Levels);
            cStmt.execute();
            ResultSet myRs = cStmt.getResultSet();
            System.out.println(myRs);
            // ResultSet myRs = myStmt.executeQuery("select * from maps WHERE levels=5 ORDER BY id ASC ");
            //System.out.println("rowwww");
            while (myRs.next()) {
                //System.out.println(myRs.getString("id_row")+","+ myRs.getString("Rowcomp"));
                String row = myRs.getString("rows");

                for (i = 0; i < row.length(); i++) {
                    if (row.charAt(i) == 'n') { sqlTiles[x] = -16777216; x++; }
                    if (row.charAt(i) == 'b') { sqlTiles[x] = -15990529;  x++; }
                    if (row.charAt(i) == 'g') {sqlTiles[x] = -12566464;  x++; }
                    if (row.charAt(i) == 'm') {sqlTiles[x] = -8441088;  x++; }
                }
            }

            //System.out.println(rownss);
            //System.out.println(x);

            Level.tiles = sqlTiles.clone();

            CallableStatement cStmt2 = myConn.prepareCall("{CALL mapItems(?)}");
            cStmt2.setInt(1,1);
            cStmt2.execute();
            ResultSet myRs2 = cStmt2.getResultSet();
            String Items = null;
            while (myRs2.next()) {

                Items = myRs2.getString("cordon");
                Mapobjects mapa = new Mapobjects(Items);

            }


            myConn.close();


            System.out.println("Tiles Cloned");


        } catch (Exception exc) {
            exc.printStackTrace();
            System.out.println("erreur");
        }
    }
}