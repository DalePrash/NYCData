package com.example.nycdata.via_java_mvp.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nycdata.R;

public class NYCDetailActivity extends AppCompatActivity {
     RecyclerView recyclerView;
     TextView dbn;
     TextView schoolName;
     TextView sat;
     void  toolb() {
          Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarMenuDetail);
          toolbar.setTitle("NYC   DETAIL");
          setSupportActionBar(toolbar);
          getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     }
     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_detail_b);
          toolb();
           dbn = findViewById(R.id.text_dnb);
           schoolName = findViewById(R.id.textschoolNamedetails);
          sat = findViewById(R.id.text_sat);
           Bundle bundle = getIntent().getExtras();
          if(bundle.getString("dbn")!= null) {
               dbn.setText(bundle.getString("dbn"));
          }
          if(bundle.getString("sc_name")!= null) {
               schoolName.setText(bundle.getString("sc_name"));
          }
          if(bundle.getString("sat")!= null) {
               sat.setText(bundle.getString("sat"));
          }
     }


     @Override
     public void onBackPressed() {
          super.onBackPressed();
          finish();
     }
     @Override
     public boolean onOptionsItemSelected(MenuItem item)
     { switch (item.getItemId()) {
               case android.R.id.home:
                    onBackPressed();
                    return true;
               default:
                    return super.onOptionsItemSelected(item);
          }
     }

}
