package com.lfcpulse.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {
    final int RED = Color.rgb(200, 16, 46), DARK = Color.rgb(18, 20, 22), MUTED = Color.rgb(170, 175, 180);
    LinearLayout root, content;
    @Override public void onCreate(Bundle b) { super.onCreate(b); getWindow().setStatusBarColor(DARK); getWindow().setNavigationBarColor(DARK); show("Home"); }
    TextView text(String s, int size, int color, boolean bold) { TextView t=new TextView(this); t.setText(s); t.setTextSize(size); t.setTextColor(color); if(bold)t.setTypeface(null,Typeface.BOLD); return t; }
    void show(String page) {
        root=new LinearLayout(this); root.setOrientation(1); root.setBackgroundColor(DARK); root.setPadding(20,22,20,14);
        TextView brand=text("🔴  LFC PULSE",24,Color.WHITE,true); root.addView(brand);
        TextView tagline=text("EVERYTHING LIVERPOOL. EVERY HEARTBEAT.",10,MUTED,true); tagline.setPadding(2,3,0,18); root.addView(tagline);
        ScrollView scroll=new ScrollView(this); content=new LinearLayout(this); content.setOrientation(1); scroll.addView(content); root.addView(scroll,new LinearLayout.LayoutParams(-1,0,1));
        if(page.equals("Home")) home(); else if(page.equals("Fixtures")) panel("FIXTURES","Upcoming Liverpool fixtures will appear here when a live fixture data source is connected."); else if(page.equals("News")) panel("LATEST NEWS","Liverpool headlines and transfer updates will appear here when a verified news feed is connected."); else panel("LIVE CENTRE","Live match scores and match events will appear here when a live football data source is connected.");
        LinearLayout nav=new LinearLayout(this); nav.setGravity(Gravity.CENTER); nav.setPadding(0,14,0,4);
        String[] names={"Home","Fixtures","News","Live"}; for(String n:names){ TextView item=text(n,13,n.equals(page)?Color.WHITE:MUTED,true); item.setGravity(Gravity.CENTER); item.setPadding(8,12,8,12); item.setBackgroundColor(n.equals(page)?RED:DARK); LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(0,-2,1); p.setMargins(3,0,3,0); nav.addView(item,p); item.setOnClickListener(v->show(n)); }
        root.addView(nav); setContentView(root);
    }
    void home(){
        TextView welcome=text("WELCOME, REDS",13,RED,true); welcome.setPadding(0,8,0,12); content.addView(welcome);
        card("THE REDS","Your home for Liverpool FC. Follow the team, keep up with the latest stories and never miss a moment.");
        card("NEXT MATCH","Fixture information is not connected yet. Connect a football data provider to show confirmed kick-off times.");
        card("RECENT RESULTS","Match results will appear here once a verified results feed is configured.");
        card("TRANSFER WATCH","Transfer headlines and rumours will be displayed with source links when a news feed is connected.");
        card("MATCHDAY","Live scores, line-ups and match events are planned for a future connected release.");
        TextView note=text("VERSION 0.1  •  EARLY BUILD",10,MUTED,false); note.setPadding(2,18,0,8); content.addView(note);
    }
    void panel(String title,String body){card(title,body);}
    void card(String title,String body){ LinearLayout box=new LinearLayout(this); box.setOrientation(1); box.setPadding(16,16,16,16); box.setBackgroundColor(Color.rgb(32,35,38)); LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(-1,-2); lp.setMargins(0,0,0,12); content.addView(box,lp); box.addView(text(title,14,RED,true)); TextView b=text(body,14,Color.WHITE,false); b.setPadding(0,9,0,0); box.addView(b); }
}
