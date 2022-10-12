import java.util.*;
import java.io.*;
import java.net.*;

public class subnetting {
public static void main(String []args) throws Exception{
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter ip address seperated by into different inputs");
    System.out.println("First : ");
    int ip1=sc.nextInt();
    System.out.println("Second : ");
    int ip2=sc.nextInt();
    System.out.println("Third : ");
    int ip3=sc.nextInt();
    System.out.println("Fourth : ");
    int ip4=sc.nextInt();
    System.out.println("Enter CIDR(Classless Inter Domain Routing) value:");
    int cidr=sc.nextInt();

    switch(cidr){
        case 1: System.out.println("Subnet mask is "+"128.0.0.0"); break;
        case 2: System.out.println("Subnet mask is "+"192.0.0.0"); break;
        case 3: System.out.println("Subnet mask is "+"224.0.0.0"); break;
        case 4: System.out.println("Subnet mask is "+"240.0.0.0"); break;
        case 5: System.out.println("Subnet mask is "+"252.0.0.0"); break;
        case 7: System.out.println("Subnet mask is "+"254.0.0.0"); break;
        case 8: System.out.println("Subnet mask is "+"255.0.0.0"); break;
        case 9: System.out.println("Subnet mask is "+"255.128.0.0"); break;
        case 10: System.out.println("Subnet mask is "+"255.192.0.0"); break;
        case 11: System.out.println("Subnet mask is "+"255.224.0.0"); break;
        case 12: System.out.println("Subnet mask is "+"255.240.0.0"); break;
        case 13: System.out.println("Subnet mask is "+"255.248.0.0"); break;
        case 14: System.out.println("Subnet mask is "+"255.252.0.0"); break;
        case 15: System.out.println("Subnet mask is "+"255.254.0.0"); break;
        case 16: System.out.println("Subnet mask is "+"255.255.0.0"); break;
        case 17: System.out.println("Subnet mask is "+"255.255.128.0"); break;
        case 18: System.out.println("Subnet mask is "+"255.255.192.0"); break;
        case 19: System.out.println("Subnet mask is "+"255.255.224.0"); break;
        case 20: System.out.println("Subnet mask is "+"255.255.240.0"); break;
        case 21: System.out.println("Subnet mask is "+"255.255.248.0"); break;
        case 22: System.out.println("Subnet mask is "+"255.255.252.0"); break;
        case 23: System.out.println("Subnet mask is "+"255.255.254.0"); break;
        case 24: System.out.println("Subnet mask is "+"255.255.255.0"); break;
        case 25: System.out.println("Subnet mask is "+"255.255.255.128"); break;
        case 26: System.out.println("Subnet mask is "+"255.255.255.192"); break;
        case 27: System.out.println("Subnet mask is "+"255.255.255.224"); break;
        case 28: System.out.println("Subnet mask is "+"255.255.255.240"); break;
        case 29: System.out.println("Subnet mask is "+"255.255.255.248"); break;
        case 30: System.out.println("Subnet mask is "+"255.255.255.252"); break;
        case 31: System.out.println("Subnet mask is "+"255.255.255.254"); break;
        case 32: System.out.println("Subnet mask is "+"255.255.255.255"); break;

        default: System.out.println("Invalid value");
    }
    String ips1=Integer.toString(ip1);
    String ips2=Integer.toString(ip2);
    String ips3=Integer.toString(ip3);
    if(ip1>=1 && ip1<=127){
        System.out.println("Network class is A");
        System.out.println("Network Address is "+ips1+"0.0.0");

    }
    else if(ip1>=128 && ip1<=191){
        System.out.println("Network class is B");
        System.out.println("Network Address is "+ips1+"."+ips2+"0.0");
    }
    else if(ip1>=192 && ip1<=223){
        System.out.println("Network class is C");
        System.out.println("Network Address is "+ips1+"."+ips2+"."+ips3+".0");

    }
    else if(ip1>=224 && ip1<=255){
        System.out.println("Network class is D and E");
    }
    System.out.println("Broadcast Address is "+ips1+"."+ips2+"."+ips3+".255");

    int noofhostssubnets=32-cidr;
    int noofhostssubnetsv=(int)Math.pow(2,noofhostssubnets);
    int noofnetworks=noofhostssubnetsv/cidr;
    System.out.println("No of networks are "+noofnetworks);
    System.out.println("No of hosts for ip addressing per subnet1 are "+(noofhostssubnetsv-2));

}
}
