/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Tanggal_30_Mei;

import java.util.Scanner;
class simpul{
    String barang;
    int harga;
    simpul prev, next;
    
    simpul(String b, int h){
        barang = b;
        harga = h;
    }
}

class queue{
    simpul  front, rear;
    
    queue(){
        front = rear = null;
    }
    
    void enqueue(simpul baru){
        if(rear == null){
            front = rear = baru;
        }
        else{
            rear.prev= baru;
            baru.next = rear;
            rear = baru;
        }
        
        System.out.println("Enqueue Sukses...");
    }
    
    simpul dequeue(){
        simpul t = null;
        
        if(front == null){
            System.out.println("Queue kosong...");
        }
        else if(front.prev == null){
            t = front;
            front = rear = null;
        }
        else{
            t = front;
            simpul temp= front.prev;
            front.prev = null;
            temp.next = null;
            front = temp;
            System.out.println("Dequeue sukses...");
        }
        return t;
    }
    
    void  view(){
        System.out.println("Isi Queue");
        
        for(simpul t = rear; t != null; t = t.next){
            System.out.println(t.barang + " [" + t.harga + "] ");
        }
        System.out.println(" ");
    }
}
public class Tanggal_30_Mei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        queue q = new queue();
        int pilih = 0;
        int total = 0;
        int total_checkout = 0;
        
        do{
            System.out.println("Antrian Pembelian");
            System.out.println("1. Enqueue \n2. Dequeue");
            System.out.println("3. View \n4. Exit");
            System.out.print("Pilih = ");
            pilih = sc.nextInt();
            
            switch(pilih){
                case 1 :
                    System.out.println("Daftar Barang");
                    System.out.println("1. Kasur \n2. Meja \n3. Kursi");
                    System.out.print("Pilih = ");
                    int pilih2 = sc.nextInt();
                    
                    switch(pilih2){
                        case 1:
                            simpul s = new simpul("Kasur", 200000);
                            q.enqueue(s);
                            total = total + 200000;
                            break;
                        case 2:
                            s = new simpul("Meja", 150000);
                            q.enqueue(s);
                            total = total + 150000;
                            break;
                        case 3:
                            s = new simpul("Kursi", 100000);
                            q.enqueue(s);
                            total = total + 1010000;
                            break;
                    }
                    break;
                case 2 :
                    simpul t = q.dequeue();
                    
                    if(t != null){
                        System.out.println("Check Out " + t.barang);
                        total = total - t.harga;
                        total_checkout = total_checkout + t.harga;
                    }
                    else{
                        System.out.println("Queue kosong...");
                    }
                    break;
                case 3 :
                    q.view();
//                    for(simpul temp = q.front; temp != null; temp = temp.prev){
//                        total = total + temp.harga;                       
//                    }
                    System.out.println("Total Antrian = " + total);
                    System.out.println("Total Checkout = " + total_checkout);
                    break;
                case 4 :
                    System.out.println("Done");
                    break;
            }
        }while(pilih != 4);
    }
}

