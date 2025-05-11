public class BotanyEncyclopedia {

    public static String getInfoByType(String type) {
        switch (type.toLowerCase()) {
            case "hias":
                return "🌸 Tanaman Hias:\n" +
                       "Jenis tanaman yang digunakan untuk mempercantik ruangan atau taman.\n" +
                       "Contoh: Anggrek, Mawar, Bonsai.";
            case "obat":
                return "🌿 Tanaman Obat:\n" +
                       "Jenis tanaman yang memiliki khasiat kesehatan dan digunakan dalam pengobatan tradisional.\n" +
                       "Contoh: Kunyit, Jahe, Lidah Buaya, Sambiloto,daun kelor, temulawak.";
            case "sayur":
                return "🥬 Tanaman Sayur:\n" +
                       "Tanaman yang ditanam untuk dikonsumsi sebagai makanan.\n" +
                       "Contoh: Bayam, Kangkung, Tomat.";
            default:
                return "❓ Tipe tanaman tidak dikenal. Gunakan kata 'hias', 'obat', atau 'sayur'.";
        }
    }

    public static String getInfoByName(String name) {
        switch (name.toLowerCase()) {
            case "mawar":
                return "🌹 Mawar adalah bunga hias yang melambangkan cinta. Memerlukan banyak cahaya matahari dan penyiraman rutin.";
            case "lidah buaya":
                return "🌿 Lidah Buaya memiliki manfaat untuk kulit dan pencernaan. Tahan kering dan cocok sebagai tanaman obat.";
            case "bayam":
                return "🥬 Bayam adalah sayuran hijau yang kaya zat besi. Mudah tumbuh dan cepat panen.";
            default:
                return "📘 Informasi tanaman tidak ditemukan.";
        }
    }
}