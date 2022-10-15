public class Monsters {
 private int monsterDam;
 private int monsterHealth;

 public Monsters(){
    this.monsterDam=(int)((Math.random()*4)+1); 
    this.monsterHealth=(int)((Math.random()*6)+5); 
 }

 public int getMonDam(){
    return monsterDam;
  }
 
  public int setMonDamage(int damageDone){
    return monsterDam+= damageDone;
  }
 
  public double getMonHealth(){
    return monsterHealth;
  }
 
  public double setMonHealth(double healthChange){
   return monsterHealth+=healthChange;
  }
}
