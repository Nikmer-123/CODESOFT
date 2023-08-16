import javax.swing.*;
import java.util.*;
import java.io.*;
class StudentInfo{
    String name;
    String address;
    String phonenumber;
    String email;
    String Grade;
    String course;
    String rollnum;
    String section;
    StudentInfo(String rn,String n,String c,String s,String g,String a,String p,String e){
        name=n;
        rollnum=rn;
        Grade=g;
        course=c;
        address=a;
        phonenumber=p;
        email=e;
        section=s;
    }
    void display(){
        JOptionPane.showMessageDialog(null, "\nRollNo:" +rollnum+"\nName: "+name + "\nCourse:"+course+ "\nSection :"+section+ "\nGrade:"+Grade+"\nAddress: " + address + "\nPhone No: "+ phonenumber + "\nEmailAddress:" + email);
    }

}
class AddressBook{
    ArrayList presons;
    AddressBook(){
        presons=new ArrayList<>();
        load();
    }
      
    void addPerson(){
        
        String rno=JOptionPane.showInputDialog("Enter student RollNo :");;
        
        String name=JOptionPane.showInputDialog("Enter Student Name :");
        
        String cour=JOptionPane.showInputDialog("Enter student Course :");
        String sec=JOptionPane.showInputDialog("Enter student Section :");
        String gra=JOptionPane.showInputDialog("Enter student Grade :");
        String add=JOptionPane.showInputDialog("Enter Address :");
        String pNum=JOptionPane.showInputDialog("Enter Phone Number :");
        String ema=JOptionPane.showInputDialog("Enter your email");

        StudentInfo p=new StudentInfo(rno,name,cour,sec,gra,add, pNum,ema);
        presons.add(p);
    }
    void search(String r){
        for(int i=0;i<presons.size();i++){
            StudentInfo p=(StudentInfo) presons.get(i);
            if(r.equals(p.rollnum)){
                p.display();
            }
        }
    }
    void delete(String r){
        for(int i=0;i<presons.size();i++){
            StudentInfo p=(StudentInfo) presons.get(i);
            if(r.equals(p.rollnum)){
                presons.remove(i);
            }

        }
    }
    void displayall(){

          for(int i=0;i<presons.size();i++){
            StudentInfo p=(StudentInfo) presons.get(i);
            p.display();
    }

}
    void save(){
        try{
            StudentInfo p;
            String line;
            FileWriter f=new FileWriter("StudentInfo1.txt");
            PrintWriter p1=new PrintWriter(f);
            for(int i=0;i<presons.size();i++){
                p=(StudentInfo) presons.get(i);
                line=p.rollnum+","+p.name + "," + p.course+","+p.section+","+p.Grade+","+p.address +"," + p.phonenumber + ","+p.email;
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
        String rn1,name,cr,sec1,gd,add,ph,em;
        try{
            FileReader f1=new FileReader("StudentInfo1.txt");
            BufferedReader bf=new BufferedReader(f1);
            String line=bf.readLine();
            while(line!=null){
                token=line.split(",");
                rn1=token[0];
                name=token[1];
                cr=token[2];
                sec1=token[3];
                gd=token[4];
                add=token[5];
                ph=token[6];
                em=token[7];

                StudentInfo p=new StudentInfo(rn1,name,cr,sec1,gd,add,ph,em);
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
public class main{
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
               
                s=JOptionPane.showInputDialog("Enter rollNo to Search");
                ab.search(s);
                break;
            case 3:
               
                s=JOptionPane.showInputDialog("Enter rollNo to Delete");
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