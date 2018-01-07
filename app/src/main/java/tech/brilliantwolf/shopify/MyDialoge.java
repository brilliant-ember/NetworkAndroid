package tech.brilliantwolf.shopify;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mohammed Al on 1/7/2018.
 */

public class MyDialoge extends DialogFragment {
    String name;
    String type;
    Bitmap img;

    public void takeProductFeatures(String name, String type, Bitmap img){
        this.img = img;
        this.name=name;
        this.type = type;
    }
    @Override
    // run takeProductFeatures b4 this method
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialoge_product,null);

        builder.setView(view).setTitle("The Product")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        TextView n = view.findViewById(R.id.textView);
        n.setText(name);
        TextView t =view.findViewById(R.id.textView2);
        t.setText(type);
        ImageView i = view.findViewById(R.id.imageView);
        i.setImageBitmap(img);
        return builder.create();
    }
}
