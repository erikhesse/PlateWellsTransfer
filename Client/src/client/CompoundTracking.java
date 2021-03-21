package client;

import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;

import java.io.FileWriter;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.NamedNodeMap;

public class CompoundTracking {
    
    private String strCompoundsFileName = "C:\\Projects\\PlateWellsTransfer\\Client\\Compounds.xml";
    private String strPlatesFileName = "C:\\Projects\\PlateWellsTransfer\\Client\\Plates.xml";
    
    public CompoundTracking() {
        super();
    }
    
    // GetCompoundsXMLDocument
    // - return the XMLDom for the Compounds XML
    private Document GetCompoundsXMLDocument(){
        
        return GetXMLDocument(strCompoundsFileName);
    }
    
    // GetPatesXMLDocument
    // - return the XMLDom for the Plates XML
    private Document GetPatesXMLDocument(){
        
        return GetXMLDocument(strPlatesFileName);
    }

    // GetXMLDocument
    // - read xml file into Document object and return it to the caller
    private Document GetXMLDocument(String strFilename){
        
        Document doc = null;
        
        try
        {
            File file = new File(strFilename);
            
            //an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
            //an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();  
            doc = db.parse(file);  
            doc.getDocumentElement().normalize();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        return doc;
    }
    
    // GetCompounds
    // - Read the compounds from the XML Document object and return a string array
    public String[] GetCompounds(){
        
        String[] strCompounds = null;
        
        try
        {
            // Create the XML Document and get a node list of compound elements
            Document doc = GetCompoundsXMLDocument();
            Element root = doc.getDocumentElement();
            NodeList nodeListCompounds = root.getElementsByTagName("Compound");  

            // Instantiate the string array size for the number of compounds found 
            strCompounds = new String[nodeListCompounds.getLength()];
            
            // nodeList is not iterable, so we are using for loop  
            for (int i = 0; i < nodeListCompounds.getLength(); i++)   
            {  
                // Get the compound node
                Node node = nodeListCompounds.item(i);  
                
                // Check if node is element
                if (node.getNodeType() == Node.ELEMENT_NODE)   
                {  
                    // Get the CompoundID from the well element
                    Element eElement = (Element) node;  
                    String strCompoundID = eElement.getElementsByTagName("id").item(0).getTextContent();
                    
                    // Store the CompoundID into the string array
                    strCompounds[i] = strCompoundID;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        // Return the Compounds string array
        return strCompounds;
    }
    
    // SaveCompounds
    // - save the compounds in the string array to the XML file 
    public void SaveCompounds(String[] strCompounds){
        
        try
        {
            // Define a factory to obtain a pasrer for the XML document
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
                
            // Create the root Compounds element and add to the document object
            Element root = doc.createElement("Compounds");
            doc.appendChild(root);
            
            // Loop through the compounds string array 
            for(int i = 0; i < strCompounds.length; i++) 
            {
                // Create a new Compound element
                Element compound = doc.createElement("Compound");
                // Add the Compound element
                root.appendChild(compound);
                
                // Create the id element and add it to the Compound
                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(strCompounds[i]));
                compound.appendChild(id);
            }
       
            // Create the transforer factory and transfor object 
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            
            // Create a new DOM to save the XML Document
            DOMSource source = new DOMSource(doc);
            // Create the file writer with the specified file location of the Compounds XML file
            FileWriter writer = new FileWriter(new File(strCompoundsFileName));
            // Create the stream writer object of the file and use the trasformer object to send the
            // XML Document to the file
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    // SavePlates
    // - save the plates in the List to the XML file 
    public void SavePlates(List<Plate> plates){
        
        try
        {
            // Define a factory to obtain a pasrer for the XML document
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
                
            // Create the root Compounds element and add to the document object
            Element root = doc.createElement("Plates");
            doc.appendChild(root);
            
            // Loop through the plates list
            for(int iPlate = 0; iPlate < plates.size(); iPlate++) 
            {
                // Create a new Compound element
                Element plate = doc.createElement("Plate");
                // Add the Compound element
                root.appendChild(plate);
                
                // Create the Name element and add it to the Plate element
                Element name = doc.createElement("Name");
                name.appendChild(doc.createTextNode(plates.get(iPlate).Name));
                plate.appendChild(name);
                
                // Loop through the wells list
                for(int iWell = 0; iWell <plates.get(iPlate).Wells.size(); iWell++ ){
                    
                    // Create the Well element
                    Element well = doc.createElement("Well");
                    // Add the well attributes to the Well element                    
                    well.setAttribute("Row", plates.get(iPlate).Wells.get(iWell).Row);
                    well.setAttribute("Column", String.valueOf(plates.get(iPlate).Wells.get(iWell).Column));
                    well.setAttribute("Compound", plates.get(iPlate).Wells.get(iWell).Compound);
                    plate.appendChild(well);
                }
            }
       
            // Create the transforer factory and transfor object 
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            
            // Create a new DOM to save the XML Document
            DOMSource source = new DOMSource(doc);
            // Create the file writer with the specified file location of the Plates XML file
            FileWriter writer = new FileWriter(new File(strPlatesFileName));
            // Create the stream writer object of the file and use the trasformer object to send the
            // XML Document to the file
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    // GetPlates
    // - Read the plates from the XML Document object and return a string array
    public List<Plate> GetPlates(){
        
        List<Plate> plates = new ArrayList<Plate>();
        
        try
        {
            // Create the XML document and get a node list of the plate elements
            Document doc = GetPatesXMLDocument();
            Element root = doc.getDocumentElement();
            NodeList nodeListPlates = root.getElementsByTagName("Plate");  
            
            // Loop through the node list of plate found in the XML file
            for (int iPlates = 0; iPlates < nodeListPlates.getLength(); iPlates++)   
            {  
                // Get the plate node from the node list
                Node nodePlate = nodeListPlates.item(iPlates);  
                
                // Check if node is element node
                if (nodePlate.getNodeType() == Node.ELEMENT_NODE)   
                {  
                    // Get the string of the Name element
                    Element ePlate = (Element) nodePlate;  
                    String strPlate = ePlate.getElementsByTagName("Name").item(0).getTextContent();
                    
                    // Create the Plate object, set the name and add to the Plates ArrayList
                    Plate plate = new Plate();
                    plate.Name = strPlate;
                    plates.add(plate);
                    
                    // Get a node list of wells found in the plate
                    NodeList nodeListWells = ePlate.getElementsByTagName("Well");
                    
                    // Loop through the wells node list 
                    for(int iWells = 0; iWells < nodeListWells.getLength(); iWells++) 
                    {
                        // Get the attributes of the well element
                        NamedNodeMap nodeMap = nodeListWells.item(iWells).getAttributes();
                        String strRow = nodeMap.getNamedItem("Row").getTextContent();
                        int iColumn = Integer.parseInt( nodeMap.getNamedItem("Column").getTextContent());
                        String strCompound = nodeMap.getNamedItem("Compound").getTextContent();
                        // Add the well to the plate list object
                        plate.AddWell(strRow, iColumn, strCompound);
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        // Return the plate list 
        return plates;
    }
}
