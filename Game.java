import java.util.Scanner;
public class Game {
    
    Scanner myScanner = new Scanner(System.in);
    Scanner enterScanner = new Scanner(System.in);
    int playerHP;
    String playerName;
    String playerWeapon;
    int choice;
    int monsterHP;
    
    int silverRing;
        
    public static void main(String[] args) {
        Game dublin;
        dublin = new Game();    
        
        dublin.playerSetUp();   
        dublin.townGate();
    }
    
    public void playerSetUp(){
        
        
        playerHP = 10;
        monsterHP = 15;
        playerWeapon = &quot;Knife&quot;;
        System.out.println(&quot;Your HP: &quot;+ playerHP);
        System.out.println(&quot;Your Weapon: &quot;+ playerWeapon);

        
        System.out.println(&quot;Please enter your name:&quot;);
        
        playerName = myScanner.nextLine();
        
        System.out.println(&quot;Hello &quot; + playerName + &quot;, let&#39;s start the game!&quot;);
  
        
        
    }   
    
    public void townGate(){
        
        System.out.println(&quot;\n------\n&quot;);
        System.out.println(&quot;You are at the gate of the town.&quot;);
        System.out.println(&quot;A guard is standing in front of you.&quot;);
        System.out.println(&quot;&quot;);
        System.out.println(&quot;What do you want to do?&quot;);
        System.out.println(&quot;&quot;);
        System.out.println(&quot;1: Talk to the guard&quot;);
        System.out.println(&quot;2: Attack the guard&quot;);
        System.out.println(&quot;3: Leave&quot;);
        System.out.println(&quot;\n----\n&quot;);
        choice = myScanner.nextInt();
        
        if(choice==1){
            if(silverRing==1){
                ending();
            }
            else{
                System.out.println(&quot;Guard: Hello there, stranger. So your name
 is &quot; + playerName + &quot;? \nSorry but we cannot let stranger enter our town.&quot;);
                enterScanner.nextLine();
                townGate();
            }
            
        }
        else if(choice==2){
            playerHP = playerHP-1;
            System.out.println(&quot;Guard: Hey don&#39;t be stupid.\n\nThe guard hit y
ou so hard and you gave up.\n(You receive 1 damage)\n&quot;);
            System.out.println(&quot;Your HP: &quot; + playerHP);
            enterScanner.nextLine();
            townGate();
        }
        else if(choice==3){
            crossRoad();

        }   
        else{
            townGate();
        }
    }
    
    public void crossRoad(){
        System.out.println(&quot;\n--\n&quot;);
        System.out.println(&quot;You are at a crossroad. If you go south, you will 
go back to the town.\n\n&quot;);
        System.out.println(&quot;1: Go north&quot;);
        System.out.println(&quot;2: Go east&quot;);
        System.out.println(&quot;3: Go south&quot;);
        System.out.println(&quot;4: Go west&quot;);
        System.out.println(&quot;\n---\n&quot;);
        
        choice = myScanner.nextInt();
        
        if(choice==1){
            north();
        }
        else if(choice==2){
            east();
        }
        else if(choice==3){
            townGate();
        }
        else if(choice==4){
            west();
        }
        else{
            crossRoad();
        }
    }
    
    public void north(){
        System.out.println(&quot;\n------------------------------------------------
------------------\n&quot;);
        System.out.println(&quot;There is a river. You drink the water and rest at 
the riverside.&quot;);
        System.out.println(&quot;Your HP is recovered.&quot;);
        playerHP = playerHP + 1;
        System.out.println(&quot;Your HP: &quot; + playerHP);
        System.out.println(&quot;\n\n1: Go back to the crossroad&quot;);
        System.out.println(&quot;\n---\n&quot;);
        
        choice = myScanner.nextInt();
        

        if(choice==1){
            crossRoad();
        }
        else{
            north();
        }
    }
    
    public void east(){
        System.out.println(&quot;\n---\n&quot;);
        System.out.println(&quot;You walked into a forest and found a Long Sword!&quot;)
;
        playerWeapon = &quot;Long Sword&quot;;
        System.out.println(&quot;Your Weapon: &quot;+ playerWeapon);
        System.out.println(&quot;\n\n1: Go back to the crossroad&quot;);
        System.out.println(&quot;\n--\n&quot;);
        
        choice = myScanner.nextInt();
        
        if(choice==1){
            crossRoad();
        }
        else{
            east();
        }
    }
    
    public void west(){
        System.out.println(&quot;\n---\n&quot;);
        System.out.println(&quot;You encounter a goblin!\n&quot;);
        System.out.println(&quot;1: Fight&quot;);
        System.out.println(&quot;2: Run&quot;);
        System.out.println(&quot;\n----\n&quot;);
        
        choice = myScanner.nextInt();
        
        if(choice==1){
            fight();
        }
        else if(choice==2){
            crossRoad();
        }
        else{
            west();
        }
    }
    
    public void fight(){

        System.out.println(&quot;\n----\n&quot;);
        System.out.println(&quot;Your HP: &quot;+ playerHP);
        System.out.println(&quot;Monster HP: &quot; + monsterHP);
        System.out.println(&quot;\n1: Attack&quot;);
        System.out.println(&quot;2: Run&quot;);
        System.out.println(&quot;\n--\n&quot;);
        
        choice = myScanner.nextInt();
        
        if(choice==1){
            attack();
        }
        else if(choice==2){
            crossRoad();
        }
        else{
            fight();
        }
    }
    
    public void attack(){
        int playerDamage =0;
        
        
        if(playerWeapon.equals(&quot;Knife&quot;)){
            playerDamage = new java.util.Random().nextInt(5); 
        }
        else if(playerWeapon.equals(&quot;Long Sword&quot;)){
            playerDamage = new java.util.Random().nextInt(8); 
        }
        
        System.out.println(&quot;You attacked the monster and gave &quot; + playerDamage
 + &quot; damage!&quot;);
        
        monsterHP = monsterHP - playerDamage;
        
        System.out.println(&quot;Monster HP: &quot; + monsterHP);
        
        if(monsterHP&lt;1){ win(); } else if(monsterHP&gt;0){
            int monsterDamage =0;
            
            monsterDamage = new java.util.Random().nextInt(4);
            
            System.out.println(&quot;The monster attacked you and gave &quot; + monsterD
amage + &quot; damage!&quot;);
            
            playerHP = playerHP - monsterDamage;
            

            System.out.println(&quot;Player HP: &quot; + playerHP);
            
            if(playerHP&lt;1){ dead(); } else if(playerHP&gt;0){
                fight();
            }
        }
        
        
    }
    
    public void dead(){
        System.out.println(&quot;\n---------\n&quot;);
        System.out.println(&quot;You are dead!!!&quot;);
        System.out.println(&quot;\n\nGAME OVER&quot;);
        System.out.println(&quot;\n-------\n&quot;);
        
    }
    
    public void win(){
        System.out.println(&quot;\n-------\n&quot;);
        System.out.println(&quot;You killed the monster!&quot;);
        System.out.println(&quot;The monster dropped a ring!&quot;);
        System.out.println(&quot;You obtaind a silver ring!\n\n&quot;);
        System.out.println(&quot;1: Go east&quot;);
        System.out.println(&quot;\n--------\n&quot;);
        
        silverRing = 1;
        
        choice = myScanner.nextInt();
        if(choice==1){
            crossRoad();
        }
        else{
            win();
        }
        
    }
    
    public void ending(){
        System.out.println(&quot;\n-----------\n&quot;);
        System.out.println(&quot;Guard: Oh you killed that goblin!?? Great!&quot;);
        System.out.println(&quot;Guard: It seems you are a trustworthy guy. Welcome
 to our town!&quot;);
        System.out.println(&quot;\n\n           THE END                    &quot;);
        System.out.println(&quot;\n---------\n&quot;);
    }
}