import java.util.ArrayList;
import java.util.Scanner;
public class Inventory {
    private ArrayList<String> items;
    private Hero hero;
   

    public Inventory(){
        this.items= new ArrayList<String>();
        this.hero= new Hero();
        
    }

    public ArrayList<String> getItems(){
        return items;
    }

    public void addItems(String item){
    
        Scanner input= new Scanner(System.in);
        String answer= input.nextLine();
        if(answer.equals("yes")){
        if(items.size()<3){
        items.add(item);
    System.out.println(item+" successfully added to inventory");
    
}
        else{
            System.out.println("Too many items in inventory");
            dropItems();
        }
    }
    if(answer.equals("no")){
        System.out.println("");
    }
    }
    
    public void dropItems(){
        Scanner input= new Scanner(System.in);
        System.out.println("Would you like to drop an item? Type 'yes' or 'no'");
        String answer= input.nextLine();
        if(answer.equals("yes")){
            System.out.println("Type in the item you would like to drop.");
            System.out.print("Current inventory: ");
            for(int i=0; i<items.size();i++){
                System.out.print(items.get(i)+" ");
            }
            String drop = input.nextLine();
            items.remove(drop);
            
        }

    }
    public void accesoryPoints(String item){
        if (item.equals("key")){
            System.out.println("Access to final room aquired");
        }
        if (item.equals("potion")){
            System.out.println("health +1");
        }
        if (item.equals("shield")){
            System.out.println("damage taken -1");
        }
        if (item.equals("ring")){
            System.out.println("dexterity +1");
        }

    }
    public void accesoryStats(){
        if(items.contains("potion")){
            hero.setHealth(1);
    
        }
        if(items.contains("ring")){
            hero.setDexterity(1);
        }
        
    }

   
    
}
