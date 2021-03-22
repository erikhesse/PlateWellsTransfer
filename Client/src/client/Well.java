package client;

// Well class
// - contains the well properties
public class Well {
    
    String Row = "";
    int Column = 0;
    String Compound = "";
    
    public String RowColumn(){
        return Row + Column;
    }
}
