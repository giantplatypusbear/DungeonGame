import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
public class Accesories {
    
    private String[] arrayOfItems;
    private ArrayList<String> listOfItems;

    public Accesories(){
       
        this.arrayOfItems= new String[]{"key","potion","shield", "ring"};
        this.listOfItems=new ArrayList<String>(Arrays.asList(arrayOfItems));
    }

    
    public ArrayList<String> getArrayListOfItems(){
       
        return listOfItems;
    }
    public String randomItem(){
    
        ArrayList<String> listOfItems = getArrayListOfItems();
        Random random = new Random();
        
         // randomly selects an index from the arr
         int select = random.nextInt(listOfItems.size());
         String selectedItem = listOfItems.get(select);
        listOfItems.remove(listOfItems.get(select));
        return selectedItem;

    }

   

    


}
