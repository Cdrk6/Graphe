package graphe2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author mad
 */
public class Open_file {
    
    /**
     * @param args the command line arguments
     */
    public static int[][] loadFile(String args) {
       int [][] data = string2Int(readString(args));   
       /*for(int i =0;i<data.length;++i){
           System.out.print(data[i][0] +" ");
           System.out.print(data[i][1] +" ");
           System.out.println(data[i][2]);    
       }*/
       return data;
    }

    private static int[][] string2Int(String ch)                                 //Convertit une chaine de caractère en double tableau d'entiers
    {
        String[] tl = ch.split("\n");
        String[] tc;
        int[][] tab = new int[tl.length][];
        for(int i = 0; i < tl.length; i++)
        {
            tc = tl[i].split(" ");
            tab[i] = new int[tc.length];
            for(int j = 0; j < tc.length;j++)
                tab[i][j] = Integer.parseInt(tc[j]);
        }
        return tab;
    }
    
        private static String readString(String name)                                //Lit des chaînes de caractères dans le fichier name
    { 
        String txt = "";
        try
        {
            String ligne;
            BufferedReader fichier = new BufferedReader(new FileReader(name));
            while ((ligne = fichier.readLine()) != null) 
            {
                txt += ligne+"\n";
            }
            fichier.close();
        }
        catch (Exception e) {System.out.println("Impossible de lire le fichier \"name\"");}     
        return txt;
    }
    
    private static int[][][] loadFiles(String path)                              //Chargement des fichier dans path
    {
        String na;
        File f = new File(path);
        File[] files = f.listFiles();
        int[][][] tabDat = new int[files.length][][];
        for(int i = 0, ind; i < files.length; i++)
        {
            na = files[i].getName();
            ind = Integer.parseInt(na.substring(0, na.indexOf(".")));
            tabDat[ind] = string2Int(readString(path + na));
        }
        return tabDat;
    }    
    
}
