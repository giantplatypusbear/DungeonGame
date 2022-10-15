import java.util.ArrayList;
import java.util.Scanner;


public class Dungeon {
    private ArrayList <Room> map;
    private Room position;
    private Monsters mon1;
    private Monsters mon2;
    private Monsters mon3;
    private Monsters mon4;
    private Hero player;
    private Wizard wizard;
    private Accesories item;
    private Inventory inventory;
    
   

    public Dungeon(){
        this.map= new ArrayList<Room>();

        map.add(new Room("s",0,-2));//0
        map.add(new Room("a1",1,-1));//1
        map.add(new Room("m1",0,-1));//2
        map.add(new Room("a2",-1,-1));//3
        map.add(new Room("w1",2,0));//4
        map.add(new Room("m2",1,0));//5
        map.add(new Room("f",0,0));//6
        map.add(new Room("m3",-1,0));//7
        map.add(new Room("w2",-2,0));//8
        map.add(new Room("a3",1,1));//9
        map.add(new Room("m4",0,1));//10
        map.add(new Room("a4",-1,1));//11
        map.add(new Room("b",0,2));//12
        this.position= map.get(0);

        this.mon1=new Monsters();
        this.mon2=new Monsters();
        this.mon3=new Monsters();
        this.mon4=new Monsters();
        this.player= new Hero();
        this.wizard= new Wizard();
        
        this.item= new Accesories();
        this.inventory= new Inventory();
        
        
    } 
    


    public void placeAccesories(){
        if(position.getRoomType().equals("a1")){
            String itemInPlace= item.randomItem();
            System.out.println("You have found "+itemInPlace+". Add to inventory? Type 'yes' or 'no' ");
            inventory.addItems(itemInPlace);
            inventory.accesoryPoints(itemInPlace);
        }
        
        if(position.getRoomType().equals("a2")){
            String itemInPlace= item.randomItem();
            System.out.println("You have found "+itemInPlace+". Add to inventory? Type 'yes' or 'no' ");
            inventory.addItems(itemInPlace);
            inventory.accesoryPoints(itemInPlace);
        
        }
        if(position.getRoomType().equals("a3")){
            String itemInPlace= item.randomItem();
            System.out.println("You have found "+itemInPlace+". Add to inventory? Type 'yes' or 'no' ");
            inventory.addItems(itemInPlace);
            inventory.accesoryPoints(itemInPlace);
        }

        if(position.getRoomType().equals("a4")){
            String itemInPlace= item.randomItem();
            System.out.println("You have found "+itemInPlace+". Add to inventory? Type 'yes' or 'no' ");
            inventory.addItems(itemInPlace);
            inventory.accesoryPoints(itemInPlace);
        }
        
    
    }
    
        
    
    public void shield(){
        if(inventory.getItems().contains("sheild")){
            mon1.setMonDamage(-1);
            mon2.setMonDamage(-1);
            mon3.setMonDamage(-1);
            mon4.setMonDamage(-1);
            wizard.setWizDamage(-1);
        }
    }

    public void turns(){
    Scanner input = new Scanner(System.in);
    String dir;
    boolean finish= false;
    

    while(finish==false){
    System.out.println("Choose a direction to move in. Type n for north, s for south, e for east, and w for west ");
    dir=input.nextLine();
    boolean moved=false;
    
    if(dir.equals("n")){
        moved=false;
       int newY =position.getY()+1;
       for(int i=0; i<map.size();i++){
        if(map.get(i).getX()==position.getX()&& map.get(i).getY()==newY){
            position= map.get(i);
            moved=true;
        }
       
       }
    }

    if(dir.equals("s")){
        moved=false;
        int newY =position.getY()-1;
       for(int i=0; i<map.size();i++){
        if(map.get(i).getX()==position.getX()&& map.get(i).getY()==newY){
            position= map.get(i);
            moved=true;
        }
       
    }
}
    if(dir.equals("e")){
        moved=false;
        int newX =position.getX()+1;
       for(int i=0; i<map.size();i++){
        if(map.get(i).getX()==newX && map.get(i).getY()==position.getY()){
            position= map.get(i);
            moved=true;
        }
        
    }
}
    if(dir.equals("w")){
        moved=false;
        int newX =position.getX()-1;
       for(int i=0; i<map.size();i++){
        if(map.get(i).getX()==newX && map.get(i).getY()==position.getY()){
            position= map.get(i);
            moved=true;
        }
       
    }
}

if(position.getX()==0 && position.getY()==2){
    finish=true;
}
inventory.accesoryStats();
Battle(mon1,mon2,mon3,mon4,player);
placeAccesories();
finalBattle(wizard,player);
    if(moved==false){
        System.out.println("Turn outside of map. Try Again");}

    if(!(dir.equals("n")||dir.equals("s")||dir.equals("e")||dir.equals("w"))){
        System.out.println("Wrong input try again");
    }
    
        
    }
        
    }

public void transport(){
for(int i=0; i<map.size();i++){
    if(position==map.get(i)){
    if(position.getRoomType().equals("m2")||position.getRoomType().equals("m3")){
        int roomChance= (int)(Math.random()*4)+1;
        

            if(roomChance==1){
            position=map.get(i-1);
            }
            if(roomChance==2){
            position=map.get(i+4);
            }
            if(roomChance==3){
            position=map.get(i+1);
            }
            if(roomChance==1){
            position=map.get(i-4);
            }
    }

int roomChance2= (int)(Math.random()*3)+1;
if(position.getRoomType().equals("m1")){
    if(roomChance2==1){
        position=map.get(i-1);
        }
        if(roomChance2==2){
        position=map.get(i+4);
        }
        if(roomChance2==3){
        position=map.get(i+1);
}
}
if(position.getRoomType().equals("m4")){
    if(roomChance2==1){
        position=map.get(i-1);
        }
        if(roomChance2==2){
        position=map.get(i-4);
        }
        if(roomChance2==3){
        position=map.get(i+1);
        }
    }
    if(position.getRoomType().equals("b")){
        position=map.get(10);
    }
}
}
}

public void Battle(Monsters mon1, Monsters mon2, Monsters mon3, Monsters mon4, Hero hero){

shield();
    if(position.getRoomType().equals("m1")){
    Scanner input= new Scanner(System.in);
    System.out.println("Oh no! You have encountered monster1!");
    
    while(mon1.getMonHealth()>0 && hero.getHealth()>0){
    int whosTurn=0;
    boolean dodged=false;
    System.out.println("Your health: "+hero.getHealth() +  "  Your damage: " +hero.getDamage()+"  Your dexterity: "+hero.getDexterity());
    System.out.println("Monster health: "+mon1.getMonHealth() +  "  Monster damage: " +mon1.getMonDam());
    System.out.println("Your Turn. Type 'attack' to attack, 'dodge' to dodge, and 'run' to run");
    String move= input.nextLine();

        if(whosTurn%2==0){
        if(move.equals("attack")){
            mon1.setMonHealth(-hero.getDamage());
        }
        if(move.equals("dodge")){
            double dodgeProb= .1*hero.getDexterity();
            if(Math.random()<=dodgeProb){
                 dodged= true;
                System.out.println("You successfully dodged!");
            }
            else{System.out.println("Dodge unsuccessful");
                 dodged= false;
            }
        }
        if(move.equals("run")){
            double runProb= .1*hero.getDexterity();
            if(Math.random()<=runProb){
                dodged= true;
               System.out.println("You successfully ran away!");
               transport();
               break;
               
           }
           else{ System.out.println("Run unsuccessful");
                dodged= false;
           }
        }
        whosTurn++;
    }//players moves 
    if(whosTurn%2!=0){
        System.out.println("Monsters turn!");
        double probOfMonAttack= Math.random();
        if(probOfMonAttack<=.7){
            System.out.println("The monster is attacking!");
        if(dodged==false){
            hero.setHealth(-mon1.getMonDam());
        }
    }
    else{
        System.out.println("The monster is defending!");
        while(whosTurn%2==0){
            if(move.equals("attack")){
                mon1.setMonHealth(-hero.getDamage()*.5);
            }
        }
    }
    whosTurn++;
    } 
}//monster attack
if(mon1.getMonHealth()<=0){
    System.out.println("Monster defeated :)");
}
 if(hero.getHealth()<=0){
    System.out.println("You died :(");
    System.exit(0);
 }
}//monster room 1 end
if(position.getRoomType().equals("m2")){
    Scanner input= new Scanner(System.in);
    System.out.println("Oh no! You have encountered monster2!");
    
    while(mon2.getMonHealth()>0 && hero.getHealth()>0){
    int whosTurn=0;
    boolean dodged=false;
    System.out.println("Your health: "+hero.getHealth() +  "  Your damage: " +hero.getDamage()+"  Your dexterity: "+hero.getDexterity());
    System.out.println("Monster health: "+mon2.getMonHealth() +  "  Monster damage: " +mon2.getMonDam());
    System.out.println("Your Turn. Type 'attack' to attack, 'dodge' to dodge, and 'run' to run");
    String move= input.nextLine();

        if(whosTurn%2==0){
        if(move.equals("attack")){
            mon2.setMonHealth(-hero.getDamage());
        }
        if(move.equals("dodge")){
            double dodgeProb= .1*hero.getDexterity();
            if(Math.random()<=dodgeProb){
                 dodged= true;
                System.out.println("You successfully dodged!");
            }
            else{System.out.println("Dodge unsuccessful");
                 dodged= false;
            }
        }
        if(move.equals("run")){
            double runProb= .1*hero.getDexterity();
            if(Math.random()<=runProb){
                dodged= true;
               System.out.println("You successfully ran away!");
               transport();
               break;
               
           }
           else{ System.out.println("Run unsuccessful");
                dodged= false;
           }
        }
        whosTurn++;
    }//players moves 
    if(whosTurn%2!=0){
        System.out.println("Monsters turn!");
        double probOfMonAttack= Math.random();
        if(probOfMonAttack<=.7){
            System.out.println("The monster is attacking!");
        if(dodged==false){
            hero.setHealth(-mon2.getMonDam());
        }
    }
    else{
        System.out.println("The monster is defending!");
        while(whosTurn%2==0){
            if(move.equals("attack")){
                mon2.setMonHealth(-hero.getDamage()*.5);
            }
        }
    }
    whosTurn++;
    } 
}//monster attack
if(mon2.getMonHealth()<=0){
    System.out.println("Monster defeated :)");
}
 if(hero.getHealth()<=0){
    System.out.println("You died :(");
    System.exit(0);
 }
}//monster room 2 end

if(position.getRoomType().equals("m3")){
    Scanner input= new Scanner(System.in);
    System.out.println("Oh no! You have encountered monster3!");
    
    while(mon3.getMonHealth()>0 && hero.getHealth()>0){
    int whosTurn=0;
    boolean dodged=false;
    System.out.println("Your health: "+hero.getHealth() +  "  Your damage: " +hero.getDamage()+"  Your dexterity: "+hero.getDexterity());
    System.out.println("Monster health: "+mon3.getMonHealth() +  "  Monster damage: " +mon3.getMonDam());
    System.out.println("Your Turn. Type 'attack' to attack, 'dodge' to dodge, and 'run' to run");
    String move= input.nextLine();

        if(whosTurn%2==0){
        if(move.equals("attack")){
            mon3.setMonHealth(-hero.getDamage());
        }
        if(move.equals("dodge")){
            double dodgeProb= .1*hero.getDexterity();
            if(Math.random()<=dodgeProb){
                 dodged= true;
                System.out.println("You successfully dodged!");
            }
            else{System.out.println("Dodge unsuccessful");
                 dodged= false;
            }
        }
        if(move.equals("run")){
            double runProb= .1*hero.getDexterity();
            if(Math.random()<=runProb){
                dodged= true;
               System.out.println("You successfully ran away!");
               transport();
               break;
               
           }
           else{ System.out.println("Run unsuccessful");
                dodged= false;
           }
        }
        whosTurn++;
    }//players moves 
    if(whosTurn%2!=0){
        System.out.println("Monsters turn!");
        double probOfMonAttack= Math.random();
        if(probOfMonAttack<=.7){
            System.out.println("The monster is attacking!");
        if(dodged==false){
            hero.setHealth(-mon3.getMonDam());
        }
    }
    else{
        System.out.println("The monster is defending!");
        while(whosTurn%2==0){
            if(move.equals("attack")){
                mon3.setMonHealth(-hero.getDamage()*.5);
            }
        }
    }
    whosTurn++;
    } 
}//monster attack
if(mon3.getMonHealth()<=0){
    System.out.println("Monster defeated :)");
}
 if(hero.getHealth()<=0){
    System.out.println("You died :(");
    System.exit(0);
 }
}//monster room 3 end

if(position.getRoomType().equals("m4")){
    Scanner input= new Scanner(System.in);
    System.out.println("Oh no! You have encountered monster4!");
    
    while(mon4.getMonHealth()>0 && hero.getHealth()>0){
    int whosTurn=0;
    boolean dodged=false;
    System.out.println("Your health: "+hero.getHealth() +  "  Your damage: " +hero.getDamage()+"  Your dexterity: "+hero.getDexterity());
    System.out.println("Monster health: "+mon4.getMonHealth() +  "  Monster damage: " +mon4.getMonDam());
    System.out.println("Your Turn. Type 'attack' to attack, 'dodge' to dodge, and 'run' to run");
    String move= input.nextLine();

        if(whosTurn%2==0){
        if(move.equals("attack")){
            mon4.setMonHealth(-hero.getDamage());
        }
        if(move.equals("dodge")){
            double dodgeProb= .1*hero.getDexterity();
            if(Math.random()<=dodgeProb){
                 dodged= true;
                System.out.println("You successfully dodged!");
            }
            else{System.out.println("Dodge unsuccessful");
                 dodged= false;
            }
        }
        if(move.equals("run")){
            double runProb= .1*hero.getDexterity();
            if(Math.random()<=runProb){
                dodged= true;
               System.out.println("You successfully ran away!");
               transport();
               break;
               
           }
           else{ System.out.println("Run unsuccessful");
                dodged= false;
           }
        }
        whosTurn++;
    }//players moves 
    if(whosTurn%2!=0){
        System.out.println("Monsters turn!");
        double probOfMonAttack= Math.random();
        if(probOfMonAttack<=.7){
            System.out.println("The monster is attacking!");
        if(dodged==false){
            hero.setHealth(-mon4.getMonDam());
        }
    }
    else{
        System.out.println("The monster is defending!");
        while(whosTurn%2==0){
            if(move.equals("attack")){
                mon4.setMonHealth(-hero.getDamage()*.5);
            }
        }
    }
    whosTurn++;
    } 
}//monster attack
if(mon4.getMonHealth()<=0){
    System.out.println("Monster defeated :)");
}
 if(hero.getHealth()<=0){
    System.out.println("You died :(");
    System.exit(0);
 }
}//monster room 4 end

}  
public void finalBattle(Wizard wizard, Hero hero){
    if(position.getRoomType().equals("b")){
        System.out.println("Welcome to the final battle! You must defeat the wizard~");
        Scanner input= new Scanner(System.in);
    
    while(wizard.getWizHealth()>0 && hero.getHealth()>0){
    int whosTurn=0;
    boolean dodged=false;
    System.out.println("Your health: "+hero.getHealth() +  "  Your damage: " +hero.getDamage()+"  Your dexterity: "+hero.getDexterity());
    System.out.println("Wizard health: "+wizard.getWizHealth() +  "  Wizard damage: " +wizard.getWizDam());
    System.out.println("Your Turn. Type 'attack' to attack, 'dodge' to dodge, and 'run' to run");
    String move= input.nextLine();

        if(whosTurn%2==0){
        if(move.equals("attack")){
            wizard.setWizHealth(-hero.getDamage());
        }
        if(move.equals("dodge")){
            double dodgeProb= .1*hero.getDexterity();
            if(Math.random()<=dodgeProb){
                 dodged= true;
                System.out.println("You successfully dodged!");
            }
            else{System.out.println("Dodge unsuccessful");
                 dodged= false;
            }
        }
        if(move.equals("run")){
            double runProb= .1*hero.getDexterity();
            if(Math.random()<=runProb){
                dodged= true;
               System.out.println("You successfully ran away!");
               transport();
               break;
               
           }
           else{ System.out.println("Run unsuccessful");
                dodged= false;
           }
        }
        whosTurn++;
    }//players moves 
    if(whosTurn%2!=0){
        System.out.println("Wizard's turn!");
        double probOfWizAttack= Math.random();
        if(probOfWizAttack<=.7){
            System.out.println("The wizard is attacking!");
        if(dodged==false){
            hero.setHealth(-wizard.getWizDam());
        }
    }
    else{
        System.out.println("The wizard is defending!");
        while(whosTurn%2==0){
            if(move.equals("attack")){
                wizard.setWizHealth(-hero.getDamage()*.5);
            }
        }
    }
    whosTurn++;
    } 
}//wiz attack
if(wizard.getWizHealth()<=0){
    System.out.println("Wizard defeated. You have completed the dungeon :)");
}
 if(hero.getHealth()<=0){
    System.out.println("You died :(");
    System.exit(0);
 }
    }
} 
public static void main(String[]args){


System.out.println("Welcome to the dungeon adventure!");
Dungeon breh= new Dungeon();
breh.turns();



}   

}

