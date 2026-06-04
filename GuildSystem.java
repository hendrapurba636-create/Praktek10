import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GuildSystem {

    public static void main(String[] args) {

        // ==========================
        // PROSES SAVE
        // ==========================

        ArrayList<Member> daftarMember = new ArrayList<>();

        daftarMember.add(new Member("M001", "Andi"));
        daftarMember.add(new Member("M002", "Budi"));
        daftarMember.add(new Member("M003", "Citra"));

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream("guild_data.dat"))) {

            out.writeObject(daftarMember);
            System.out.println("Data guild berhasil disimpan.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ==========================
        // PROSES LOAD
        // ==========================

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream("guild_data.dat"))) {

            // Downcasting dari Object menjadi ArrayList<Member>
            ArrayList<Member> hasilLoad =
                    (ArrayList<Member>) in.readObject();

            System.out.println("\n=== DATA MEMBER HASIL LOAD ===");

            for (Member member : hasilLoad) {
                System.out.println(
                        "ID: " + member.getId()
                        + " | Nama: " + member.getNama()
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
