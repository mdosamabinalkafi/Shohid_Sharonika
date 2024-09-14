package com.oaksoftstudio.ourpride;

import static androidx.core.content.ContextCompat.getSystemService;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;


public class HomeFragment extends Fragment {


    ImageSlider imageSlider;
    RelativeLayout shohidClick,enemyClick;

    GridView gridView;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap <String, String> hashMap;

    ListView listView;
    ArrayList<HashMap<String, String>> arrayList2 = new ArrayList<>();
    HashMap <String, String> hashMap2;

    GridView gridView3;
    ArrayList<HashMap<String, String>> arrayList3 = new ArrayList<>();
    HashMap <String, String> hashMap3;

    RelativeLayout newsBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View homeView = inflater.inflate(R.layout.fragment_home, container, false);









        gridView = homeView.findViewById(R.id.gridView);
        ShohidList();
        MyBaseAdapter adapter = new MyBaseAdapter();
        gridView.setAdapter(adapter);




        listView = homeView.findViewById(R.id.listView);
        NewsList();
        MyBaseAdapter2 adapter2 = new MyBaseAdapter2();
        listView.setAdapter(adapter2);






        gridView3 = homeView.findViewById(R.id.gridView3);
        EnemyList();
        MyBaseAdapter3 adapter3 = new MyBaseAdapter3();
        gridView3.setAdapter(adapter3);






        newsBtn = homeView.findViewById(R.id.newsBtn);
        newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getActivity(),NewsActivity.class));




            }
        });


        shohidClick = homeView.findViewById(R.id.shohidClick);
        shohidClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(),ShohidActivity.class));



            }
        });

        enemyClick = homeView.findViewById(R.id.enemyClick);
        enemyClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getActivity(),EnemyActivity.class));



            }
        });
        



        imageSlider = homeView.findViewById(R.id.image_slider);

        ArrayList<SlideModel> imageList = new ArrayList<>();
/*
        String imgUrl1 = "https://firebasestorage.googleapis.com/v0/b/runa-bhobon-c6412.appspot.com/o/image_slider%2F20221120_045340-01.jpeg?alt=media&token=80c57169-2d3a-423d-8c5c-2261c7bf6bc0";
        String imgUrl2 = "https://firebasestorage.googleapis.com/v0/b/runa-bhobon-c6412.appspot.com/o/image_slider%2F20221120_045340-01.jpeg?alt=media&token=80c57169-2d3a-423d-8c5c-2261c7bf6bc0";
       */

        imageList.add(new SlideModel(R.drawable.images2, ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.images1, ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.images3,ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.images4,ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.images5, ScaleTypes.CENTER_CROP));

        imageSlider.setImageList(imageList);






        return homeView;

    }//===============================


    public class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
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

            LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder")
            View myView = layoutInflater.inflate(R.layout.photo_card, parent, false);


            @SuppressLint({"MissingInflatedId", "LocalSuppress"})
            RelativeLayout shohidBtn = myView.findViewById(R.id.shohidBtn);





            // data parsing

            HashMap <String,String> hashMap = arrayList.get(position);

            String getImg = hashMap.get("shohidPic");

            String getName = hashMap.get("shohidName");
            String getTagline = hashMap.get("shohidTagline");

            String getAge = hashMap.get("shohidAge");
            String getVarsity = hashMap.get("shohidVarsity");
            String getDeath = hashMap.get("shohidDeath");
            String getPlace = hashMap.get("shohidPlace");
            String getLifestyle = hashMap.get("shohidLifestyle");
            String getDescribe = hashMap.get("shohidDescribe");

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

                    Intent myIntent = new Intent(getActivity(),ShohidDescribe.class);
                    startActivity(myIntent);
                }
            });





            //item er identity

            ImageView imgSetId = myView.findViewById(R.id.imgSetId);
            TextView nameSetId = myView.findViewById(R.id.nameSetId);
            TextView taglineSetId = myView.findViewById(R.id.taglineSetId);



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


    private void ShohidList(){


        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/abu-sayed.jpg");
        hashMap.put("shohidName","আবু সাইদ");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        // chap dewar por porer page a jegula show korbe sesob data
        hashMap.put("shohidAge","২৩ বছর");
        hashMap.put("shohidVarsity","বেগম রোকেয়া বিশ্ববিদ্যালয়, রংপুর");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি");
        hashMap.put("shohidDeath","১৬ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","বাবনপুর, পীরগঞ্জ, রংপুর");
        hashMap.put("shohidLifestyle","রোকেয়া বিশ্ববিদ্যালয়ের ইংরেজি বিভাগের ১২তম ব্যাচের শিক্ষার্থী আবু সাঈদ ২০০১ সালে রংপুর জেলার পীরগঞ্জ উপজেলার বাবনপুর গ্রামে জন্মগ্রহণ করেন। মকবুল হোসেন এবং মনোয়ারা বেগমের ছয় ছেলে ও তিন মেয়ের মধ্যে আবু সাঈদ ছিলেন সবার ছোট। তিনি স্থানীয় জাফর পাড়া সরকারি প্রাথমিক বিদ্যালয় থেকে পঞ্চম শ্রেণিতে ট্যালেন্টপুলে বৃত্তি পেয়ে স্থানীয় খালাশপীর দ্বিমুখী উচ্চ বিদ্যালয় ভর্তি হন এবং এখান থেকে জি‌পিএ-৫ পে‌য়ে এসএসসি পাশ করে ২০১৮ সালে রংপুর সরকা‌রি কলেজে ভর্তি হন। এখান থেকে জি‌পিএ-৫ পেয়ে ইন্টারমিডিয়েট পাশ করে ২০২০ সালে বেগম রো‌কেয়া‌ বিশ্ব‌বিদ্যাল‌য়ে ইং‌রে‌জি বিভাগে ভ‌র্তি হন।");
        hashMap.put("shohidDescribe","১৬ জুলাই দুপুর আড়াইটা থেকে তিনটার দিকে রোকেয়া বিশ্ববিদ্যালয়ের সামনে কোটা সংস্কার আন্দোলনের শিক্ষার্থীদের শান্তিপূর্ণ সমাবেশে ছাত্রদের ছত্রভঙ্গ করার জন্য পুলিশ টিয়ার গ্যাস নিক্ষেপ ও লাঠিচার্জ করলে, ছাত্রদের সবাই স্থান ত্যাগ করলেও আবু সাঈদ হাতে একটি লাঠি নিয়ে দাঁড়িয়ে থাকেন। পুলিশ এই অবস্থায় তার উপরে গুলি ছুড়লে, হাতে থাকা লাঠি দিয়ে রাবার বুলেট ঠেকানোর চেষ্টা করছিলেন। একপর্যায়ে শরীরে একের পর রাবার বুলেটে ক্ষতবিক্ষত হওয়ার পর মাটিতে লুটিয়ে পড়েন আবু সাঈদ। হাসপাতালে নেয়ার আগেই তিনি মৃত্যুবরণ করেন।");
        arrayList.add(hashMap);




        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/shykh-aashhabul-yamin.jpg");
        hashMap.put("shohidName","শাইখ আশহাবুল ইয়ামিন");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","২২ বছর");
        hashMap.put("shohidVarsity","মিলিটারি ইনস্টিটিউট অফ সায়েন্স অ্যান্ড টেকনোলজি, ঢাকা");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","কুমারখালী, কুষ্টিয়া, খুলনা");
        hashMap.put("shohidLifestyle","ইয়ামিন সাভার ক্যান্টনমেন্ট স্কুল অ্যান্ড কলেজ থেকে এসএসসি ও এইচএসসি পাস করেন। তিনি রাজধানীর মিরপুরের মিলিটারি ইনস্টিটিউট অব সায়েন্স অ্যান্ড টেকনোলজির (এমআইএসটি) কম্পিউটারবিজ্ঞান ও প্রকৌশল বিভাগের চতুর্থ বর্ষের শিক্ষার্থী ছিলেন, থাকতেন এমআইএসটির ওসমানী হলে। ইয়ামিন সাহসী ছিলেন। অন্যায় দেখলেই প্রতিবাদ করতেন। ইয়ামিন অত্যন্ত মেধাবী ছিলেন। বন্ধুরা কোনো বিষয় বুঝতে না পারলে ইয়ামিন বুঝিয়ে দিতেন। ইয়ামিন বিতর্ক করতেন। এমআইএসটিতে বিতর্ক ক্লাবের ভাইস প্রেসিডেন্ট ছিলেন ইয়ামিন। ছেলে বড় হলেও অবসরে ছোট বাচ্চাদের মতো ‘টম অ্যান্ড জেরি’ থেকে শুরু করে বিভিন্ন কার্টুন দেখতেন বলে জানান তার বাবা।");
        hashMap.put("shohidDescribe","পুলিশের গুলিতে নিহত");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/farhan-faiyaaz.jpg");
        hashMap.put("shohidName","ফারহান ফাইয়াজ");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","১৭ বছর");
        hashMap.put("shohidVarsity","ঢাকা রেসিডেনসিয়াল মডেল কলেজ, মোহাম্মদপুর");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি");
        hashMap.put("shohidLifestyle","ফারহান ফাইয়াজ এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","ফারহান ফাইয়াজ কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("shohidPic", "https://shohid.info/shohid/mir-mugdho.jpg");
        hashMap.put("shohidName","মীর মুগ্ধ");
        hashMap.put("shohidTagline","শিক্ষার্থী");

        hashMap.put("shohidAge","তথ্য পাওয়া যায় নি");
        hashMap.put("shohidVarsity","বাংলাদেশ ইউনিভার্সিটি অফ প্রফেশনালস");
        hashMap.put("shohidDob","তথ্য পাওয়া যায় নি");
        hashMap.put("shohidDeath","১৮ জুলাই, ২০২৪");
        hashMap.put("shohidPlace","তথ্য পাওয়া যায় নি");
        hashMap.put("shohidLifestyle","মীর মুগ্ধ এর ব্যক্তিগত তথ্য খোঁজার কাজ চলমান। আপনার কাছে উনার সম্পর্কে তথ্য থাকলে, আমাদের দিয়ে সাহায্য করুন।");
        hashMap.put("shohidDescribe","মীর মুগ্ধ কি ভাবে মারা গিয়েছেন এই বিষয়ে পর্যাপ্ত তথ্য পাওয়া যায় নি, তথ্য খোঁজার কাজ চলমান।");
        arrayList.add(hashMap);






    }


    public class MyBaseAdapter2 extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList2.size();
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

            LayoutInflater layoutInflater2 = (LayoutInflater) getActivity(). getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
                }
            });






            // data parsing

            HashMap <String,String> hashMap2 = arrayList2.get(position2);

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


    private void NewsList(){


        hashMap2 = new HashMap<>();
        hashMap2.put("newsImg", "https://upload.wikimedia.org/wikipedia/commons/c/cc/7.Bangladesh_quota_reform_movement_2024.jpg");
        hashMap2.put("title","২০২৪-এ বাংলাদেশে কোটা সংস্কার আন্দোলন");
        hashMap2.put("channelName","উইকিপিডিয়া, মুক্ত বিশ্বকোষ থেকে");
        arrayList2.add(hashMap2);


        hashMap2 = new HashMap<>();
        hashMap2.put("newsImg", "https://ichef.bbci.co.uk/ace/ws/800/cpsprodpb/d1e8/live/6f7bece0-5bdc-11ef-b970-9f202720b57a.jpg.webp");
        hashMap2.put("title","ধানমন্ডি ৩২ নম্বর ও আশপাশে ১৫ই অগাস্ট ঘটনাগুলো থামানো যায়নি কেন?");
        hashMap2.put("channelName","বিবিসি নিউজ বাংলা");
        arrayList2.add(hashMap2);


        hashMap2 = new HashMap<>();
        hashMap2.put("newsImg", "https://cdn.jagonews24.com/media/imgAllNew/BG/2023March/quotaa-20240807161419-20240816022635.jpg");
        hashMap2.put("title","আন্দোলনে হতাহতদের পূর্ণাঙ্গ তালিকা তৈরিতে ১৩ সদস্যের কমিটি");
        hashMap2.put("channelName","জাগো নিউজ");
        arrayList2.add(hashMap2);






    }


    public class MyBaseAdapter3 extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList3.size();
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

            LayoutInflater layoutInflater3 = (LayoutInflater)getActivity(). getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder")
            View myView3 = layoutInflater3.inflate(R.layout.enemy_card, parent3, false);


            //  @SuppressLint({"MissingInflatedId", "LocalSuppress"})
            //RelativeLayout newsBtn = myView3.findViewById(R.id.newsBtn);





            // data parsing

            HashMap<String,String> hashMap3 = arrayList3.get(position3);

            String getImg = hashMap3.get("enemyImg");
            String getName = hashMap3.get("enemyName");
            String getTagline = hashMap3.get("enemyTagline");
            String getCase = hashMap3.get("enemyCase");





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


    private void EnemyList(){


        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/%E0%A6%AE%E0%A7%87%E0%A6%B9%E0%A7%87%E0%A6%A6%E0%A7%80-%E0%A6%B9%E0%A6%BE%E0%A6%B8%E0%A6%BE%E0%A6%A8-%E0%A6%95%E0%A6%BE%E0%A6%89%E0%A6%B8%E0%A6%BE%E0%A6%B0_01.jpg");
        hashMap3.put("enemyName","মেহেদী হাসান কাওসার সজীব");
        hashMap3.put("enemyTagline","সাবেক সিনিয়র সহ-সভাপতি, ১ম ওয়ার্ড ছাত্রলীগ, ঢাকা মহানগর উত্তর");
        hashMap3.put("enemyCase","কেস: 2024 সালের 2 আগস্ট উত্তরা-11-এ মহিলা বিক্ষোভকারীদের গলা টিপে ধরে শারীরিকভাবে আক্রমণ করা হয়।");
        arrayList3.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/453416957_1029233582094707_4124007712039784583_n-1.jpg");
        hashMap3.put("enemyName","রেদোয়ানুল ইসলাম");
        hashMap3.put("enemyTagline","লেফটেন্যান্ট কর্নেল");
        hashMap3.put("enemyCase","কেস: 27 জুলাই, 2024-এ রামপুরা ওভারব্রিজের নীচে খুব কাছ থেকে বিক্ষোভকারীদের উপর AK47 রাইফেলের রাউন্ড (বুক বরাবর) গুলি করা হয়েছিল");
        arrayList3.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Abdur-Razzak-Jewel_03.webp");
        hashMap3.put("enemyName","আব্দুর রাজ্জাক জুয়েল");
        hashMap3.put("enemyTagline","সহ-সভাপতি, উত্তরা পশ্চিম থানা ছাত্রলীগ, ঢাকা মোহনগোর উত্তর");
        hashMap3.put("enemyCase","কেস: ছাত্রলীগের সদস্যদের নির্দেশনা দিয়ে সাধারণ ছাত্রদের মারধর করা হয় এবং বলতে দেখা যায়, 33 জুলাই, 2024 তারিখে উত্তরায় গুলি করে মেরে ফেলব।");
        arrayList3.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/rakib-hassan-ratul_05.jpeg");
        hashMap3.put("enemyName","রাকিব হাসান রাতুল");
        hashMap3.put("enemyTagline","তথ্য পাওয়া যায়নি");
        hashMap3.put("enemyCase","কেস: 2 আগস্ট, 2024-এ উত্তরা-11-এ প্রাণঘাতী অস্ত্রের সাথে দেখা হয়েছে।");
        arrayList3.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Junayet-Al-Habib_06.webp");
        hashMap3.put("enemyName","জুনায়েত আল হাবিব (লিওন খান)");
        hashMap3.put("enemyTagline","সাংগঠনিক সম্পাদক, বিএসএল, ঢাকা মেট্রোপলিটন উত্তর");
        hashMap3.put("enemyCase","কেস: 2 আগস্ট, 2024-এ উত্তরা সেক্টর 11-এ লাঠি হাতে BSL সদস্যদের নিয়ে একটি মিছিলের সাথে দেখা গেছে।");
        arrayList3.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/452276952_1210306950119541_381565650964526671_n.jpg");
        hashMap3.put("enemyName","সাকিব আরাফাত মৃধা");
        hashMap3.put("enemyTagline","ছাত্র (রাজনীতি বিজ্ঞান, ডু- 2019-20 সেশন)");
        hashMap3.put("enemyCase","কেস: ঢাকা বিশ্ববিদ্যালয়ে ১৫ জুলাই হত্যাকাণ্ডের হামলাকারী দলের সঙ্গে দেখা গেছে।");
        arrayList3.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Yunus-Ali_08.jpg");
        hashMap3.put("enemyName","ইউনুস আলী");
        hashMap3.put("enemyTagline","সাব-ইন্সপেক্টর");
        hashMap3.put("enemyCase","কেস: 2024 সালের 16 জুলাই রংপুরে আবু সাঈদকে গুলি করে।");
        arrayList3.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Byazid_09.jpeg");
        hashMap3.put("enemyName","বায়াজিদ");
        hashMap3.put("enemyTagline","তথ্য পাওয়া যায়নি");
        hashMap3.put("enemyCase","কেস: একজন পথচারীকে উপহাস করে একটি TikTok ভিডিও তৈরি করেছে পুলিশ");
        arrayList3.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/MD-Arshad-Hossain-Akash_2unverified-1.jpg");
        hashMap3.put("enemyName","আরশাদ হোসেন আকাশ");
        hashMap3.put("enemyTagline","ভারপ্রাপ্ত কর্মকর্তা (পুলিশ)");
        hashMap3.put("enemyCase","কেস: কথা বলতে বাধা দিতে তিনি এক ছাত্রের মুখ চেপে ধরেন। স্পষ্ট করার জন্য, ছাত্রটি শান্তভাবে কথা বলার চেষ্টা করেছিল এবং সশস্ত্র ছিল না।");
        arrayList3.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Abdullah-Kaiyum_11.jpg");
        hashMap3.put("enemyName","আবদুল্লাহ কাইয়ুম (কাইয়ুম মোল্লা)");
        hashMap3.put("enemyTagline","তথ্য পাওয়া যায়নি");
        hashMap3.put("enemyCase","কেস: বাঁশের অস্ত্র নিয়ে পেছন থেকে নিরস্ত্র নারী বিক্ষোভকারীদের ওপর হামলা চালায়");
        arrayList3.add(hashMap3);


        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Apurbo-Hasan_12.png");
        hashMap3.put("enemyName","অপূর্ব হাসান");
        hashMap3.put("enemyTagline","অফিসার ইনচার্জ, পল্লবী থানা, ডিএমপি, ঢাকা");
        hashMap3.put("enemyCase","কেস: বিক্ষোভকারীদের জিজ্ঞাসা, “আমরা তাকে হত্যা করেছি। তুমি কি করবে?");
        arrayList3.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Ashraful-Hasan-Mohon_22.jpg");
        hashMap3.put("enemyName","আশরাফুল হাসান মোহন");
        hashMap3.put("enemyTagline","যুগ্ম আহ্বায়ক, ফেনী পৌর সেচ্ছাসেবক লীগ");
        hashMap3.put("enemyCase","কেস: ফেনীতে নেতৃস্থানীয় গুন্ডাদের মারাত্মক অস্ত্র বহন করতে দেখা গেছে");
        arrayList3.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Depak-Saha_12.jpg");
        hashMap3.put("enemyName","দীপক সাহা");
        hashMap3.put("enemyTagline","ওএমএস ডিলার, নরসিংদী");
        hashMap3.put("enemyCase","কেস: নিরস্ত্র এক নারীকে শারীরিকভাবে লাঞ্ছিত করেছে।");
        arrayList3.add(hashMap3);

        hashMap3 = new HashMap<>();
        hashMap3.put("enemyImg", "https://chinerakhun.com/wp-content/uploads/2024/08/Anjuman-Rahman-Richi_13.jpg");
        hashMap3.put("enemyName","আঞ্জুমান রহমান রিচি");
        hashMap3.put("enemyTagline","মহিলা ভাইস চেয়ারম্যান, নরসিংদী, উপজেলা");
        hashMap3.put("enemyCase","কেস: অন্যান্য বিএএল সদস্যদের সাথে একজন নিরস্ত্র মহিলাকে শারীরিকভাবে লাঞ্ছিত করেছে।");
        arrayList3.add(hashMap3);




    }


}//=================================