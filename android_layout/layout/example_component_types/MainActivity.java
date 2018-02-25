package com.example.ksx.helloworld;

//import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

public class MainActivity extends Activity{//AppCompatActivity {//Activity{
   
    private  ImageView  imageView;
    private ProgressBar progressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creat a button listener
        Button button1=(Button) findViewById(R.id.button_1);
        imageView=(ImageView) findViewById(R.id.image_view);
        progressbar=(ProgressBar) findViewById(R.id.progress_bar);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this,"Y click bu 1",Toast.LENGTH_SHORT).show();
                
                  AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                  dialog.setTitle("this is a dialog");
                  dialog.setMessage("something important");
                  dialog.setCancelable(false);
                  dialog.setPositiveButton("OK",new DialogInterface.OnClickListener(){
					  @Override
					  public void onClick(DialogInterface dialog,int which){
						  imageView.setImageResource(R.drawable.img2);
					  }
				  });
				  dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
					  @Override
					  public void onClick(DialogInterface dialog,int which){
						  ProgressDialog progressDialog=new ProgressDialog (MainActivity.this);
						  progressDialog.setTitle("this is a ProgressDialog");
						  progressDialog.setMessage("Loading..");
						  progressDialog.setCancelable(false);
						  progressDialog.show();
						  
					  }
				  });
				  dialog.show();
				  
            }
        });
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main,menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "you click add", Toast.LENGTH_SHORT).show();
                if(progressbar.getVisibility()==View.GONE){
					progressbar.setVisibility(View.VISIBLE);
				}
				else
				{
					progressbar.setVisibility(View.GONE);
				}
                //Log.d("firstapp","click add");

                break;
            case R.id.remove_item:
                Toast.makeText(this, "you click remove", Toast.LENGTH_SHORT).show();
                 int progress=progressbar.getProgress();
                 progress=progress+10;
                 progressbar.setProgress(progress);
                break;
            default:
        }
        return  true;
    }

}
