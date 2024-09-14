package com.oaksoftstudio.ourpride;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
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

public class NewsActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<HashMap<String, String>> newsArrayList = new ArrayList<>();
    HashMap <String, String> newsHashMap1;

    MyAdapter newsAdapter = new MyAdapter(newsArrayList);

    // for search view
    SearchView searchView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getWindow().setStatusBarColor(Color.parseColor("#091A2A"));

        listView = findViewById(R.id.listView);

        NewsList();

        listView.setAdapter(newsAdapter);




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
        public View getView(int position2, View convertView2, ViewGroup parent2) {

            LayoutInflater layoutInflater2 = (LayoutInflater)  getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder")
            View myView2 = layoutInflater2.inflate(R.layout.list_card, parent2, false);


            @SuppressLint({"MissingInflatedId", "LocalSuppress"})
            RelativeLayout newsBtn = myView2.findViewById(R.id.newsBtn);

            newsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (position2 == 0){

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://bn.wikipedia.org/wiki/%E0%A7%A8%E0%A7%A6%E0%A7%A8%E0%A7%AA-%E0%A6%8F_%E0%A6%AC%E0%A6%BE%E0%A6%82%E0%A6%B2%E0%A6%BE%E0%A6%A6%E0%A7%87%E0%A6%B6%E0%A7%87_%E0%A6%95%E0%A7%8B%E0%A6%9F%E0%A6%BE_%E0%A6%B8%E0%A6%82%E0%A6%B8%E0%A7%8D%E0%A6%95%E0%A6%BE%E0%A6%B0_%E0%A6%86%E0%A6%A8%E0%A7%8D%E0%A6%A6%E0%A7%8B%E0%A6%B2%E0%A6%A8"));
                        startActivity(intent);

                    } else if (position2 == 1) {

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.bbc.com/bengali/articles/ckgw5k0258xo"));
                        startActivity(intent);
                    }
                    else if (position2 == 2) {

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.jagonews24.com/national/news/961573"));
                        startActivity(intent);
                    }
                    else if (position2 == 3) {

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.somoynews.tv/news/2024-07-17/PGxF5CDM"));
                        startActivity(intent);
                    } else if (position2 == 4) {

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.prothomalo.com/bangladesh/djik2als3t"));
                        startActivity(intent);

                    }else if (position2 == 5) {

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.youtube.com/watch?v=l6vM1gtzbL0"));
                        startActivity(intent);

                    }else if (position2 == 6) {

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.prothomalo.com/technology/freelancing/fll4gi2o1m"));
                        startActivity(intent);
                    }else if (position2 == 7) {

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://dailyinqilab.com/national/news/671874"));
                        startActivity(intent);

                    }else if (position2 == 8) {

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.somoyerkonthosor.com/post/2024/07/15/66951693a9fbc"));
                        startActivity(intent);
                    }else if (position2 == 9) {

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.ajkerpatrika.com/347018"));
                        startActivity(intent);
                    }else if (position2 == 10) {

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.bbc.com/bengali/articles/cx82vq0eygvo"));
                        startActivity(intent);
                    }
                }
            });






            // data parsing

            HashMap<String,String> hashMap2 = MyarrayList.get(position2);

            String getImg = hashMap2.get("newsImg");
            String getTitle = hashMap2.get("title");
            String getChannelName = hashMap2.get("channelName");





            //item er identity

            ImageView newsImg = myView2.findViewById(R.id.newsImg);
            TextView newsTitle = myView2.findViewById(R.id.newsTitle);
            TextView channelName = myView2.findViewById(R.id.channelName);




/*

            // img set kora drawable theke ==================================
            int imgDrawable = Integer.parseInt(getImg);
            imgSetId.setImageResource(imgDrawable);
*/

            // img set kora online link theke ==================================
            Picasso.get()
                    .load(getImg)
                    .into(newsImg);

            // set
            newsTitle.setText(getTitle);
            channelName.setText(getChannelName);


            return myView2;
        }

    }//baseAdapter end

    private void fileList(String newText) {
        ArrayList<HashMap<String, String>> arrayList1 = new ArrayList<>();
        for (HashMap<String, String> newHashmap : newsArrayList) {
            if (newHashmap.get("title").toLowerCase().contains(newText.toLowerCase())) {
                arrayList1.add(newHashmap);
            }
        }
        if (arrayList1.isEmpty()) {
            Toast.makeText(NewsActivity.this, "খুঁজে পাওয়া যায় নি", Toast.LENGTH_SHORT).show();
        } else {
            newsAdapter.setFilteredList(arrayList1);
        }
    }

    private void NewsList(){


        newsHashMap1 = new HashMap<>();
        newsHashMap1.put("newsImg", "https://upload.wikimedia.org/wikipedia/commons/c/cc/7.Bangladesh_quota_reform_movement_2024.jpg");
        newsHashMap1.put("title","২০২৪-এ বাংলাদেশে কোটা সংস্কার আন্দোলন");
        newsHashMap1.put("channelName","উইকিপিডিয়া, মুক্ত বিশ্বকোষ থেকে");
        newsArrayList.add(newsHashMap1);


        newsHashMap1 = new HashMap<>();
        newsHashMap1.put("newsImg", "https://ichef.bbci.co.uk/ace/ws/800/cpsprodpb/d1e8/live/6f7bece0-5bdc-11ef-b970-9f202720b57a.jpg.webp");
        newsHashMap1.put("title","ধানমন্ডি ৩২ নম্বর ও আশপাশে ১৫ই অগাস্ট ঘটনাগুলো থামানো যায়নি কেন?");
        newsHashMap1.put("channelName","বিবিসি নিউজ বাংলা");
        newsArrayList.add(newsHashMap1);


        newsHashMap1 = new HashMap<>();
        newsHashMap1.put("newsImg", "https://cdn.jagonews24.com/media/imgAllNew/BG/2023March/quotaa-20240807161419-20240816022635.jpg");
        newsHashMap1.put("title","আন্দোলনে হতাহতদের পূর্ণাঙ্গ তালিকা তৈরিতে ১৩ সদস্যের কমিটি");
        newsHashMap1.put("channelName","জাগো নিউজ");
        newsArrayList.add(newsHashMap1);


        newsHashMap1 = new HashMap<>();
        newsHashMap1.put("newsImg", "https://d2u0ktu8omkpf6.cloudfront.net/125ed125372927f2e079b6443d50ceb280df2bc00166d3c2.jpg");
        newsHashMap1.put("title","কোটা আন্দোলন লাইভ আপডেট: বৃহস্পতিবার সারাদেশে‘কমপ্লিট শাটডাউন’");
        newsHashMap1.put("channelName","নিউজ সময়");
        newsArrayList.add(newsHashMap1);

        newsHashMap1 = new HashMap<>();
        newsHashMap1.put("newsImg", "https://images.prothomalo.com/prothomalo-bangla%2F2024-07%2F3e85f4ef-94c2-4e64-8acc-dab4fc300e29%2Fabu_syed%20pic.JPG");
        newsHashMap1.put("title","কোটা আন্দোলনের টাইমলাইন: এত দিন যা যা ঘটেছে");
        newsHashMap1.put("channelName","প্রথম আলো");
        newsArrayList.add(newsHashMap1);



        newsHashMap1 = new HashMap<>();
        newsHashMap1.put("newsImg", "https://i.ytimg.com/vi/l6vM1gtzbL0/hq720.jpg");
        newsHashMap1.put("title","কোটা আন্দোলনে যারা শহীদ হয়েছেন | Abu Sayed | Mir Mugdho | Quota Andolon 2024 ");
        newsHashMap1.put("channelName","Toxic Video");
        newsArrayList.add(newsHashMap1);


        newsHashMap1 = new HashMap<>();
        newsHashMap1.put("newsImg", "https://images.prothomalo.com//prothomalo-bangla/2024-07-31/2wbojrkk/Mugdho-killed-01.jpg");
        newsHashMap1.put("title","কোটা সংস্কার আন্দোলনে নিহত ফ্রিল্যান্সার মুগ্ধকে নিয়ে ফাইভআরের শোক বার্তা");
        newsHashMap1.put("channelName","প্রথম আলো");
        newsArrayList.add(newsHashMap1);

        newsHashMap1 = new HashMap<>();
        newsHashMap1.put("newsImg", "https://dailyinqilab.com/mediaStorage/content/images/2024July/untitled-1-20240716204135.jpg");
        newsHashMap1.put("title","কোটা সংস্কার আন্দোলন: সংঘর্ষে নিহত বেড়ে ৬");
        newsHashMap1.put("channelName","দৈনিক ইনকিলাব");
        newsArrayList.add(newsHashMap1);


        newsHashMap1 = new HashMap<>();
        newsHashMap1.put("newsImg", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVlsOrv3u8Te0R9kBKttdlxA5Oc2PV8ZVKRA&s");
        newsHashMap1.put("title","কোটা সংস্কার আন্দোলন চলবে: বৈষম্যবিরোধী ছাত্র আন্দোলন");
        newsHashMap1.put("channelName","সময়ের কণ্ঠস্বর");
        newsArrayList.add(newsHashMap1);



        newsHashMap1 = new HashMap<>();
        newsHashMap1.put("newsImg", "https://cdn.ajkerpatrica.net/contents/cache/images/640x0x1/uploads/media/2024/07/16/9100677491da5676833c0b3a54af9cf2-6695dc5c38bc4.jpg");
        newsHashMap1.put("title","কোটা সংস্কার আন্দোলন: এবার কঠোর হাতে দমন করবে সরকার");
        newsHashMap1.put("channelName","আজকের পত্রিকা");
        newsArrayList.add(newsHashMap1);

        newsHashMap1 = new HashMap<>();
        newsHashMap1.put("newsImg", "https://ichef.bbci.co.uk/ace/ws/640/cpsprodpb/b2ae/live/b7645ec0-4c14-11ef-9499-4ffd3097e0d3.jpg.webp");
        newsHashMap1.put("title","কোটা সংস্কার আন্দোলন নিয়ে আন্তর্জাতিক প্রতিক্রিয়া কেমন ছিল? - BBC News বাংলা");
        newsHashMap1.put("channelName","BBC News বাংলা");
        newsArrayList.add(newsHashMap1);






    }




}//===================