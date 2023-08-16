import javax.swing.*;
import java.util.*;
import java.io.*;
class PersonInfo{
    String name;
    String address;
    String phonenumber;
    String email;
    PersonInfo(String n,String a,String p,String e){
        name=n;
        address=a;
        phonenumber=p;
        email=e;
    }
    void display(){
        JOptionPane.showMessageDialog(null, "Name: "+name + "\nAddress: " + address + "\nPhone No: "+ phonenumber + "\nEmailAddress:" + email);
    }

}
class AddressBook{
    ArrayList presons;
    AddressBook(){
        presons=new ArrayList<>();
        load();
    }
      
    void addPerson(){
        String name=JOptionPane.showInputDialog("Enter Name :");
        String add=JOptionPane.showInputDialog("Enter Address :");
        String pNum=JOptionPane.showInputDialog("Enter Phone Number :");
        String ema=JOptionPane.showInputDialog("Enter your email");
        PersonInfo p=new PersonInfo(name, add, pNum,ema);
        presons.add(p);
    }
    void search(String n){
        for(int i=0;i<presons.size();i++){
            PersonInfo p=(PersonInfo) presons.get(i);
            if(n.equals(p.name)){
                p.display();
            }
        }
    }
    void delete(String n){
        for(int i=0;i<presons.size();i++){
            PersonInfo p=(PersonInfo) presons.get(i);
            if(n.equals(p.name)){
                presons.remove(i);
            }

        }
    }
    void displayall(){

          for(int i=0;i<presons.size();i++){
            PersonInfo p=(PersonInfo) presons.get(i);
            p.display();
    }

}
    void save(){
        try{
            PersonInfo p;
            String line;
            FileWriter f=new FileWriter("PersonsInfo1.txt");
            PrintWriter p1=new PrintWriter(f);
            for(int i=0;i<presons.size();i++){
                p=(PersonInfo) presons.get(i);
                line=p.name + "," +p.address +"," + p.phonenumber + ","+p.email;
                p1.println(line);
            }
            p1.flush();
            p1.close();
            f.close();

        }
        catch(IOException e){
            System.out.println(e);


        }
    }
    void load(){
        String token[]=null;
        String name,add,ph,em;
        try{
            FileReader f1=new FileReader("PersonsInfo1.txt");
            BufferedReader bf=new BufferedReader(f1);
            String line=bf.readLine();
            while(line!=null){
                token=line.split(",");
                name=token[0];
                add=token[1];
                ph=token[2];
                em=token[3];

                PersonInfo p=new PersonInfo(name,add,ph,em);
                presons.add(p);
                line=bf.readLine();
            }
            bf.close();
            f1.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

}
public class Test{
    public static void main(String[] args){
        AddressBook ab=new AddressBook();
        String input,s;
        int ch;
        
        while(true){
            input =JOptionPane.showInputDialog("Enter 1 to Add\nEnter 2 to Search\nEnter 3 to Delete\nEnter 4 to Display all contacts\nEnter 5 to Exit");
             ch=Integer.parseInt(input);
             
              switch (ch){
            case 1:
                ab.addPerson();
                break;
            case 2:
               
                s=JOptionPane.showInputDialog("Enter name to Search");
                ab.search(s);
                break;
            case 3:
               
                s=JOptionPane.showInputDialog("Enter name to Delete");
                ab.delete(s);
                break;
            case 4:
                ab.displayall();
                break;
            case 5:
                ab.save();
                System.exit(0);


        }

        }
       
       
    }

}