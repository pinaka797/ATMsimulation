/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import AdditionApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author ajit
 */
public class StartClient {
    public static void main(String args[]){
    
    try{
    ORB orb=ORB.init(args, null);
    org.omg.CORBA.Object objref=orb.resolve_initial_references("NameService");
    NamingContextExt ncref=NamingContextExtHelper.narrow(objref);
    Addition addobj=(Addition)AdditionHelper.narrow(ncref.resolve_str("ABC"));
    Scanner scan=new Scanner(System.in);
    System.out.println("Welcome to the Multiplication system");
    for(;;){
    System.out.println("Enter a:");
    int a=Integer.parseInt(scan.nextLine());
    System.out.println("Enter b:");
    int b=Integer.parseInt(scan.nextLine());
    int r=addobj.add(a, b);
    System.out.println("The result for multiplication is:"+r);
    System.out.println("------------------------------------------------");
    
    }
    }
    catch(Exception e){
    System.err.println("Error:"+e);
    e.printStackTrace(System.out);
    }}
    
}
