package dialog.lqwang.com.customdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {
    private Button show;
    private Button hide;
    private static final String SERVICE_LINES = "021-24099095";
    private Dialog callDialog;//客服电话的dialog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (Button) findViewById(R.id.show);
        hide = (Button) findViewById(R.id.hide);
        show.setOnClickListener(this);
        hide.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case  R.id.show:
              showCallDialog();
              break;
          case R.id.hide:
              cancelCallDialog();
              break;
      }
    }


    private void showCallDialog(){
        if(callDialog == null){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = View.inflate(this,R.layout.alert_dialog,null);
            builder.setView(view);
//            builder.setPositiveButton("拨打",new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                    Intent intent = new Intent(Intent.ACTION_CALL);
//                    Uri data = Uri.parse("tel:"+SERVICE_LINES.replaceAll("-",""));
//                    intent.setData(data);
//                    startActivity(intent);
//                }
//            });
//
//            builder.setNegativeButton("取消",new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                }
//            });
            callDialog = builder.create();
        }
        callDialog.show();
    }

    private void cancelCallDialog(){
        if(callDialog != null && callDialog.isShowing()){
            callDialog.dismiss();
        }
    }
}
