/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Tanggal_30_Mei;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tanggal_30_Mei {
    public static void main(String[] args) {
        Queue<String> antrianBarang = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Menu Antrian Pembelian Barang ===");
            System.out.println("1. Tambah Barang ke Antrian");
            System.out.println("2. Tampilkan Daftar Antrian");
            System.out.println("3. Proses Barang (Antrian Terdepan)");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Buang newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String barang = scanner.nextLine();
                    antrianBarang.add(barang);
                    System.out.println("Barang \"" + barang + "\" ditambahkan ke antrian.");
                    break;

                case 2:
                    if (antrianBarang.isEmpty()) {
                        System.out.println("Antrian kosong.");
                    } else {
                        System.out.println("Daftar antrian pembelian barang:");
                        int urutan = 1;
                        for (String b : antrianBarang) {
                            System.out.println(urutan + ". " + b);
                            urutan++;
                        }
                    }
                    break;

                case 3:
                    if (antrianBarang.isEmpty()) {
                        System.out.println("Tidak ada barang yang dapat diproses.");
                    } else {
                        String diproses = antrianBarang.poll();
                        System.out.println("Barang \"" + diproses + "\" telah diproses dan dihapus dari antrian.");
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih. Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}

