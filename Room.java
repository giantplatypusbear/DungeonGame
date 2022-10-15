public class Room {
    private int x;
    private int y;
    private String roomType;

    public Room(String roomType, int x, int y){
        this.roomType=roomType;
        this.x=x;
        this.y=y;

    }
    public String getRoomType(){
      return roomType;
    }
    public int getX(){
        return x;
      }
     
      public int setX(int xChange){
        return x+= xChange;
      }

      public int getY(){
        return y;
      }
     
      public int setY(int yChange){
        return y+= yChange;
      }
    
}
