package tw.edu.pu.s1072767.findanimals;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(MainActivity.this, bgmusic.class);
        String action = bgmusic.ACTION_MUSIC;
        intent.setAction(action);
        startService(intent);
    }

    public void quit(View view) {
        AlertDialog.Builder alertdialogbuilder=new AlertDialog.Builder(this);
        alertdialogbuilder.setMessage("確定要退出遊戲嗎？");
        alertdialogbuilder.setPositiveButton("確定",click1);
        alertdialogbuilder.setNegativeButton("取消",click2);
        AlertDialog alertdialog1=alertdialogbuilder.create();
        alertdialog1.show();
    }

    private DialogInterface.OnClickListener click1=new DialogInterface.OnClickListener() {
        @Override

        public void onClick(DialogInterface arg0,int arg1) {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    };

    private DialogInterface.OnClickListener click2=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface arg0,int arg1) {
            arg0.cancel();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (intent != null){
            // 对于intentService，这一步可能是多余的
            stopService(intent);
        }
    }
}


