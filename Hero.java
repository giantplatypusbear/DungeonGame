
public class Hero {
 
 private int damage;
 private int health;
 private int dexterity;
 
 
 
 public Hero(){
    this.damage=(int)((Math.random()*6)+1); 
    this.health=(int)((Math.random()*11)+10); 
    this.dexterity=(int)((Math.random()*6)+3); 
   
 }

 public int getDamage(){
   return damage;
 }

 public int setDamage(int damageDone){
   return damage+= damageDone;
 }

 public double getHealth(){
   return health;
 }

 public double setHealth(int healthChange){
  return health+=healthChange;
 }

 public int getDexterity(){
   return dexterity;
 }

 public int setDexterity(int dexterityChange){
  return dexterity+= dexterityChange;
 }

 

 

 
}
