package com.oaksoftstudio.ourpride;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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

public class ShohidActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap <String, String> hashMap;

    MyAdapter adapter = new MyAdapter(arrayList);

    // for search view
    SearchView searchView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shohid);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        getWindow().setStatusBarColor(Color.parseColor("#091A2A"));

        gridView = findViewById(R.id.gridView);
        ShohidList();
        gridView.setAdapter(adapter);


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














    }//=================

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
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder")
            View myView = layoutInflater.inflate(R.layout.photo_card, parent, false);


            @SuppressLint({"MissingInflatedId", "LocalSuppress"})
            RelativeLayout shohidBtn = myView.findViewById(R.id.shohidBtn);


            //item er identity

            ImageView imgSetId = myView.findViewById(R.id.imgSetId);
            TextView nameSetId = myView.findViewById(R.id.nameSetId);
            TextView taglineSetId = myView.findViewById(R.id.taglineSetId);



            // data parsing

            HashMap <String,String> hashMapGet = MyarrayList.get(position);

            String getImg = hashMapGet.get("shohidPic");

            String getName = hashMapGet.get("shohidName");
            String getTagline = hashMapGet.get("shohidTagline");

            String getAge = hashMapGet.get("shohidAge");
            String getVarsity = hashMapGet.get("shohidVarsity");
            String getDeath = hashMapGet.get("shohidDeath");
            String getPlace = hashMapGet.get("shohidPlace");
            String getLifestyle = hashMapGet.get("shohidLifestyle");
            String getDescribe = hashMapGet.get("shohidDescribe");

            shohidBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ShohidDescribe.IMAGE = getImg;

                    ShohidDescribe.NAME = getName;
                    ShohidDescribe.CARRIER = getTagline;

                    ShohidDescribe.AGE = getAge;
                    ShohidDescribe.VARSITY = getVarsity;
                    ShohidDescribe.DEATH = getDeath;
                    ShohidDescribe.PLACE = getPlace;
                    ShohidDescribe.LIFESTYLE = getLifestyle;
                    ShohidDescribe.DESCRIBE = getDescribe;

                    Intent myIntent = new Intent(ShohidActivity.this,ShohidDescribe.class);
                    startActivity(myIntent);
                }
            });







            //hashmap theke get kora ======================
            //   hashMap = arrayList.get(position);




/*

            // img set kora drawable theke ==================================
            int imgDrawable = Integer.parseInt(getImg);
            imgSetId.setImageResource(imgDrawable);
*/

            // img set kora online link theke ==================================
            Picasso.get()
                    .load(getImg)
                    .into(imgSetId);

            // set
            nameSetId.setText(getName);
            taglineSetId.setText(getTagline);


            return myView;
        }

    }//baseAdapter end

    private void fileList(String newText) {
        ArrayList<HashMap<String, String>> arrayList1 = new ArrayList<>();
        for (HashMap<String, String> newHashmap : arrayList) {
            if (newHashmap.get("shohidName").toLowerCase().contains(newText.toLowerCase())) {
                arrayList1.add(newHashmap);
            }
        }
        if (arrayList1.isEmpty()) {
            Toast.makeText(ShohidActivity.this, "খুঁজে পাওয়া যায় নি", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setFilteredList(arrayList1);
        }
    }

    private void ShohidList(){


        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/abu-sayed.jpg");
        hashMap.put("shohidName","আবু সাইদ");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        // chap dewar por porer page a jegula show korbe sesob data
        hashMap.put("shohidAge","২৩ বছর");
        hashMap.put("shohidVarsity","বেগম রোকেয়া বিশ্ববিদ্যালয়, রংপুর");

        hashMap.put("shohidDeath","১৬ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","বাবনপুর, পীরগঞ্জ, রংপুর");
        hashMap.put("shohidLifestyle","রোকেয়া বিশ্ববিদ্যালয়ের ইংরেজি বিভাগের ১২তম ব্যাচের শিক্ষার্থী আবু সাঈদ ২০০১ সালে রংপুর জেলার পীরগঞ্জ উপজেলার বাবনপুর গ্রামে জন্মগ্রহণ করেন। মকবুল হোসেন এবং মনোয়ারা বেগমের ছয় ছেলে ও তিন মেয়ের মধ্যে আবু সাঈদ ছিলেন সবার ছোট। তিনি স্থানীয় জাফর পাড়া সরকারি প্রাথমিক বিদ্যালয় থেকে পঞ্চম শ্রেণিতে ট্যালেন্টপুলে বৃত্তি পেয়ে স্থানীয় খালাশপীর দ্বিমুখী উচ্চ বিদ্যালয় ভর্তি হন এবং এখান থেকে জি‌পিএ-৫ পে‌য়ে এসএসসি পাশ করে ২০১৮ সালে রংপুর সরকা‌রি কলেজে ভর্তি হন। এখান থেকে জি‌পিএ-৫ পেয়ে ইন্টারমিডিয়েট পাশ করে ২০২০ সালে বেগম রো‌কেয়া‌ বিশ্ব‌বিদ্যাল‌য়ে ইং‌রে‌জি বিভাগে ভ‌র্তি হন।");
        hashMap.put("shohidDescribe","১৬ জুলাই দুপুর আড়াইটা থেকে তিনটার দিকে রোকেয়া বিশ্ববিদ্যালয়ের সামনে কোটা সংস্কার আন্দোলনের শিক্ষার্থীদের শান্তিপূর্ণ সমাবেশে ছাত্রদের ছত্রভঙ্গ করার জন্য পুলিশ টিয়ার গ্যাস নিক্ষেপ ও লাঠিচার্জ করলে, ছাত্রদের সবাই স্থান ত্যাগ করলেও আবু সাঈদ হাতে একটি লাঠি নিয়ে দাঁড়িয়ে থাকেন। পুলিশ এই অবস্থায় তার উপরে গুলি ছুড়লে, হাতে থাকা লাঠি দিয়ে রাবার বুলেট ঠেকানোর চেষ্টা করছিলেন। একপর্যায়ে শরীরে একের পর রাবার বুলেটে ক্ষতবিক্ষত হওয়ার পর মাটিতে লুটিয়ে পড়েন আবু সাঈদ। হাসপাতালে নেয়ার আগেই তিনি মৃত্যুবরণ করেন।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/faisal-ahmed-shanto.jpg");
        hashMap.put("shohidName","ফয়সাল আহমেদ শান্ত");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidVarsity","ওমরগণি এম.ই.এস. কলেজ, চট্টগ্রাম");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৬ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","পতেঙ্গা, চট্টগ্রাম");
        hashMap.put("shohidLifestyle","ফয়সাল আহমেদ শান্ত এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","ফয়সাল আহমেদ শান্ত কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/md-wasim-akrum.jpg");
        hashMap.put("shohidName","মোঃ ওয়াসিম আকরুম");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidVarsity","চট্টগ্রাম কলেজ, চট্টগ্রাম");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৬ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","পেকুয়া, কক্সবাজার, চট্টগ্রাম");
        hashMap.put("shohidLifestyle","মোঃ ওয়াসিম আকরুম এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","মোঃ ওয়াসিম আকরুম কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/sakib-hasan.jpg");
        hashMap.put("shohidName","সাকিব হাসান");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","২২ বছর");
        hashMap.put("shohidVarsity","আর,কে চোধূরী স্কুল এন্ড কলেজ, সায়েদাবাদ, যাত্রাবাড়ী, ঢাকা");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৭ জুলাই, ২০২৪");
        hashMap.put("shohidPlace"," কাজলার পাড়, মধ্যপাড়া,যাত্রাবাড়ী, ঢাকা");
        hashMap.put("shohidLifestyle","সাকিব হাসান এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন");
        hashMap.put("shohidDescribe","আর কে চৌধুরী কলেজ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/tahmid-tamim.jpg");
        hashMap.put("shohidName","তাহমিদ তামিম");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","১৫ বছর");
        hashMap.put("shohidVarsity","কাদির মোল্লা হাই স্কুল, নরসিংদী");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidLifestyle","তাহমিদ তামিম এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","তাহমিদ তামিম কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/shykh-aashhabul-yamin.jpg");
        hashMap.put("shohidName","শাইখ আশহাবুল ইয়ামিন");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","২২ বছর");
        hashMap.put("shohidVarsity","মিলিটারি ইনস্টিটিউট অফ সায়েন্স অ্যান্ড টেকনোলজি, ঢাকা");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","কুমারখালী, কুষ্টিয়া, খুলনা");
        hashMap.put("shohidLifestyle","ইয়ামিন সাভার ক্যান্টনমেন্ট স্কুল অ্যান্ড কলেজ থেকে এসএসসি ও এইচএসসি পাস করেন। তিনি রাজধানীর মিরপুরের মিলিটারি ইনস্টিটিউট অব সায়েন্স অ্যান্ড টেকনোলজির (এমআইএসটি) কম্পিউটারবিজ্ঞান ও প্রকৌশল বিভাগের চতুর্থ বর্ষের শিক্ষার্থী ছিলেন, থাকতেন এমআইএসটির ওসমানী হলে। ইয়ামিন সাহসী ছিলেন। অন্যায় দেখলেই প্রতিবাদ করতেন। ইয়ামিন অত্যন্ত মেধাবী ছিলেন। বন্ধুরা কোনো বিষয় বুঝতে না পারলে ইয়ামিন বুঝিয়ে দিতেন। ইয়ামিন বিতর্ক করতেন। এমআইএসটিতে বিতর্ক ক্লাবের ভাইস প্রেসিডেন্ট ছিলেন ইয়ামিন। ছেলে বড় হলেও অবসরে ছোট বাচ্চাদের মতো ‘টম অ্যান্ড জেরি’ থেকে শুরু করে বিভিন্ন কার্টুন দেখতেন বলে জানান তার বাবা।");
        hashMap.put("shohidDescribe","পুলিশের গুলিতে নিহত");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/jahiduzzaman-tanvin.jpg");
        hashMap.put("shohidName","জাহিদ্দুজ্জামান তানভিন");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidVarsity","ইসলামিক ইউনিভার্সিটি অফ টেকনোলজি, গাজীপুর");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","ব্রাহ্মণবাড়িয়া, চট্টগ্রাম");
        hashMap.put("shohidLifestyle","জাহিদ্দুজ্জামান তানভিন এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","জাহিদ্দুজ্জামান তানভিন কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/farhan-faiyaaz.jpg");
        hashMap.put("shohidName","ফারহান ফাইয়াজ");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","১৭ বছর");
        hashMap.put("shohidVarsity","ঢাকা রেসিডেনসিয়াল মডেল কলেজ, মোহাম্মদপুর");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidLifestyle","ফারহান ফাইয়াজ এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","ফারহান ফাইয়াজ কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/mir-mugdho.jpg");
        hashMap.put("shohidName","মীর মুগ্ধ");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidVarsity","বাংলাদেশ ইউনিভার্সিটি অফ প্রফেশনালস");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidLifestyle","মীর মুগ্ধ এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","মীর মুগ্ধ কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/shah-newaz-fahad.jpg");
        hashMap.put("shohidName","শাহ নেওয়াজ ফাহাদ");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidVarsity","ইস্ট ওয়েস্ট ইউনিভার্সিটি, ঢাকা");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidLifestyle","শাহ নেওয়াজ ফাহাদ এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","শাহ নেওয়াজ ফাহাদ কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/shakil-parvej.jpg");
        hashMap.put("shohidName","শাকিল পারভেজ");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidVarsity","মানারাত ইন্টারন্যাশনাল ইউনিভার্সিটি");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath"," ১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","গাজীপুর, ঢাকা");
        hashMap.put("shohidLifestyle","শাকিল পারভেজ এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","শাকিল পারভেজ কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/sheikh-fahmin-zafor.jpg");
        hashMap.put("shohidName","শেখ ফাহমিন জাফর");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","১৭ বছর");
        hashMap.put("shohidVarsity","টংগী সরকারি কলেজ");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","আত্রাই, নওগাঁ, রাজশাহী");
        hashMap.put("shohidLifestyle","শেখ ফাহমিন জাফর এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","শেখ ফাহমিন জাফর কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/zillur-sheikh.jpg");
        hashMap.put("shohidName","জিল্লুর শেখ");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","২০ বছর");
        hashMap.put("shohidVarsity","ইম্পেরিয়াল কলেজ, ঢাকা");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","গোপালগঞ্জ, ঢাকা");
        hashMap.put("shohidLifestyle","জিল্লুর শেখ এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","জিল্লুর শেখ কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/dipto-dey.jpg");
        hashMap.put("shohidName","দীপ্ত দে");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","২১ বছর");
        hashMap.put("shohidVarsity","মাদারীপুর সরকারি কলেজ");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","মাদারীপুর, ঢাকা");
        hashMap.put("shohidLifestyle","দীপ্ত দে এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","দীপ্ত দে কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/rudro-sen.jpg");
        hashMap.put("shohidName","রুদ্র সেন");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidVarsity","শাহজালাল বিজ্ঞান ও প্রযুক্তি বিশ্ববিদ্যালয়, সিলেট");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","দিনাজপুর, রাজশাহী");
        hashMap.put("shohidLifestyle","রুদ্র সেন এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","রুদ্র সেন কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/emon-ahmed.jpg");
        hashMap.put("shohidName","ইমন আহমেদ");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidVarsity","ইউনিভার্সিটি অফ ক্রিয়েটিভ টেকনোলজি, চট্টগ্রাম");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidLifestyle","ইমন আহমেদ এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","ইমন আহমেদ কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/imon-miah.jpg");
        hashMap.put("shohidName","ইমন মিয়া");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidVarsity","সরকারি শহীদ আসাদ কলেজ, নরসিংদী");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidLifestyle","ইমন মিয়া এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","ইমন মিয়া কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/kalid-hasan-saifullah.jpg");
        hashMap.put("shohidName","খালিদ হাসান সাইফুল্লাহ");
        hashMap.put("shohidTagline","শিক্ষার্থী");


        hashMap.put("shohidAge","১৮ বছর");
        hashMap.put("shohidVarsity","ইম্পেরিয়াল কলেজ, ঢাকা");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace"," লালবাগ, ঢাকা");
        hashMap.put("shohidLifestyle","হাফেজ আব্দুর রাজ্জাক মাদ্রাসার শিক্ষক কামরুল হাসানের সন্তান।");
        hashMap.put("shohidDescribe","খালিদ হাসান সাইফুল্লাহ কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/unknown-dead-body.jpg");
        hashMap.put("shohidName","মোহাম্মদ ইমাদ");
        hashMap.put("shohidTagline","শিক্ষার্থী");


        hashMap.put("shohidAge","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidVarsity","পটিয়া সরকারি কলেজ, চট্টগ্রাম");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidLifestyle","মোহাম্মদ ইমাদ এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","মোহাম্মদ ইমাদ কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/asif-iqbal.jpg");
        hashMap.put("shohidName","আসিফ ইকবাল");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","৩১ বছর");
        hashMap.put("shohidVarsity","ইন্ডিপেন্ডেন্ট বিশ্ববিদ্যালয় বাংলাদেশ, ঢাকা");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","মাগুরা, খুলনা");
        hashMap.put("shohidLifestyle","আসিফ ইকবাল এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","আসিফ ইকবাল কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/hridoy-chandra-tarua.jpg");
        hashMap.put("shohidName","হৃদয় চন্দ্র তরুয়া");
        hashMap.put("shohidTagline","শিক্ষার্থী");


        hashMap.put("shohidAge","২২ বছর");
        hashMap.put("shohidVarsity","চট্টগ্রাম বিশ্ববিদ্যালয়");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","মির্জাগঞ্জ, পটুয়াখালী");
        hashMap.put("shohidLifestyle","হৃদয় চন্দ্র তরুয়া এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","হৃদয় চন্দ্র তরুয়া কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/rahat-hossain.jpg");
        hashMap.put("shohidName","রাহাত হোসেন");
        hashMap.put("shohidTagline","শিক্ষার্থী");


        hashMap.put("shohidAge","১৮ বছর");
        hashMap.put("shohidVarsity","নওয়াব হাবিবুল্লাহ্ মডেল স্কুল এন্ড কলেজের, ঢাকা");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","গোপালপুর, টংগী, গাজীপুর");
        hashMap.put("shohidLifestyle","রাহাত হোসেন এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","রাহাত হোসেন কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/asif-hasan.jpg");
        hashMap.put("shohidName","আসিফ হাসান");
        hashMap.put("shohidTagline","শিক্ষার্থী");


        hashMap.put("shohidAge","২১ বছর");
        hashMap.put("shohidVarsity","নর্দান ইউনিভার্সিটি বাংলাদেশ");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath"," ১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","আস্কারপুর, দেবহাটা, সাতক্ষীরা");
        hashMap.put("shohidLifestyle","আসিফ হাসান এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","১৮ জুলাই ঢাকার উত্তরায় বিক্ষোভকারীদের সঙ্গে পুলিশের সংঘর্ষে গুলিতে মারাত্মক আহত হন আসিফ হাসান। দুপুর ১২টার দিকে তাঁকে উত্তরা আধুনিক মেডিকেলে নিয়ে গেলে কর্তব্যরত চিকিৎসক মৃত ঘোষণা করেন।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/md-ahsadun.jpg");
        hashMap.put("shohidName","মোঃ আহাদুন");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","১৫ বছর");
        hashMap.put("shohidVarsity","ইউসিইপি হাজি সিকান্দার আলী টেকনিকাল স্কুল।");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","বড্ডা, ঢাকা।");
        hashMap.put("shohidLifestyle","মোঃ আহাদুন এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","১৮-ই জুলাই বিকালে/সন্ধ্যায় তার বাসা থেকে মেরুল বাড্ডা মেইন রোডে যায়। এরপর থাকে দুই দিন যাবত সে নিখোঁজ। দুইদিন পর তার লাশ ঢাকা মেডিকেল কলেজের মর্গে পাওয়া যায়। সে গুলিতে নিহত হয়েছে।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/unknown-dead-body.jpg");
        hashMap.put("shohidName","মোঃ সাকলাইন");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","২৬ বছর");
        hashMap.put("shohidVarsity","ইউনাইটেড ইন্টারন্যাশনাল ইউনিভার্সিটি");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidLifestyle","মোঃ সাকলাইন এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","মোঃ সাকলাইন কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/amjad-hosen.jpg");
        hashMap.put("shohidName","আমজাদ হোসেন");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","২২ বছর");
        hashMap.put("shohidVarsity","সরকারি শহীদ আসাদ কলেজ, শিবপুর, নরসিংদী");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","নরসিংদী");
        hashMap.put("shohidLifestyle","আমজাদ হোসেন এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","পুলিশের ছোড়া গুলি বিদ্ধ হয়ে মারা যান");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/unknown-dead-body.jpg");
        hashMap.put("shohidName","মোঃ ফারুক");
        hashMap.put("shohidTagline","চাকরিজীবী");

        hashMap.put("shohidAge","৩২ বছর");
        hashMap.put("shohidVarsity","ষোলশহর, চট্টগ্রাম এর একটি চেয়ারের দোকানের কর্মচারী");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৬ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","কুমিল্লা");
        hashMap.put("shohidLifestyle","মোঃ ফারুক এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","ফারুক ষোলশহরের একটি চেয়ারের দোকানে কাজ করতেন। মঙ্গলবার (১৬ জুলাই) বেলা ৩টার পর তিনি নগরের লালখান বাজারের ভাড়া বাসা থেকে আবার দোকানে ফিরছিলেন। কিন্তু ষোলশহরের কাছে আন্দোলনকারী ও ছাত্রলীগের সংঘর্ষের মধ্যে পড়ে যান তিনি। এ সময় গুলিবিদ্ধ হয়ে ঘটনাস্থলইে প্রাণ হারান ফারুক। তবে তার পরও আশপাশের লোকজন তাকে চট্টগ্রাম মেডিকেল কলেজ হাসপাতালে নিয়ে যান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/mehedi-hasan.jpg");
        hashMap.put("shohidName","হাসান মেহেদী");
        hashMap.put("shohidTagline","ঢাকা টাইমস");

        hashMap.put("shohidAge","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidVarsity","ঢাকা টাইমস");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidLifestyle","হাসান মেহেদী এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","হাসান মেহেদী কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/siam-1.jpg");
        hashMap.put("shohidName","সিয়াম");
        hashMap.put("shohidTagline","চাকরিজীবী");

        hashMap.put("shohidAge","১৮ বছর");
        hashMap.put("shohidVarsity","মোবাইল ব্যাটারির দোকান, ঢাকা");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath"," ১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidLifestyle","সিয়াম এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","সিয়াম কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("shohidPic","https://shohid.info/shohid/unknown-dead-body.jpg");
        hashMap.put("shohidName","দুলাল মাতবর");
        hashMap.put("shohidTagline","গাড়ী চালক");

        hashMap.put("shohidAge","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidVarsity","ঢাকা");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidLifestyle","দুলাল মাতবর এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","দুলাল মাতবর কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/unknown-dead-body.jpg");
        hashMap.put("shohidName","মোহাম্মদ");
        hashMap.put("shohidTagline","তথ্য পাওয়া যায় নি।");

        hashMap.put("shohidAge","২০ বছর");
        hashMap.put("shohidVarsity","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidLifestyle","মোহাম্মদ এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","মোহাম্মদ কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/unknown-dead-body.jpg");
        hashMap.put("shohidName","শাকিল হাসান");
        hashMap.put("shohidTagline","সাংবাদিক");

        hashMap.put("shohidAge","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidVarsity","দৈনিক ভোরের আওয়াজ");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidLifestyle","শাকিল হাসান এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","শাকিল হাসান কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/sabbir-ahmed-jhenaidah.jpg");
        hashMap.put("shohidName","সাব্বির আহমেদ");
        hashMap.put("shohidTagline","চাকরিজীবী");


        hashMap.put("shohidAge","২২ বছর");
        hashMap.put("shohidVarsity","অর্গান লিমিটেড কেয়ার");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace"," শৈলকুপা, ঝিনাইদহ, খুলনা");
        hashMap.put("shohidLifestyle","বাবা আমদ আলী ও মা রাশিদা খাতুন। তিন সন্তানের মধ্যে সাব্বির সবার বড়। ছোট দুই ভাইবোন, সুমাইয়া খাতুন (১৭) ও সাদিক হোসেন (১২)। বাবার নিজের কোনো কৃষিজমি নেই। অন্যের জমিতে কাজ করে সংসার চালান তিনি। সাব্বির মাদ্রাসা ছাত্র ছিলেন । পরিবারের বড় সন্তান হিসাবে সংসারের হাল ধরতে উপার্জনের আশায় ঢাকায় গিয়েছিলেন। প্রথমে উত্তরায় চাচাতো ভাই শামীম হোসেনের দোকানে কাজ করতেন । পরে অন্য কোম্পানিতে কাজ নেয় । ১৯ জুলাই সকাল সাড়ে ১০টার দিকে তাঁর লাশ পারিবারিক কবরস্থানে দাফন করা হয়।");
        hashMap.put("shohidDescribe","তাঁর শরীরে জ্বর ছিল। তাই বাইরের অবস্থা খারাপ হলেও ওষুধের জন্য বের হয়েছিলেন।সেখানে গুলিতে তাঁর মৃত্যু হয়।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/dr-sajib-sarker.jpg");
        hashMap.put("shohidName","ডাঃ সজীব সরকার");
        hashMap.put("shohidTagline","ডাক্তার");

        hashMap.put("shohidAge","২৮ বছর");
        hashMap.put("shohidVarsity","তায়রুননেছা মেমোরিয়াল মেডিকেল কলেজ, টঙ্গী");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidLifestyle","ডাঃ সজীব সরকার এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","ডাঃ সজীব সরকার কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/unknown-dead-body.jpg");
        hashMap.put("shohidName","মানিক মিয়া");
        hashMap.put("shohidTagline","অটো চালক");


        hashMap.put("shohidAge","২৮ বছর");
        hashMap.put("shohidVarsity","অটো চালক");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidLifestyle","মানিক মিয়া এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","মানিক মিয়া কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/unknown-dead-body.jpg");
        hashMap.put("shohidName","জুবায়ের আহমেদ");
        hashMap.put("shohidTagline","ব্যবসায়ী");

        hashMap.put("shohidAge","২৫ বছর");
        hashMap.put("shohidVarsity","কাওলা হাজী ক্যাম্প");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace"," দক্ষিনখান উত্তরা ঢাকা");
        hashMap.put("shohidLifestyle","জুবায়ের আহমেদ এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","উত্তরা আজমপুরে পুলিশের গুলিতে");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/abdullah-al-tahir.jpg");
        hashMap.put("shohidName","আব্দুল্লাহ আল তাহির");
        hashMap.put("shohidTagline","গ্রাফিক্স ডিজাইনার");

        hashMap.put("shohidAge"," ২৮ বছর");
        hashMap.put("shohidVarsity","সৃজন গ্রাফিক্স প্রিন্টার্স, সিরাজ মার্কেট রোড, উত্তরা, ঢাকা");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","রংপুর");
        hashMap.put("shohidLifestyle","আব্দুল্লাহ আল তাহির এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","গত ১৮ জুলাই বৈষম্যবিরোধী আন্দোলনে গুলিবিদ্ধ হয়ে শাহাদাত বরণ করেছেন");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/saimon-hossain.jpg");
        hashMap.put("shohidName","সাইমন হোসেন");
        hashMap.put("shohidTagline","দোকান কর্মচারী");

        hashMap.put("shohidAge","১৪ বছর");
        hashMap.put("shohidVarsity","সাইমন বহদ্দারহাটে একটি মুদী দোকানে কাজ করতেন");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","হারামিয়া, সন্দীপ, চট্রগ্রাম");
        hashMap.put("shohidLifestyle","সাইমন হোসেন এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","বৃহষ্পতিবার বহদ্দারহাট মোড়ে সংঘর্ষের সময় গুলিবিদ্ধ হয়ে নিহত হয় সাইমন। ঘটনাস্থল থেকে গুলিবিদ্ধ সাইমনকে চট্টগ্রাম মেডিকেল নিয়ে যাওয়া হলে কর্তব্যরত চিকিৎসক তাকে মৃত ঘোষনা করেন।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/unknown-dead-body.jpg");
        hashMap.put("shohidName","এহসান হাবিব");
        hashMap.put("shohidTagline","চাকরিজীবী");

        hashMap.put("shohidAge","২২ বছর");
        hashMap.put("shohidVarsity","বিআরবি ক্যাবল ইন্ডাস্ট্রিজ লিমিটেড");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি।");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","ফাঁসিয়াখালী, চকরিয়া, কক্সবাজার");
        hashMap.put("shohidLifestyle","এহসান হাবিব এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","১৮ জুলাই বৃহস্পতিবার পুলিশের সঙ্গে আন্দোলনকারীদের সংঘর্ষে হাশেমিয়া কামিল মাদরাসা এলাকায় আন্দোলনকারীদের ছয়জন গুলিবিদ্ধ হন। তাঁদের কক্সবাজার সদর হাসপাতালে ভর্তি করা হয়। তাঁদের মধ্যে আশঙ্কাজনক অবস্থায় এহসান হাবিব (২২) চট্টগ্রাম মেডিক্যাল কলেজ (চমেক) হাসপাতালে নেওয়ার পথে মারা যান।");
        arrayList.add(hashMap);


    }

}//================