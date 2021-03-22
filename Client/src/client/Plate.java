package client;

import java.util.ArrayList;
import java.util.List;

// Plate class
// - contains the plate and well properties
public class Plate {

    String Name = "";                           // Plate name
    List<Well> Wells = new ArrayList<Well>();   // List of well objects
    
    // AddWell
    // - add the well object to the Wells list
    public void AddWell(Well well){
        
        Wells.add(well);
    }
    
    // AddWell
    // - create a new well object, set the well properties and then add to the Wells list
    public void AddWell(String strRow, int iColumn, String strCompound){
        
        Well well = new Well();
        well.Row = strRow;
        well.Column = iColumn;
        well.Compound = strCompound;
        
        AddWell(well);
    }
    

}
