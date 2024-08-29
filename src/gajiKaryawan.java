import java.util.Scanner;

public class gajiKaryawan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nip, status, hariKerja, lembur, terlambat, bpjs, lanjut = 1, jumlahAnak = 0, jumlahIstriSuami = 0, jabatan;
        String nama;
        double gajiPokok = 0, tunjanganIstri = 0, tunjanganAnak = 0, gajitotal;
        double gajiTerbesar = 0;
        double gajiTerkecil = 0;
        String namaGajiTerbesar = "";
        int nipGajiTerbesar = 0;
        String namaGajiTerkecil = "";
        int nipGajiTerkecil = 0;
        int jumlahKaryawan = 0;

        System.out.println("Masukkan Data Karyawan (nama, nip, jabatan, status)");

        do {
            System.out.print("Masukkan Nama Karyawan: ");
            nama = input.nextLine();
            System.out.print("Masukkan NIP: ");
            nip = input.nextInt();
            input.nextLine();

            System.out.println("Pilih Jabatan:");
            System.out.println("1. Direktur");
            System.out.println("2. Manajer");
            System.out.println("3. Kepala Staf");
            System.out.println("4. Staf");
            System.out.print("Masukkan Jabatan: ");
            jabatan = input.nextInt();

            if (jabatan == 1)
                gajiPokok = 7500000;
            else if (jabatan == 2)
                gajiPokok = 5000000;
            else if (jabatan == 3)
                gajiPokok = 3500000;
            else if (jabatan == 4)
                gajiPokok = 250000;

            System.out.print("Jumlah Hari Kerja: ");
            hariKerja = input.nextInt();
            System.out.print("Jumlah Hari Lembur: ");
            lembur = input.nextInt();
            System.out.print("Jumlah Jam Terlambat: ");
            terlambat = input.nextInt();

            System.out.println("Status:");
            System.out.println("1. Menikah");
            System.out.println("2. Belum Menikah");
            System.out.println("3. Duda");
            System.out.print("Masukkan pilihan 1,2 atau 3: ");
            status = input.nextInt();

            if (status == 1) {
                System.out.print("Jumlah Istri: ");
                jumlahIstriSuami = input.nextInt();
                tunjanganIstri = 200000;

                System.out.print("Jumlah Anak: ");
                jumlahAnak = input.nextInt();
                tunjanganAnak = (jumlahAnak <= 3) ? 100000 * jumlahAnak : 500000;
            } else if (status == 3) {
                tunjanganIstri = 0;
                System.out.print("Jumlah Anak: ");
                jumlahAnak = input.nextInt();
                tunjanganAnak = (jumlahAnak <= 3) ? 100000 * jumlahAnak : 500000;
            } else {
                tunjanganIstri = 0;
                tunjanganAnak = 0;
            }

            System.out.print("Kelas BPJS \n1.Kelas 1\n2.Kelas 2\n3.Kelas 3 \nPilih Kelas BPJS:");
            bpjs = input.nextInt();
            bpjs = (bpjs == 1) ? 150000 : (bpjs == 2) ? 100000 : 75000;

            double bonusLembur = lembur * 50000;
            double tunjangan = tunjanganIstri + tunjanganAnak + (hariKerja * 20000);
            double potongan = bpjs + (terlambat * 5000);
            gajitotal = gajiPokok + bonusLembur + tunjangan - potongan;
            double pajak = gajitotal * 0.025;
            gajitotal -= pajak;

            System.out.println("Perincian Gaji:");
            System.out.println("Gaji Pokok: Rp. " + gajiPokok);
            System.out.println("Bonus: Rp. " + bonusLembur);
            System.out.println("============================");
            System.out.println("Tunjangan ");
            System.out.println("Tunjangan Makan : Rp. " + (hariKerja * 20000));
            System.out.println("Tunjangan Transportasi  : Rp. " + (hariKerja * 20000));
            System.out.println("Tunjangan Istri : Rp. " + tunjanganIstri);
            System.out.println("Tunjangan Anak : Rp. " + tunjanganAnak);
            System.out.println("Total Tunjangan: Rp. " + tunjangan);
            System.out.println("Potongan Gaji: Rp. " + potongan);
            System.out.println("Gaji Setelah Pajak: Rp. " + gajitotal);

            if (gajiTerbesar == 0 || gajitotal > gajiTerbesar) {
                gajiTerbesar = gajitotal;
                namaGajiTerbesar = nama;
                nipGajiTerbesar = nip;
            }
            if (gajiTerkecil == 0 || gajitotal < gajiTerkecil) {
                gajiTerkecil = gajitotal;
                namaGajiTerkecil = nama;
                nipGajiTerkecil = nip;
            }
            jumlahKaryawan++;

            System.out.print("\nApakah Anda ingin menambah data karyawan lagi?\n(1.Ya, 2.Tidak): ");
            lanjut = input.nextInt();
            input.nextLine();

        } while (lanjut == 1);

        if (jumlahKaryawan == 0) {
            System.out.println("\nTidak ada data karyawan.");
        } else if (jumlahKaryawan == 1) {
            System.out.println("\nGaji Karyawan:");
            System.out.println("Nama: " + namaGajiTerbesar);
            System.out.println("NIP: " + nipGajiTerbesar);
            System.out.println("Dengan Gaji Sebesar: RP." + gajiTerbesar);
        } else {
            System.out.println("\nGaji Karyawan Terbesar:");
            System.out.println("Nama: " + namaGajiTerbesar);
            System.out.println("NIP: " + nipGajiTerbesar);
            System.out.println("Dengan Gaji Sebesar: RP." + gajiTerbesar);

            System.out.println("\nGaji Karyawan Terkecil:");
            System.out.println("Nama: " + namaGajiTerkecil);
            System.out.println("NIP: " + nipGajiTerkecil);
            System.out.println("Dengan Gaji Sebesar: RP." + gajiTerkecil);
        }
    }
}