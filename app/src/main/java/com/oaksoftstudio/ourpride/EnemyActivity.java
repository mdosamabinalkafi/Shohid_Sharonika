package com.oaksoftstudio.ourpride;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class EnemyActivity extends AppCompatActivity {


    GridView gridView3;
    ArrayList<HashMap<String, String>> enemyArraylist = new ArrayList<>();
    HashMap <String, String> hashMap3;

    MyAdapter enemyAdapter = new MyAdapter(enemyArraylist);

    // for search view
    SearchView searchView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_enemy);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getWindow().setStatusBarColor(Color.parseColor("#091A2A"));



        gridView3 = findViewById(R.id.gridView3);

        EnemyList();

        gridView3.setAdapter(enemyAdapter);






        // for search view
        searchView = findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                fileList(newText);
                return true;
            }
        });



















    }//======================

    public class MyAdapter extends BaseAdapter {

        // for search view
        ArrayList<HashMap<String, String>> MyarrayList;

        public MyAdapter(ArrayList<HashMap<String, String>> arrayList) {
            this.MyarrayList = arrayList;
        }

        public void setFilteredList(ArrayList<HashMap<String, String>> filteredList) {
            this.MyarrayList = filteredList;
            notifyDataSetChanged();
        }


        @Override
        public int getCount() {
            return MyarrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position3, View convertView3, ViewGroup parent3) {

            LayoutInflater layoutInflater3 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder")
            View myView3 = layoutInflater3.inflate(R.layout.enemy_card, parent3, false);








            // data parsing

            HashMap<String,String> hashMapGet = MyarrayList.get(position3);

            String getImg = hashMapGet.get("enemyImg");
            String getName = hashMapGet.get("enemyName");
            String getTagline = hashMapGet.get("enemyTagline");
            String getCase = hashMapGet.get("enemyCase");





            //item er identity

            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView enemyImgSet = myView3.findViewById(R.id.enemyImgSet);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView enemyNameSet = myView3.findViewById(R.id.enemyNameSet);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView enemyTaglineSet = myView3.findViewById(R.id.enemyTaglineSet);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView anemyCaseSet = myView3.findViewById(R.id.anemyCaseSet);




/*

            // img set kora drawable theke ==================================
            int imgDrawable = Integer.parseInt(getImg);
            imgSetId.setImageResource(imgDrawable);
*/

            // img set kora online link theke ==================================
            Picasso.get()
                    .load(getImg)
                    .into(enemyImgSet);

            // set
            enemyNameSet.setText(getName);
            enemyTaglineSet.setText(getTagline);
            anemyCaseSet.setText(getCase);


            return myView3;
        }

    }//baseAdapter end

    private void fileList(String newText) {
        ArrayList<HashMap<String, String>> arrayList1 = new ArrayList<>();
        for (HashMap<String, String> enemyHashmap : enemyArraylist) {
            if (enemyHashmap.get("enemyName").toLowerCase().contains(newText.toLowerCase())) {
                arrayList1.add(enemyHashmap);
            }
        }
        if (arrayList1.isEmpty()) {
            Toast.makeText(EnemyActivity.this, "খুঁজে পাওয়া যায় নি", Toast.LENGTH_SHORT).show();
        } else {
            enemyAdapter.setFilteredList(arrayList1);
        }
    }

    private void EnemyList(){


        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/%E0%A6%AE%E0%A7%87%E0%A6%B9%E0%A7%87%E0%A6%A6%E0%A7%80-%E0%A6%B9%E0%A6%BE%E0%A6%B8%E0%A6%BE%E0%A6%A8-%E0%A6%95%E0%A6%BE%E0%A6%89%E0%A6%B8%E0%A6%BE%E0%A6%B0_01.jpg");
        hashMap3.put("enemyName","মেহেদী হাসান কাওসার সজীব");
        hashMap3.put("enemyTagline","সাবেক সিনিয়র সহ-সভাপতি, ১ম ওয়ার্ড ছাত্রলীগ, ঢাকা মহানগর উত্তর");
        hashMap3.put("enemyCase","কেস: 2024 সালের 2 আগস্ট উত্তরা-11-এ মহিলা বিক্ষোভকারীদের গলা টিপে ধরে শারীরিকভাবে আক্রমণ করা হয়।");
        enemyArraylist.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/453416957_1029233582094707_4124007712039784583_n-1.jpg");
        hashMap3.put("enemyName","রেদোয়ানুল ইসলাম");
        hashMap3.put("enemyTagline","লেফটেন্যান্ট কর্নেল");
        hashMap3.put("enemyCase","কেস: 27 জুলাই, 2024-এ রামপুরা ওভারব্রিজের নীচে খুব কাছ থেকে বিক্ষোভকারীদের উপর AK47 রাইফেলের রাউন্ড (বুক বরাবর) গুলি করা হয়েছিল");
        enemyArraylist.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Abdur-Razzak-Jewel_03.webp");
        hashMap3.put("enemyName","আব্দুর রাজ্জাক জুয়েল");
        hashMap3.put("enemyTagline","সহ-সভাপতি, উত্তরা পশ্চিম থানা ছাত্রলীগ, ঢাকা মোহনগোর উত্তর");
        hashMap3.put("enemyCase","কেস: ছাত্রলীগের সদস্যদের নির্দেশনা দিয়ে সাধারণ ছাত্রদের মারধর করা হয় এবং বলতে দেখা যায়, 33 জুলাই, 2024 তারিখে উত্তরায় গুলি করে মেরে ফেলব।");
        enemyArraylist.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/rakib-hassan-ratul_05.jpeg");
        hashMap3.put("enemyName","রাকিব হাসান রাতুল");
        hashMap3.put("enemyTagline","তথ্য পাওয়া যায়নি");
        hashMap3.put("enemyCase","কেস: 2 আগস্ট, 2024-এ উত্তরা-11-এ প্রাণঘাতী অস্ত্রের সাথে দেখা হয়েছে।");
        enemyArraylist.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Junayet-Al-Habib_06.webp");
        hashMap3.put("enemyName","জুনায়েত আল হাবিব (লিওন খান)");
        hashMap3.put("enemyTagline","সাংগঠনিক সম্পাদক, বিএসএল, ঢাকা মেট্রোপলিটন উত্তর");
        hashMap3.put("enemyCase","কেস: 2 আগস্ট, 2024-এ উত্তরা সেক্টর 11-এ লাঠি হাতে BSL সদস্যদের নিয়ে একটি মিছিলের সাথে দেখা গেছে।");
        enemyArraylist.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/452276952_1210306950119541_381565650964526671_n.jpg");
        hashMap3.put("enemyName","সাকিব আরাফাত মৃধা");
        hashMap3.put("enemyTagline","ছাত্র (রাজনীতি বিজ্ঞান, ডু- 2019-20 সেশন)");
        hashMap3.put("enemyCase","কেস: ঢাকা বিশ্ববিদ্যালয়ে ১৫ জুলাই হত্যাকাণ্ডের হামলাকারী দলের সঙ্গে দেখা গেছে।");
        enemyArraylist.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Yunus-Ali_08.jpg");
        hashMap3.put("enemyName","ইউনুস আলী");
        hashMap3.put("enemyTagline","সাব-ইন্সপেক্টর");
        hashMap3.put("enemyCase","কেস: 2024 সালের 16 জুলাই রংপুরে আবু সাঈদকে গুলি করে।");
        enemyArraylist.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Byazid_09.jpeg");
        hashMap3.put("enemyName","বায়াজিদ");
        hashMap3.put("enemyTagline","তথ্য পাওয়া যায়নি");
        hashMap3.put("enemyCase","কেস: একজন পথচারীকে উপহাস করে একটি TikTok ভিডিও তৈরি করেছে পুলিশ");
        enemyArraylist.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/MD-Arshad-Hossain-Akash_2unverified-1.jpg");
        hashMap3.put("enemyName","আরশাদ হোসেন আকাশ");
        hashMap3.put("enemyTagline","ভারপ্রাপ্ত কর্মকর্তা (পুলিশ)");
        hashMap3.put("enemyCase","কেস: কথা বলতে বাধা দিতে তিনি এক ছাত্রের মুখ চেপে ধরেন। স্পষ্ট করার জন্য, ছাত্রটি শান্তভাবে কথা বলার চেষ্টা করেছিল এবং সশস্ত্র ছিল না।");
        enemyArraylist.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Abdullah-Kaiyum_11.jpg");
        hashMap3.put("enemyName","আবদুল্লাহ কাইয়ুম (কাইয়ুম মোল্লা)");
        hashMap3.put("enemyTagline","তথ্য পাওয়া যায়নি");
        hashMap3.put("enemyCase","কেস: বাঁশের অস্ত্র নিয়ে পেছন থেকে নিরস্ত্র নারী বিক্ষোভকারীদের ওপর হামলা চালায়");
        enemyArraylist.add(hashMap3);


        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Apurbo-Hasan_12.png");
        hashMap3.put("enemyName","অপূর্ব হাসান");
        hashMap3.put("enemyTagline","অফিসার ইনচার্জ, পল্লবী থানা, ডিএমপি, ঢাকা");
        hashMap3.put("enemyCase","কেস: বিক্ষোভকারীদের জিজ্ঞাসা, “আমরা তাকে হত্যা করেছি। তুমি কি করবে?");
        enemyArraylist.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Ashraful-Hasan-Mohon_22.jpg");
        hashMap3.put("enemyName","আশরাফুল হাসান মোহন");
        hashMap3.put("enemyTagline","যুগ্ম আহ্বায়ক, ফেনী পৌর সেচ্ছাসেবক লীগ");
        hashMap3.put("enemyCase","কেস: ফেনীতে নেতৃস্থানীয় গুন্ডাদের মারাত্মক অস্ত্র বহন করতে দেখা গেছে");
        enemyArraylist.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Depak-Saha_12.jpg");
        hashMap3.put("enemyName","দীপক সাহা");
        hashMap3.put("enemyTagline","ওএমএস ডিলার, নরসিংদী");
        hashMap3.put("enemyCase","কেস: নিরস্ত্র এক নারীকে শারীরিকভাবে লাঞ্ছিত করেছে।");
        enemyArraylist.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Anjuman-Rahman-Richi_13.jpg");
        hashMap3.put("enemyName","আঞ্জুমান রহমান রিচি");
        hashMap3.put("enemyTagline","মহিলা ভাইস চেয়ারম্যান, নরসিংদী, উপজেলা");
        hashMap3.put("enemyCase","কেস: অন্যান্য বিএএল সদস্যদের সাথে একজন নিরস্ত্র মহিলাকে শারীরিকভাবে লাঞ্ছিত করেছে।");
        enemyArraylist.add(hashMap3);




    }






}//========================