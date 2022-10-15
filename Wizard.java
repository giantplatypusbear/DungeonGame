public class Wizard {
private int wizardDam;
 private int wizardHealth;

 public Wizard(){
    this.wizardDam=(int)(Math.random()*5+4); 
    this.wizardHealth=(int)(Math.random()*13+12);
 }
 public int getWizDam(){
    return wizardDam;
  }
 
  public int setWizDamage(int damageDone){
    return wizardDam+= damageDone;
  }
 
  public double getWizHealth(){
    return wizardHealth;
  }
 
  public double setWizHealth(double healthChange){
   return wizardHealth+=healthChange;
  }
}
